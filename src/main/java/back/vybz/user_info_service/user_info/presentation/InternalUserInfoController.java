package back.vybz.user_info_service.user_info.presentation;

import back.vybz.user_info_service.user_info.application.UserInfoService;
import back.vybz.user_info_service.user_info.dto.request.UserSummary;
import back.vybz.user_info_service.user_info.dto.response.ResponseUserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
