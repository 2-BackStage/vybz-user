package back.vybz.userservice.busker.presentation;

import back.vybz.userservice.busker.application.BuskerGroupService;
import back.vybz.userservice.busker.dto.request.RequestAddBuskerGroupDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerGroupDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerGroupDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerGroupDto;
import back.vybz.userservice.busker.vo.request.RequestAddBuskerGroupVo;
import back.vybz.userservice.busker.vo.request.RequestDeleteBuskerGroupVo;
import back.vybz.userservice.busker.vo.request.RequestUpdateBuskerGroupVo;
import back.vybz.userservice.busker.vo.response.ResponseBuskerGroupVo;
import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/busker-group")
public class BuskerGroupController {

    private final BuskerGroupService buskerGroupService;

    /**
     * 버스커 그룹에 멤버 추가
     * @param requestAddBuskerGroupVo
     */
    @Operation(summary = "버스커 그룹 멤버 추가 API", description = "버스커 그룹에 멤버 추가 API 입니다.", tags = {"Busker-Group-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createBuskerGroup(@RequestBody RequestAddBuskerGroupVo requestAddBuskerGroupVo) {
        buskerGroupService.createBuskerGroup(RequestAddBuskerGroupDto.from(requestAddBuskerGroupVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 버스커 그룹에 있는 멤버 조회
     * @param groupUuid
     * @param userUuid
     */
    @Operation(summary = "버스커 그룹과 멤버 조회 API", description = "버스커 그룹에 있는 멤버 조회 API 입니다.", tags = {"Busker-Group-Service"})
    @GetMapping("/search")
    public BaseResponseEntity<ResponseBuskerGroupVo> getBuskerGroupAndBuskerMember(@RequestParam("groupUuid") String groupUuid, @RequestParam("userUuid") String userUuid) {
        ResponseBuskerGroupDto responseBuskerGroupDto = buskerGroupService.getBuskerGroupAndBuskerMember(groupUuid, userUuid);
        return new BaseResponseEntity<>(responseBuskerGroupDto.toVo());
    }

    /**
     * 버스커 그룹 UUID로 버스커 그룹 멤버 리스트 조회
     * @param groupUuid
     */
    @Operation(summary = "버스커 그룹 UUID로 버스커 그룹 멤버 리스트 조회 API", description = "버스커 그룹 UUID로 버스커 그룹 멤버 리스트 조회 API 입니다.", tags = {"Busker-Group-Service"})
    @GetMapping("/list/{groupUuid}")
    public BaseResponseEntity<List<ResponseBuskerGroupVo>> getBuskerGroupByGroupUuid(@PathVariable("groupUuid") String groupUuid) {
        List<ResponseBuskerGroupVo> responseBuskerGroupVo = buskerGroupService.getBuskerGroupByGroupUuid(groupUuid)
                .stream()
                .map(ResponseBuskerGroupDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseBuskerGroupVo);
    }

    /**
     * 유저 UUID로 속한 그룹 리스트 조회
     * @param userUuid
     */
    @Operation(summary = "유저 UUID로 속한 그룹 리스트 조회 API", description = "유저 UUID로 속한 그룹 리스트 조회 API 입니다.", tags = {"Busker-Group-Service"})
    @GetMapping("/list/user/{userUuid}")
    public BaseResponseEntity<List<ResponseBuskerGroupVo>> getBuskerGroupByUserUuid(@PathVariable("userUuid") String userUuid) {
        List<ResponseBuskerGroupVo> responseBuskerGroupVo = buskerGroupService.getBuskerGroupByUserUuid(userUuid)
                .stream()
                .map(ResponseBuskerGroupDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseBuskerGroupVo);
    }

    /**
     * 버스커 그룹 멤버 상태 수정
     * @param requestUpdateBuskerGroupVo
     */
    @Operation(summary = "버스커 그룹 멤버 상태 수정 API", description = "버스커 그룹 멤버 상태 수정 API 입니다.", tags = {"Busker-Group-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateBuskerGroup(@RequestBody RequestUpdateBuskerGroupVo requestUpdateBuskerGroupVo) {
        buskerGroupService.updateBuskerGroup(RequestUpdateBuskerGroupDto.from(requestUpdateBuskerGroupVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 버스커 그룹 멤버 삭제
     * @param requestDeleteBuskerGroupVo
     */
    @Operation(summary = "버스커 그룹 멤버 삭제 API", description = "버스커 그룹 멤버 삭제 API 입니다.", tags = {"Busker-Group-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteBuskerGroup(@RequestBody RequestDeleteBuskerGroupVo requestDeleteBuskerGroupVo) {
        buskerGroupService.deleteBuskerGroup(RequestDeleteBuskerGroupDto.from(requestDeleteBuskerGroupVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
