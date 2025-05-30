package back.vybz.userservice.user.vo.mongodb.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteFollowVo {

    private String userUuid;
    private String buskerUuid;

}
