package back.vybz.userservice.busker.dto.response;

import back.vybz.userservice.busker.domain.mysql.BuskerSns;
import back.vybz.userservice.busker.vo.response.ResponseBuskerSnsVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBuskerSnsDto {

    private String userUuid;
    private String snsUrl;

    @Builder
    public ResponseBuskerSnsDto(String userUuid, String snsUrl) {
        this.userUuid = userUuid;
        this.snsUrl = snsUrl;
    }

    public static ResponseBuskerSnsDto from(BuskerSns buskerSns) {
        return ResponseBuskerSnsDto.builder()
                .userUuid(buskerSns.getUserUuid())
                .snsUrl(buskerSns.getSnsUrl())
                .build();
    }

    public ResponseBuskerSnsVo toVo() {
        return ResponseBuskerSnsVo.builder()
                .userUuid(userUuid)
                .snsUrl(snsUrl)
                .build();
    }

}
