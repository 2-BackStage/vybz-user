package back.vybz.userservice.busker.vo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseBuskerSnsVo {

    private String userUuid;
    private String snsUrl;

    @Builder
    public ResponseBuskerSnsVo(String userUuid, String snsUrl) {
        this.userUuid = userUuid;
        this.snsUrl = snsUrl;
    }

}
