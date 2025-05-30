package back.vybz.userservice.user.domain.mongodb;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Follower {

    private String userUuid;
    private String nickname;
    private String profileImageUrl;

}
