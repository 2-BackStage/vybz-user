package back.vybz.userservice.busker.dto.mysql.request;

import back.vybz.userservice.busker.vo.mysql.request.RequestDeleteBuskerInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteBuskerInfoDto {

    private String userUuid;

    @Builder
    public RequestDeleteBuskerInfoDto(String userUuid) {
        this.userUuid = userUuid;
    }

    public static RequestDeleteBuskerInfoDto from(RequestDeleteBuskerInfoVo requestDeleteBuskerInfoVo) {
        return RequestDeleteBuskerInfoDto.builder()
                .userUuid(requestDeleteBuskerInfoVo.getUserUuid())
                .build();
    }

}
