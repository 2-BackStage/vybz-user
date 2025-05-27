package back.vybz.userservice.busker.application;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.dto.request.RequestAddBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerInfoDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerInfoDto;
import back.vybz.userservice.busker.infrastructure.BuskerInfoRepository;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.common.util.AmazonS3UploaderUtil;
import back.vybz.userservice.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuskerInfoServiceImpl implements BuskerInfoService {

    private final BuskerInfoRepository buskerInfoRepository;
    private final AmazonS3UploaderUtil amazonS3UploaderUtil;

    /**
     * 버스커 정보 추가
     *
     * @param requestAddBuskerInfoDto
     */
    @Transactional
    @Override
    public void createBuskerInfo(RequestAddBuskerInfoDto requestAddBuskerInfoDto) {
        if (buskerInfoRepository.existsByUserUuid(requestAddBuskerInfoDto.getUserUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_BUSKER);
        }

        String profileImageUrl = null;

        if (requestAddBuskerInfoDto.getProfileImageUrl() != null && !requestAddBuskerInfoDto.getProfileImageUrl().isEmpty()) {
            profileImageUrl = amazonS3UploaderUtil.upload(requestAddBuskerInfoDto.getProfileImageUrl(), "busker-profile");
        }

        buskerInfoRepository.save(requestAddBuskerInfoDto.toEntity(profileImageUrl));

    }

    /**
     * userUuid로 버스커 정보 조회
     *
     * @param userUuid
     */
    @Override
    public ResponseBuskerInfoDto getBuskerInfoByUserUuid(String userUuid) {
        BuskerInfo buskerInfo = buskerInfoRepository.findByUserUuidAndDeletedFalse(userUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER));
        return ResponseBuskerInfoDto.from(buskerInfo);
    }

    /**
     * 모든 버스커 정보 조회
     */
    @Override
    public List<ResponseBuskerInfoDto> getAllBuskerInfo() {
        return buskerInfoRepository.findAllByDeletedFalse()
                .stream()
                .map(ResponseBuskerInfoDto::from)
                .toList();
    }

    /**
     * 버스커 정보 수정
     *
     * @param requestUpdateBuskerInfoDto
     */
    @Transactional
    @Override
    public void updateBuskerInfo(RequestUpdateBuskerInfoDto requestUpdateBuskerInfoDto) {
        BuskerInfo buskerInfo = buskerInfoRepository.findByUserUuidAndDeletedFalse(requestUpdateBuskerInfoDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER));

        String imageUrl = null;
        MultipartFile profileImage = requestUpdateBuskerInfoDto.getProfileImageUrl();

        if (profileImage != null && !profileImage.isEmpty()) {
            Optional.ofNullable(buskerInfo.getProfileImageUrl())
                    .ifPresent(amazonS3UploaderUtil::delete);
            imageUrl = amazonS3UploaderUtil.upload(profileImage, "busker-profile");
        }
        requestUpdateBuskerInfoDto.updateEntity(buskerInfo, imageUrl);

    }

    /**
     * 버스커 정보 삭제
     *
     * @param requestDeleteBuskerInfoDto
     */
    @Transactional
    @Override
    public void deleteBuskerInfo(RequestDeleteBuskerInfoDto requestDeleteBuskerInfoDto) {
        BuskerInfo buskerInfo = buskerInfoRepository.findByUserUuidAndDeletedFalse(requestDeleteBuskerInfoDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER));
        buskerInfo.softDelete();
    }
}
