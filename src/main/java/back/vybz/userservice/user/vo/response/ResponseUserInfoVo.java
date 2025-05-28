package back.vybz.userservice.user.vo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseUserInfoVo {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

    @Builder
    public ResponseUserInfoVo(String userUuid, String profileImageUrl, String nickname) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

}
