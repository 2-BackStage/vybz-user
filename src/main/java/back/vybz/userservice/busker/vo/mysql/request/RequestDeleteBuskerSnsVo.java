package back.vybz.userservice.busker.vo.mysql.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteBuskerSnsVo {

    private String userUuid;
    private String snsUrl;

}
