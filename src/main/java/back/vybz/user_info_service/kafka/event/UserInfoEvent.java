package back.vybz.user_info_service.kafka.event;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoEvent {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

}
