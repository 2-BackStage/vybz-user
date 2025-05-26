package back.vybz.userservice.user.application;

import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import back.vybz.userservice.user.domain.mysql.UserInfo;
import back.vybz.userservice.user.dto.request.RequestAddUserInfoDto;
import back.vybz.userservice.user.dto.request.RequestDeleteUserInfoDto;
import back.vybz.userservice.user.dto.request.RequestUpdateUserInfoDto;
import back.vybz.userservice.user.dto.response.ResponseUserInfoDto;
import back.vybz.userservice.user.dto.response.ResponseUserInfoListDto;
import back.vybz.userservice.user.infrastructure.UserInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    /**
     * 유저 정보 추가
     * @param requestAddUserInfoDto
     */
    @Transactional
    @Override
    public void createUserInfo(RequestAddUserInfoDto requestAddUserInfoDto) {
        if(userInfoRepository.existsByUserUuid(requestAddUserInfoDto.getUserUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_USER);
        }
        userInfoRepository.save(requestAddUserInfoDto.toEntity());
    }

    /**
     * userUuid로 유저 정보 조회
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
    public List<ResponseUserInfoListDto> getAllUserInfo() {
        List<UserInfo> userInfo = userInfoRepository.findAll();
        return userInfo.stream()
                .map(ResponseUserInfoListDto::from)
                .toList();
    }

    /**
     * 유저 정보 수정
     * @param requestUpdateUserInfoDto
     */
    @Transactional
    @Override
    public void updateUserInfo(RequestUpdateUserInfoDto requestUpdateUserInfoDto) {
        UserInfo userInfo = userInfoRepository.findByUserUuidAndDeletedFalse(requestUpdateUserInfoDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));
        userInfoRepository.save(requestUpdateUserInfoDto.updateEntity(userInfo));
    }

    /**
     * 유저 정보 삭제
     * @param requestDeleteUserInfoDto
     */
    @Transactional
    @Override
    public void deleteUserInfo(RequestDeleteUserInfoDto requestDeleteUserInfoDto) {
        UserInfo userInfo = userInfoRepository.findByUserUuidAndDeletedFalse(requestDeleteUserInfoDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));
        userInfo.softDelete();
    }
}
