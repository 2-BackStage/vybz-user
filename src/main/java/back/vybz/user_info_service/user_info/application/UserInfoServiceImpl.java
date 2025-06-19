package back.vybz.user_info_service.user_info.application;

import back.vybz.user_info_service.common.entity.BaseResponseStatus;
import back.vybz.user_info_service.common.exception.BaseException;
import back.vybz.user_info_service.kafka.producer.DeleteUserInfoEventProducer;
import back.vybz.user_info_service.kafka.producer.UpdateUserInfoEventProducer;
import back.vybz.user_info_service.user_info.domain.UserInfo;
import back.vybz.user_info_service.user_info.dto.request.RequestAddUserInfoDto;
import back.vybz.user_info_service.user_info.dto.request.RequestDeleteUserInfoDto;
import back.vybz.user_info_service.user_info.dto.request.RequestUpdateUserInfoDto;
import back.vybz.user_info_service.user_info.dto.response.ResponseUserInfoDto;
import back.vybz.user_info_service.user_info.dto.response.ResponseUserProfileDto;
import back.vybz.user_info_service.user_info.infrastructure.UserInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class  UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UpdateUserInfoEventProducer updateUserInfoEventProducer;
    private final DeleteUserInfoEventProducer deleteUserInfoEventProducer;

    /**
     * 유저 정보 추가
     *
     * @param requestAddUserInfoDto
     */
    @Transactional
    @Override
    public void createUserInfo(RequestAddUserInfoDto requestAddUserInfoDto) {
        if (userInfoRepository.existsByUserUuid(requestAddUserInfoDto.getUserUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_USER);
        }
        userInfoRepository.save(requestAddUserInfoDto.toEntity());
    }

    /**
     * userUuid로 유저 정보 조회
     *
     * @param userUuid
     */
    @Override
    public ResponseUserInfoDto getUserInfoByUuid(String userUuid) {
        UserInfo userInfo = userInfoRepository.findByUserUuidAndDeletedFalse(userUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));
        return ResponseUserInfoDto.from(userInfo);
    }

    /**
     * 모든 유저 정보 조회
     */
    @Override
    public List<ResponseUserInfoDto> getAllUserInfo() {
        return userInfoRepository.findAll()
                .stream()
                .map(ResponseUserInfoDto::from)
                .toList();
    }

    /**
     * 유저 정보 수정
     *
     * @param requestUpdateUserInfoDto
     */
    @Transactional
    @Override
    public void updateUserInfo(RequestUpdateUserInfoDto requestUpdateUserInfoDto) {
        UserInfo userInfo = userInfoRepository.findByUserUuidAndDeletedFalse(requestUpdateUserInfoDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));
        userInfoRepository.save(requestUpdateUserInfoDto.updateEntity(userInfo));

        updateUserInfoEventProducer.sendUserInfoEvent(RequestUpdateUserInfoDto.toUserInfoEvent(userInfo));
    }

    /**
     * 유저 정보 삭제
     *
     * @param requestDeleteUserInfoDto
     */
    @Transactional
    @Override
    public void deleteUserInfo(RequestDeleteUserInfoDto requestDeleteUserInfoDto) {
        UserInfo userInfo = userInfoRepository.findByUserUuidAndDeletedFalse(requestDeleteUserInfoDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));
        userInfo.softDelete();

        deleteUserInfoEventProducer.sendUserInfoEvent(requestDeleteUserInfoDto.getUserUuid());
    }

    /**
     * 사용자 프로필 이미지, 닉네임 조회
     *
     * @param userUuid
     * @return
     */
    @Override
    public ResponseUserProfileDto getUserProfileByUuid(String userUuid) {

        UserInfo user = userInfoRepository.findByUserUuidAndDeletedFalse(userUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));

        return ResponseUserProfileDto.builder()
                .profileImageUrl(user.getProfileImageUrl())
                .nickname(user.getNickname())
                .build();
    }
}
