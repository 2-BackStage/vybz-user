package back.vybz.userservice.follow.vo.mongodb.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteFollowVo {

    private String userUuid;
    private String buskerUuid;

}
