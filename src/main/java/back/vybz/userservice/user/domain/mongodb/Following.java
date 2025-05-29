package back.vybz.userservice.user.domain.mongodb;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Following {

    private String buskerUuid;

    private String nickname;

    private String profileImageUrl;

}
