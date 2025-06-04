package back.vybz.user_info_service.user_info.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestUpdateUserInfoVo {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

}
