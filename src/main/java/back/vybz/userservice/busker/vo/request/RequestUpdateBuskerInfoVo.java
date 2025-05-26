package back.vybz.userservice.busker.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerInfoVo {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;
    private Long categoryId;

}
