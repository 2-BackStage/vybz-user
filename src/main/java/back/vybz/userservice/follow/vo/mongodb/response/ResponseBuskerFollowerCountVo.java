package back.vybz.userservice.follow.vo.mongodb.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseBuskerFollowerCountVo {

    private String buskerUuid;
    private int totalFollowerCount;

    @Builder
    public ResponseBuskerFollowerCountVo(String buskerUuid, int totalFollowerCount) {
        this.buskerUuid = buskerUuid;
        this.totalFollowerCount = totalFollowerCount;
    }

}
