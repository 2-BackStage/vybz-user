package back.vybz.userservice.user.presentation.mysql;

import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.user.application.mysql.FollowService;
import back.vybz.userservice.user.dto.mysql.request.RequestToggleFollowDto;
import back.vybz.userservice.user.vo.mysql.request.RequestToggleFollowVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follow")
public class FollowController {

    private final FollowService followService;

    /**
     * 팔로우 토글
     * @param requestToggleFollowVo
     */
    @Operation(summary = "팔로우 토글 API", description = "팔로우 토글 API 입니다.", tags = {"Follow-Service"})
    @PostMapping
    public BaseResponseEntity<Void> toggleFollow(@RequestBody RequestToggleFollowVo requestToggleFollowVo) {
        followService.toggleFollow(RequestToggleFollowDto.from(requestToggleFollowVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 팔로우 여부 확인
     * @param userUuid
     * @param buskerUuid
     */
    @Operation(summary = "팔로우 여부 확인 API", description = "팔로우 여부 확인 API 입니다.", tags = {"Follow-Service"})
    @GetMapping("/check")
    public BaseResponseEntity<Boolean> checkFollow(@RequestParam("userUuid") String userUuid,
                                                   @RequestParam("buskerUuid") String buskerUuid) {
        boolean followed = followService.checkFollow(userUuid, buskerUuid);
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS, followed);
    }

}
