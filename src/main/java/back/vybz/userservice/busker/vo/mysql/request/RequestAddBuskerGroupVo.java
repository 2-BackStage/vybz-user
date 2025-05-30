package back.vybz.userservice.busker.vo.mysql.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddBuskerGroupVo {

    private String groupUuid;
    private String userUuid;

    @Builder
    public RequestAddBuskerGroupVo(String groupUuid, String userUuid) {
        this.groupUuid = groupUuid;
        this.userUuid = userUuid;
    }

}
