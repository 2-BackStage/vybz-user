package back.vybz.userservice.busker.dto.mysql.request;

import back.vybz.userservice.busker.vo.mysql.request.RequestUpdateBuskerSnsVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerSnsDto {

    private String userUuid;
    private String oldSnsUrl;
    private String newSnsUrl;

    @Builder
public RequestUpdateBuskerSnsDto(String userUuid, String oldSnsUrl, String newSnsUrl) {
        this.userUuid = userUuid;
        this.oldSnsUrl = oldSnsUrl;
        this.newSnsUrl = newSnsUrl;
    }

    public static RequestUpdateBuskerSnsDto from(RequestUpdateBuskerSnsVo requestUpdateBuskerSnsVo) {
        return RequestUpdateBuskerSnsDto.builder()
                .userUuid(requestUpdateBuskerSnsVo.getUserUuid())
                .oldSnsUrl(requestUpdateBuskerSnsVo.getOldSnsUrl())
                .newSnsUrl(requestUpdateBuskerSnsVo.getNewSnsUrl())
                .build();
    }

}
