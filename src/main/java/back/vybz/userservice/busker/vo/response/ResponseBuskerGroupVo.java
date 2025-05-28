package back.vybz.userservice.busker.vo.response;

import back.vybz.userservice.busker.domain.mysql.BuskerState;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseBuskerGroupVo {

    private String groupUuid;
    private String userUuid;
    private BuskerState state;

    @Builder
    public ResponseBuskerGroupVo(String groupUuid, String userUuid, BuskerState state) {
        this.groupUuid = groupUuid;
        this.userUuid = userUuid;
        this.state = state;
    }

}
