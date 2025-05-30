package back.vybz.userservice.user.vo.mysql.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddUserInfoVo {

    private String userUuid;
    private String nickname;

}
