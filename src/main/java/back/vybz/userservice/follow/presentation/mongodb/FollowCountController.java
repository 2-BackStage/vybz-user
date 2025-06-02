package back.vybz.userservice.follow.presentation.mongodb;

import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.follow.application.mongodb.FollowCountService;
import back.vybz.userservice.follow.dto.mongodb.response.ResponseBuskerFollowerCountDto;
import back.vybz.userservice.follow.dto.mongodb.response.ResponseUserFollowingCountDto;
import back.vybz.userservice.follow.vo.mongodb.response.ResponseBuskerFollowerCountVo;
import back.vybz.userservice.follow.vo.mongodb.response.ResponseUserFollowingCountVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follow-count")
public class FollowCountController {

    private final FollowCountService followCountService;

    /**
     * 유저 uuid로 팔로잉 수 조회 API
     * @param userUuid
     */
    @Operation(summary = "유저 uuid로 팔로잉 수 조회 API", description = "유저 uuid로 팔로잉 수 조회 API 입니다.", tags = {"Follow-Service"})
    @GetMapping("/user/{userUuid}")
    public BaseResponseEntity<ResponseUserFollowingCountVo> getUserFollowingCount(@PathVariable("userUuid") String userUuid) {
        ResponseUserFollowingCountDto responseUserFollowingCountDto = followCountService.getUserFollowingCount(userUuid);
        return new BaseResponseEntity<>(responseUserFollowingCountDto.toVo());
    }

    /**
     * 버스커 uuid로 팔로워 수 조회 API
     * @param buskerUuid
     */
    @Operation(summary = "버스커 uuid로 팔로워 수 조회 API", description = "버스커 uuid로 팔로워 수 조회 API 입니다.", tags = {"Follow-Service"})
    @GetMapping("/busker/{buskerUuid}")
    public BaseResponseEntity<ResponseBuskerFollowerCountVo> getBuskerFollowerCount(@PathVariable("buskerUuid") String buskerUuid) {
        ResponseBuskerFollowerCountDto responseBuskerFollowerCountDto = followCountService.getBuskerFollowerCount(buskerUuid);
        return new BaseResponseEntity<>(responseBuskerFollowerCountDto.toVo());
    }

}
