package back.vybz.userservice.user.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddUserInfoVo {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

}
