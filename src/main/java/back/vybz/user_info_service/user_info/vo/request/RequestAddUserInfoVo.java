package back.vybz.user_info_service.user_info.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddUserInfoVo {

    private String userUuid;
    private String nickname;

}
