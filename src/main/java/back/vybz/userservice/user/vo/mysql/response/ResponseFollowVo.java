package back.vybz.userservice.user.vo.mysql.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseFollowVo {

    private String userUuid;
    private String buskerUuid;

    @Builder
    public ResponseFollowVo(String userUuid, String buskerUuid) {
        this.userUuid = userUuid;
        this.buskerUuid = buskerUuid;
    }

}
