package back.vybz.userservice.busker.vo.mysql.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseBuskerInfoVo {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;
    private Long categoryId;

    @Builder
    public ResponseBuskerInfoVo(String userUuid, String profileImageUrl, String nickname, Long categoryId) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

}
