package back.vybz.userservice.busker.dto.request;

import back.vybz.userservice.busker.vo.request.RequestDeleteBuskerSnsVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteBuskerSnsDto {

    private String userUuid;
    private String snsUrl;

    @Builder
    public RequestDeleteBuskerSnsDto(String userUuid, String snsUrl) {
        this.userUuid = userUuid;
        this.snsUrl = snsUrl;
    }

    public static RequestDeleteBuskerSnsDto from(RequestDeleteBuskerSnsVo requestDeleteBuskerSnsVo) {
        return RequestDeleteBuskerSnsDto.builder()
                .userUuid(requestDeleteBuskerSnsVo.getUserUuid())
                .snsUrl(requestDeleteBuskerSnsVo.getSnsUrl())
                .build();
    }

}
