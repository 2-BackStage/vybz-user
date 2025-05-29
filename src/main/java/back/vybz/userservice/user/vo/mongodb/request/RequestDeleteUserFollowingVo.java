package back.vybz.userservice.user.vo.mongodb.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteUserFollowingVo {

    private String userUuid;
    private String buskerUuid;

}
