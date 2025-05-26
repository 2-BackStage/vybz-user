package back.vybz.userservice.busker.application;

import back.vybz.userservice.busker.dto.request.RequestAddBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerInfoDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerInfoDto;

import java.util.List;

public interface BuskerInfoService {

    /**
     * 버스커 정보 추가
     * @param requestAddBuskerInfoDto
     */
    void createBuskerInfo(RequestAddBuskerInfoDto requestAddBuskerInfoDto);

    /**
     * userUuid로 버스커 정보 조회
     * @param userUuid
     */
    ResponseBuskerInfoDto getBuskerInfoByUserUuid(String userUuid);

    /**
     * 모든 버스커 정보 조회
     */
    List<ResponseBuskerInfoDto> getAllBuskerInfo();

    /**
     * 버스커 정보 수정
     * @param requestUpdateBuskerInfoDto
     */
    void updateBuskerInfo(RequestUpdateBuskerInfoDto requestUpdateBuskerInfoDto);

    /**
     * 버스커 정보 삭제
     * @param requestDeleteBuskerInfoDto
     */
    void deleteBuskerInfo(RequestDeleteBuskerInfoDto requestDeleteBuskerInfoDto);

}
