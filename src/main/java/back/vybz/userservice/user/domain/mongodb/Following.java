package back.vybz.userservice.user.domain.mongodb;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
public class Following {

    private String buskerUuid;

    private String nickname;

    private String profileImage;

    private Instant followedAt;
}
