package back.vybz.userservice.user.dto.response;

import back.vybz.userservice.user.domain.mysql.UserInfo;
import back.vybz.userservice.user.vo.response.ResponseUserInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUserInfoDto {

    private String profileImageUrl;
    private String nickname;

    @Builder
    public ResponseUserInfoDto(String profileImageUrl, String nickname) {
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

    public static ResponseUserInfoDto from(UserInfo userInfo) {
        return ResponseUserInfoDto.builder()
                .profileImageUrl(userInfo.getProfileImageUrl())
                .nickname(userInfo.getNickname())
                .build();
    }

    public ResponseUserInfoVo toVo() {
        return ResponseUserInfoVo.builder()
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .build();
    }

}
