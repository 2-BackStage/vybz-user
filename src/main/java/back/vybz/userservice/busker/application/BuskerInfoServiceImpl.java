package back.vybz.userservice.busker.application;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.dto.request.RequestAddBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerInfoDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerInfoDto;
import back.vybz.userservice.busker.infrastructure.BuskerInfoRepository;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuskerInfoServiceImpl implements BuskerInfoService {

    private final BuskerInfoRepository buskerInfoRepository;

    /**
     * 버스커 정보 추가
     * @param requestAddBuskerInfoDto
     */
    @Transactional
    @Override
    public void createBuskerInfo(RequestAddBuskerInfoDto requestAddBuskerInfoDto) {
        if(buskerInfoRepository.existsByUserUuid(requestAddBuskerInfoDto.getUserUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_BUSKER);
        }
        buskerInfoRepository.save(requestAddBuskerInfoDto.toEntity());
    }

    /**
     * userUuid로 버스커 정보 조회
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
     * @param requestUpdateBuskerInfoDto
     */
    @Transactional
    @Override
    public void updateBuskerInfo(RequestUpdateBuskerInfoDto requestUpdateBuskerInfoDto) {
        BuskerInfo buskerInfo = buskerInfoRepository.findByUserUuidAndDeletedFalse(requestUpdateBuskerInfoDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER));
        buskerInfoRepository.save(requestUpdateBuskerInfoDto.updateEntity(buskerInfo));
    }

    /**
     * 버스커 정보 삭제
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
