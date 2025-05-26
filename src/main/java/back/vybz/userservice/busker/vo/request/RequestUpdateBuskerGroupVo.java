package back.vybz.userservice.busker.vo.request;

import back.vybz.userservice.busker.domain.mysql.BuskerState;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerGroupVo {

    private String groupUuid;
    private String userUuid;
    private BuskerState state;

}
