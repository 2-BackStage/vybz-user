package back.vybz.userservice.busker.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerSnsVo {

    private String userUuid;
    private String oldSnsUrl;
    private String newSnsUrl;

}
