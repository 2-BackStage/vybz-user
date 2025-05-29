package back.vybz.userservice.busker.dto.mysql.response;

import back.vybz.userservice.busker.domain.mysql.BuskerGroup;
import back.vybz.userservice.busker.domain.mysql.BuskerState;
import back.vybz.userservice.busker.vo.mysql.response.ResponseBuskerGroupVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBuskerGroupDto {

    private String groupUuid;
    private String userUuid;
    private BuskerState state;

    @Builder
    public ResponseBuskerGroupDto(String groupUuid, String userUuid, BuskerState state) {
        this.groupUuid = groupUuid;
        this.userUuid = userUuid;
        this.state = state;
    }

    public static ResponseBuskerGroupDto from(BuskerGroup buskerGroup) {
        return ResponseBuskerGroupDto.builder()
                .groupUuid(buskerGroup.getGroupUuid())
                .userUuid(buskerGroup.getUserUuid())
                .state(buskerGroup.getState())
                .build();
    }

    public ResponseBuskerGroupVo toVo() {
        return ResponseBuskerGroupVo.builder()
                .groupUuid(groupUuid)
                .userUuid(userUuid)
                .state(state)
                .build();
    }

}
