package back.vybz.userservice.busker.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddBuskerSnsVo {

    private String userUuid;
    private String snsUrl;

}
