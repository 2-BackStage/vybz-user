package back.vybz.userservice.user.vo.mysql.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestToggleFollowVo {

    private String userUuid;
    private String buskerUuid;

}
