package back.vybz.userservice.busker.vo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseBuskerInfoListVo {

    private String userUuid;

    @Builder
    public ResponseBuskerInfoListVo(String userUuid) {
        this.userUuid = userUuid;
    }

}
