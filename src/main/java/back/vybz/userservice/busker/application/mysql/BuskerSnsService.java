package back.vybz.userservice.busker.application.mysql;

import back.vybz.userservice.busker.dto.mysql.request.RequestAddBuskerSnsDto;
import back.vybz.userservice.busker.dto.mysql.request.RequestDeleteBuskerSnsDto;
import back.vybz.userservice.busker.dto.mysql.request.RequestUpdateBuskerSnsDto;
import back.vybz.userservice.busker.dto.mysql.response.ResponseBuskerSnsDto;

import java.util.List;

public interface BuskerSnsService {

    /**
     * 버스커 sns 생성
     * @param requestAddBuskerSnsDto
     */
    void createBuskerSns(RequestAddBuskerSnsDto requestAddBuskerSnsDto);

    /**
     * 유저 uuid로 버스커 sns 조회
     * @param userUuid
     */
    List<ResponseBuskerSnsDto> findBuskerSnsByUserUuid(String userUuid);

    /**
     * 버스커 sns 업데이트
     * @param requestUpdateBuskerSnsDto
     */
    void updateBuskerSns(RequestUpdateBuskerSnsDto requestUpdateBuskerSnsDto);

    /**
     * 버스커 sns 삭제
     * @param requestDeleteBuskerSnsDto
     */
    void deleteBuskerSns(RequestDeleteBuskerSnsDto requestDeleteBuskerSnsDto);

}
