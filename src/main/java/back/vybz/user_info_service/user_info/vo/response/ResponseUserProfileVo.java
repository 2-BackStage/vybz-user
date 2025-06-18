package back.vybz.user_info_service.user_info.vo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUserProfileVo {

    private String nickname;

    private String profileImageUrl;

    @Builder
    public ResponseUserProfileVo(String nickname, String profileImageUrl) {
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }
}
