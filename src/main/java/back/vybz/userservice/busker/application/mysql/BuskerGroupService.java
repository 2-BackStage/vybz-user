package back.vybz.userservice.busker.application.mysql;

import back.vybz.userservice.busker.dto.mysql.request.RequestAddBuskerGroupDto;
import back.vybz.userservice.busker.dto.mysql.request.RequestDeleteBuskerGroupDto;
import back.vybz.userservice.busker.dto.mysql.request.RequestUpdateBuskerGroupDto;
import back.vybz.userservice.busker.dto.mysql.response.ResponseBuskerGroupDto;

import java.util.List;

public interface BuskerGroupService {

    /**
     * 버스커 멤버 추가
     * @param requestAddBuskerGroupDto
     */
    void createBuskerGroup(RequestAddBuskerGroupDto requestAddBuskerGroupDto);

    /**
     * 버스커 그룹에 있는 멤버 조회
     * @param groupUuid
     * @param userUuid
     */
    ResponseBuskerGroupDto getBuskerGroupAndBuskerMember(String groupUuid, String userUuid);

    /**
     * 버스커 그룹에 속한 멤버 리스트 조회
     * @param groupUuid
     */
    List<ResponseBuskerGroupDto> getBuskerGroupByGroupUuid(String groupUuid);

    /**
     * 유저가 속한 버스커 그룹 리스트 조회
     * @param userUuid
     */
    List<ResponseBuskerGroupDto> getBuskerGroupByUserUuid(String userUuid);

    /**
     * 버스커 그룹 멤버 상태 수정
     * @param requestUpdateBuskerGroupDto
     */
    void updateBuskerGroup(RequestUpdateBuskerGroupDto requestUpdateBuskerGroupDto);

    /**
     * 버스커 그룹 멤버 삭제
     * @param requestDeleteBuskerGroupDto
     */
    void deleteBuskerGroup(RequestDeleteBuskerGroupDto requestDeleteBuskerGroupDto);

}
