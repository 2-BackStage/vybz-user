package back.vybz.userservice.busker.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteBuskerGroupVo {

    private String groupUuid;
    private String userUuid;

}
