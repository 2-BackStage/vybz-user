package back.vybz.userservice.busker.presentation;

import back.vybz.userservice.busker.application.BuskerSnsService;
import back.vybz.userservice.busker.dto.request.RequestAddBuskerSnsDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerSnsDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerSnsDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerSnsDto;
import back.vybz.userservice.busker.vo.request.RequestAddBuskerSnsVo;
import back.vybz.userservice.busker.vo.request.RequestDeleteBuskerSnsVo;
import back.vybz.userservice.busker.vo.request.RequestUpdateBuskerSnsVo;
import back.vybz.userservice.busker.vo.response.ResponseBuskerSnsVo;
import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/busker-sns")
public class BuskerSnsController {

    private final BuskerSnsService buskerSnsService;

    /**
     * 버스커 SNS 추가
     * @param requestAddBuskerSnsVo
     */
    @Operation(summary = "버스커 SNS 추가 API", description = "버스커 SNS 추가 API 입니다.", tags = {"Busker-SNS-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createBuskerSns(@RequestBody RequestAddBuskerSnsVo requestAddBuskerSnsVo) {
        buskerSnsService.createBuskerSns(RequestAddBuskerSnsDto.from(requestAddBuskerSnsVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "유저 uuid로 버스커 SNS 리스트 조회 API", description = "유저 uuid로 버스커 SNS 리스트 조회 API 입니다.", tags = {"Busker-SNS-Service"})
    @GetMapping("/list/{userUuid}")
    public BaseResponseEntity<List<ResponseBuskerSnsVo>> getBuskerSnsList(@PathVariable("userUuid") String userUuid) {
        List<ResponseBuskerSnsVo> responseBuskerSnsVo = buskerSnsService.findBuskerSnsByUserUuid(userUuid)
                .stream()
                .map(ResponseBuskerSnsDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseBuskerSnsVo);
    }

    @Operation(summary = "버스커 sns 수정 API", description = "버스커 sns 수정 API 입니다.", tags = {"Busker-SNS-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateBuskerSns(@RequestBody RequestUpdateBuskerSnsVo requestUpdateBuskerSnsVo) {
        buskerSnsService.updateBuskerSns(RequestUpdateBuskerSnsDto.from(requestUpdateBuskerSnsVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "버스커 sns 삭제 API", description = "버스커 sns 삭제 API 입니다.", tags = {"Busker-SNS-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteBuskerSns(@RequestBody RequestDeleteBuskerSnsVo requestDeleteBuskerSnsVo) {
        buskerSnsService.deleteBuskerSns(RequestDeleteBuskerSnsDto.from(requestDeleteBuskerSnsVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
