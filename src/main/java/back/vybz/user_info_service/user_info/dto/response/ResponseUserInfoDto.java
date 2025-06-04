package back.vybz.user_info_service.user_info.dto.response;

import back.vybz.user_info_service.user_info.domain.UserInfo;
import back.vybz.user_info_service.user_info.vo.response.ResponseUserInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUserInfoDto {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

    @Builder
    public ResponseUserInfoDto(String userUuid, String profileImageUrl, String nickname) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

    public static ResponseUserInfoDto from(UserInfo userInfo) {
        return ResponseUserInfoDto.builder()
                .userUuid(userInfo.getUserUuid())
                .profileImageUrl(userInfo.getProfileImageUrl())
                .nickname(userInfo.getNickname())
                .build();
    }

    public ResponseUserInfoVo toVo() {
        return ResponseUserInfoVo.builder()
                .userUuid(userUuid)
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .build();
    }

}
