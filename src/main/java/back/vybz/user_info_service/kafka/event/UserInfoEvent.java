package back.vybz.user_info_service.kafka.event;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoEvent {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

    @Builder
    public UserInfoEvent(String userUuid, String profileImageUrl, String nickname) {
        this.userUuid = userUuid;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

}
