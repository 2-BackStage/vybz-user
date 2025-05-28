package back.vybz.userservice.busker.application;

import back.vybz.userservice.busker.domain.mysql.BuskerSns;
import back.vybz.userservice.busker.dto.request.RequestAddBuskerSnsDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerSnsDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerSnsDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerSnsDto;
import back.vybz.userservice.busker.infrastructure.BuskerSnsRepository;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuskerSnsServiceImpl implements BuskerSnsService {

    private final BuskerSnsRepository buskerSnsRepository;

    /**
     * 버스커 SNS 생성
     * @param requestAddBuskerSnsDto
     */
    @Transactional
    @Override
    public void createBuskerSns(RequestAddBuskerSnsDto requestAddBuskerSnsDto) {
        if(buskerSnsRepository.existsByUserUuidAndSnsUrlAndDeletedFalse(requestAddBuskerSnsDto.getUserUuid(), requestAddBuskerSnsDto.getSnsUrl())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_BUSKER_SNS);
        }
        buskerSnsRepository.save(requestAddBuskerSnsDto.toEntity());
    }

    /**
     * 유저 UUID로 버스커 SNS 조회
     * @param userUuid
     */
    @Override
    public List<ResponseBuskerSnsDto> findBuskerSnsByUserUuid(String userUuid) {
        return buskerSnsRepository.findAllByUserUuidAndDeletedFalse(userUuid)
                .stream()
                .map(ResponseBuskerSnsDto::from)
                .toList();
    }

    /**
     * 버스커 sns 수정
     * @param requestUpdateBuskerSnsDto
     */
    @Transactional
    @Override
    public void updateBuskerSns(RequestUpdateBuskerSnsDto requestUpdateBuskerSnsDto) {
        if(buskerSnsRepository.existsByUserUuidAndSnsUrlAndDeletedFalse(requestUpdateBuskerSnsDto.getUserUuid(), requestUpdateBuskerSnsDto.getNewSnsUrl())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_BUSKER_SNS);
        }
        BuskerSns buskerSns = buskerSnsRepository.findByUserUuidAndSnsUrlAndDeletedFalse(requestUpdateBuskerSnsDto.getUserUuid(), requestUpdateBuskerSnsDto.getOldSnsUrl())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER_SNS));
        buskerSns.updateSnsUrl(requestUpdateBuskerSnsDto.getNewSnsUrl());
    }

    /**
     * 버스커 sns 삭제
     * @param requestDeleteBuskerSnsDto
     */
    @Transactional
    @Override
    public void deleteBuskerSns(RequestDeleteBuskerSnsDto requestDeleteBuskerSnsDto) {
        BuskerSns buskerSns = buskerSnsRepository.findByUserUuidAndSnsUrlAndDeletedFalse(requestDeleteBuskerSnsDto.getUserUuid(), requestDeleteBuskerSnsDto.getSnsUrl())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER_SNS));
        buskerSns.softDelete();
    }

}
