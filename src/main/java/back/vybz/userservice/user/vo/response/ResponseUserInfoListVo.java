package back.vybz.userservice.user.vo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseUserInfoListVo {

    private String userUuid;

    @Builder
    public ResponseUserInfoListVo(String userUuid) {
        this.userUuid = userUuid;
    }

}
