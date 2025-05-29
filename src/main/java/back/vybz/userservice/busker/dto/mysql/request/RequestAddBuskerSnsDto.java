package back.vybz.userservice.busker.dto.mysql.request;

import back.vybz.userservice.busker.domain.mysql.BuskerSns;
import back.vybz.userservice.busker.vo.mysql.request.RequestAddBuskerSnsVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddBuskerSnsDto {

    private String userUuid;
    private String snsUrl;

    @Builder
    public RequestAddBuskerSnsDto(String userUuid, String snsUrl) {
        this.userUuid = userUuid;
        this.snsUrl = snsUrl;
    }

    public BuskerSns toEntity() {
        return BuskerSns.builder()
                .userUuid(userUuid)
                .snsUrl(snsUrl)
                .build();
    }

    public static RequestAddBuskerSnsDto from(RequestAddBuskerSnsVo requestAddBuskerSnsVo) {
        return RequestAddBuskerSnsDto.builder()
                .userUuid(requestAddBuskerSnsVo.getUserUuid())
                .snsUrl(requestAddBuskerSnsVo.getSnsUrl())
                .build();
    }

}
