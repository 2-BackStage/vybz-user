package back.vybz.userservice.user.presentation.mongodb;

import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.user.application.mongodb.UserFollowingService;
import back.vybz.userservice.user.dto.mongodb.request.RequestAddUserFollowingDto;
import back.vybz.userservice.user.dto.mongodb.request.RequestDeleteUserFollowingDto;
import back.vybz.userservice.user.dto.mongodb.response.ResponseUserFollowingDto;
import back.vybz.userservice.user.vo.mongodb.request.RequestAddUserFollowingVo;
import back.vybz.userservice.user.vo.mongodb.request.RequestDeleteUserFollowingVo;
import back.vybz.userservice.user.vo.mongodb.response.ResponseUserFollowingVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-follow")
public class UserFollowingController {

    private final UserFollowingService userFollowingService;

    /**
     * 사용자 팔로우 추가
     * @param requestAddUserFollowingVo
     */
    @Operation(summary = "사용자 팔로우 추가 API", description = "사용자 팔로우 추가 API 입니다.", tags = {"User-Following-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createUserFollowing(@RequestBody RequestAddUserFollowingVo requestAddUserFollowingVo) {
        userFollowingService.createFollowing(RequestAddUserFollowingDto.from(requestAddUserFollowingVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 사용자 팔로우 여부 확인
     *
     */
    @Operation(summary = "사용자 팔로우 여부 확인 API", description = "사용자 팔로우 여부 확인 API 입니다.", tags = {"User-Following-Service"})
    @GetMapping("/check")
    public BaseResponseEntity<Boolean> checkUserFollowing(@RequestParam String userUuid, String buskerUuid) {
        boolean isFollowing = userFollowingService.checkFollowing(userUuid, buskerUuid);
        return new BaseResponseEntity<>(isFollowing);
    }

    /**
     * 사용자 팔로잉 리스트 조회
     * @param userUuid
     */
    @Operation(summary = "사용자 UUID로 팔로잉 조회 API", description = "사용자 UUID로 팔로잉 조회 API 입니다.", tags = {"User-Following-Service"})
    @GetMapping("/list/{userUuid}")
    public BaseResponseEntity<List<ResponseUserFollowingVo>> getUserFollowing(@PathVariable("userUuid") String userUuid) {
        List<ResponseUserFollowingVo> responseUserFollowingVo = userFollowingService.getFollowingByUserUuid(userUuid)
                .stream()
                .map(ResponseUserFollowingDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseUserFollowingVo);
    }

    /**
     * 사용자 팔로잉 삭제
     * @param requestDeleteUserFollowingVo
     */
    @Operation(summary = "사용자 UUID로 팔로잉 삭제 API", description = "사용자 UUID로 팔로잉 삭제 API 입니다.", tags = {"User-Following-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteUserFollowing(@RequestBody RequestDeleteUserFollowingVo requestDeleteUserFollowingVo) {
        userFollowingService.deleteFollowing(RequestDeleteUserFollowingDto.from(requestDeleteUserFollowingVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
