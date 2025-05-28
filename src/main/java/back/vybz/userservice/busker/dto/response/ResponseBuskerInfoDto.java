package back.vybz.userservice.busker.dto.response;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.vo.response.ResponseBuskerInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBuskerInfoDto {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;
    private Long categoryId;

    @Builder
    public ResponseBuskerInfoDto(String userUuid, String profileImageUrl, String nickname, Long categoryId) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

    public static ResponseBuskerInfoDto from(BuskerInfo buskerInfo) {
        return ResponseBuskerInfoDto.builder()
                .userUuid(buskerInfo.getUserUuid())
                .profileImageUrl(buskerInfo.getProfileImageUrl())
                .nickname(buskerInfo.getNickname())
                .categoryId(buskerInfo.getCategoryId())
                .build();
    }

    public ResponseBuskerInfoVo toVo() {
        return ResponseBuskerInfoVo.builder()
                .userUuid(userUuid)
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .categoryId(categoryId)
                .build();
    }

}
