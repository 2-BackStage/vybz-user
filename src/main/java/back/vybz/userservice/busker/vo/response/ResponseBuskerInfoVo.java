package back.vybz.userservice.busker.vo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseBuskerInfoVo {

    private String profileImageUrl;
    private String nickname;
    private Long categoryId;

    @Builder
    public ResponseBuskerInfoVo(String profileImageUrl, String nickname, Long categoryId) {
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

}
