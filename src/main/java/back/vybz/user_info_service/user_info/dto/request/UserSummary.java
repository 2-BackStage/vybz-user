package back.vybz.user_info_service.user_info.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSummary {

    private String uuid;
    private String nickname;
    private String profileImageUrl;

    @Builder
    public UserSummary(String uuid, String nickname, String profileImageUrl) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

}
