package back.vybz.userservice.busker.dto.request;

import back.vybz.userservice.busker.domain.mysql.BuskerState;
import back.vybz.userservice.busker.vo.request.RequestUpdateBuskerGroupVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerGroupDto {

    private String groupUuid;
    private String userUuid;
    private BuskerState state;

    @Builder
    public RequestUpdateBuskerGroupDto(String groupUuid, String userUuid, BuskerState state) {
        this.groupUuid = groupUuid;
        this.userUuid = userUuid;
        this.state = state;
    }

    public static RequestUpdateBuskerGroupDto from(RequestUpdateBuskerGroupVo requestUpdateBuskerGroupVo) {
        return RequestUpdateBuskerGroupDto.builder()
                .groupUuid(requestUpdateBuskerGroupVo.getGroupUuid())
                .userUuid(requestUpdateBuskerGroupVo.getUserUuid())
                .state(requestUpdateBuskerGroupVo.getState())
                .build();
    }

}
