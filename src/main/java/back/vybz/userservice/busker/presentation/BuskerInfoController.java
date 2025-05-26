package back.vybz.userservice.busker.presentation;

import back.vybz.userservice.busker.application.BuskerInfoService;
import back.vybz.userservice.busker.dto.request.RequestAddBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerInfoDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerInfoDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerInfoDto;
import back.vybz.userservice.busker.vo.request.RequestAddBuskerInfoVo;
import back.vybz.userservice.busker.vo.request.RequestDeleteBuskerInfoVo;
import back.vybz.userservice.busker.vo.request.RequestUpdateBuskerInfoVo;
import back.vybz.userservice.busker.vo.response.ResponseBuskerInfoVo;
import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/busker")
public class BuskerInfoController {

    private final BuskerInfoService buskerInfoService;

    /**
     * 버스커 정보 추가
     * @param requestAddBuskerInfoVo
     */
    @Operation(summary = "버스커 정보 추가 API", description = "버스커 정보 추가 API 입니다.", tags = {"Busker-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createBuskerInfo(@RequestBody RequestAddBuskerInfoVo requestAddBuskerInfoVo) {
        buskerInfoService.createBuskerInfo(RequestAddBuskerInfoDto.from(requestAddBuskerInfoVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 유저 uuid로 버스커 정보 조회
     * @param userUuid
     */
    @Operation(summary = "유저 uuid로 버스커 정보 조회 API", description = "유저 uuid로 버스커 정보 조회 API 입니다.", tags = {"Busker-Service"})
    @GetMapping("/{userUuid}")
    public BaseResponseEntity<ResponseBuskerInfoVo> getBuskerInfoByUserUuid(@PathVariable("userUuid") String userUuid) {
        ResponseBuskerInfoDto responseBuskerInfoDto = buskerInfoService.getBuskerInfoByUserUuid(userUuid);
        return new BaseResponseEntity<>(responseBuskerInfoDto.toVo());
    }

    /**
     * 모든 버스커 정보 조회
     */
    @Operation(summary = "모든 버스커 정보 조회 API", description = "모든 버스커 정보 조회 API 입니다.", tags = {"Busker-Service"})
    @GetMapping("/list")
    public BaseResponseEntity<List<ResponseBuskerInfoVo>> getAllBuskerInfo() {
        List<ResponseBuskerInfoVo> responseBuskerInfoListVo = buskerInfoService.getAllBuskerInfo()
                .stream()
                .map(ResponseBuskerInfoDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseBuskerInfoListVo);
    }

    /**
     * 버스커 정보 수정
     * @param requestUpdateBuskerInfoVo
     */
    @Operation(summary = "버스커 정보 수정 API", description = "버스커 정보 수정 API 입니다.", tags = {"Busker-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateBuskerInfo(@RequestBody RequestUpdateBuskerInfoVo requestUpdateBuskerInfoVo) {
        buskerInfoService.updateBuskerInfo(RequestUpdateBuskerInfoDto.from(requestUpdateBuskerInfoVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 버스커 정보 삭제
     * @param requestDeleteBuskerInfoVo
     */
    @Operation(summary = "버스커 정보 삭제 API", description = "버스커 정보 삭제 API 입니다.", tags = {"Busker-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteBuskerInfo(@RequestBody RequestDeleteBuskerInfoVo requestDeleteBuskerInfoVo) {
        buskerInfoService.deleteBuskerInfo(RequestDeleteBuskerInfoDto.from(requestDeleteBuskerInfoVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
