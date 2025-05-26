package back.vybz.userservice.user.vo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseUserInfoVo {

    private String profileImageUrl;
    private String nickname;

    @Builder
    public ResponseUserInfoVo(String profileImageUrl, String nickname) {
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

}
