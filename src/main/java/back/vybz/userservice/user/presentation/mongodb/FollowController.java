package back.vybz.userservice.user.presentation.mongodb;

import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.user.application.mongodb.FollowService;
import back.vybz.userservice.user.dto.mongodb.request.RequestAddFollowDto;
import back.vybz.userservice.user.dto.mongodb.request.RequestDeleteFollowDto;
import back.vybz.userservice.user.dto.mongodb.response.ResponseFollowDto;
import back.vybz.userservice.user.vo.mongodb.request.RequestAddFollowVo;
import back.vybz.userservice.user.vo.mongodb.request.RequestDeleteFollowVo;
import back.vybz.userservice.user.vo.mongodb.response.ResponseBuskerFollowerVo;
import back.vybz.userservice.user.vo.mongodb.response.ResponseUserFollowingVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follow")
public class FollowController {

    private final FollowService followService;

    /**
     * 팔로우 추가
     * @param requestAddFollowVo
     */
    @Operation(summary = "팔로우 추가 API", description = "팔로우 추가 API 입니다.", tags = {"Follow-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createFollow(@RequestBody RequestAddFollowVo requestAddFollowVo) {
        followService.createFollow(RequestAddFollowDto.from(requestAddFollowVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 사용자 팔로우 여부 확인
     *
     */
    @Operation(summary = "사용자 팔로우 여부 확인 API", description = "사용자 팔로우 여부 확인 API 입니다.", tags = {"Follow-Service"})
    @GetMapping("/check")
    public BaseResponseEntity<Boolean> checkUserFollow(@RequestParam String userUuid, String buskerUuid) {
        boolean isFollowing = followService.checkFollow(userUuid, buskerUuid);
        return new BaseResponseEntity<>(isFollowing);
    }

    /**
     * 사용자 팔로잉 리스트 조회
     * @param userUuid
     */
    @Operation(summary = "사용자 UUID로 팔로잉 조회 API", description = "사용자 UUID로 팔로잉 조회 API 입니다.", tags = {"Follow-Service"})
    @GetMapping("/following-list/{userUuid}")
    public BaseResponseEntity<List<ResponseUserFollowingVo>> getUserFollowing(@PathVariable("userUuid") String userUuid) {
        List<ResponseUserFollowingVo> responseUserFollowingVo = followService.getFollowingByUserUuid(userUuid)
                .stream()
                .map(ResponseFollowDto::toUserVo)
                .toList();
        return new BaseResponseEntity<>(responseUserFollowingVo);
    }

    /**
     * 버스커 팔로워 리스트 조회
     * @param buskerUuid
     */
    @Operation(summary = "버스커 UUID로 팔로워 조회 API", description = "버스커 UUID로 팔로워 조회 API 입니다.", tags = {"Follow-Service"})
    @GetMapping("follower-list/{buskerUuid}")
    public BaseResponseEntity<List<ResponseBuskerFollowerVo>> getBuskerFollower(@PathVariable("buskerUuid") String buskerUuid) {
        List<ResponseBuskerFollowerVo> responseBuskerFollowerVo = followService.getFollowerByBuskerUuid(buskerUuid)
                .stream()
                .map(ResponseFollowDto::toBuskerVo)
                .toList();
        return new BaseResponseEntity<>(responseBuskerFollowerVo);
    }

    /**
     * 사용자 팔로잉 삭제
     * @param requestDeleteFollowVo
     */
    @Operation(summary = "팔로잉 삭제 API", description = "사용자 UUID, 버스커 UUID로 팔로잉 삭제 API 입니다.", tags = {"Follow-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteUserFollowing(@RequestBody RequestDeleteFollowVo requestDeleteFollowVo) {
        followService.deleteFollowing(RequestDeleteFollowDto.from(requestDeleteFollowVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
