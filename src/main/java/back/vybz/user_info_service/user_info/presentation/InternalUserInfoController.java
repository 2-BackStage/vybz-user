package back.vybz.user_info_service.user_info.presentation;

import back.vybz.user_info_service.user_info.application.UserInfoService;
import back.vybz.user_info_service.user_info.dto.request.UserSummary;
import back.vybz.user_info_service.user_info.dto.response.ResponseUserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/user-info")
public class InternalUserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping("/{userUuid}")
    public UserSummary getUserSummary(@PathVariable("userUuid") String userUuid) {
        ResponseUserInfoDto responseUserInfoDto = userInfoService.getUserInfoByUuid(userUuid);
        return new UserSummary(responseUserInfoDto.getUserUuid(),
                               responseUserInfoDto.getNickname(),
                               responseUserInfoDto.getProfileImageUrl());
    }

    @PostMapping("/summary-bulk")
    public Map<String, UserSummary> getUserSummaryBulk(@RequestBody List<String> userUuid) {
        return userInfoService.getUserSummaryBulk(userUuid);
    }

}
