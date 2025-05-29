package back.vybz.userservice.busker.dto.mysql.request;

import back.vybz.userservice.busker.domain.mysql.BuskerGroup;
import back.vybz.userservice.busker.domain.mysql.BuskerState;
import back.vybz.userservice.busker.vo.mysql.request.RequestAddBuskerGroupVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddBuskerGroupDto {

    private String userUuid;
    private String groupUuid;

    @Builder
    public RequestAddBuskerGroupDto(String groupUuid, String userUuid) {
        this.groupUuid = groupUuid;
        this.userUuid = userUuid;
    }

    public BuskerGroup toEntity() {
        return BuskerGroup.builder()
                .groupUuid(groupUuid)
                .userUuid(userUuid)
                .state(BuskerState.PENDING)
                .build();
    }

    public static RequestAddBuskerGroupDto from(RequestAddBuskerGroupVo requestAddBuskerGroupVo) {
        return RequestAddBuskerGroupDto.builder()
                .groupUuid(requestAddBuskerGroupVo.getGroupUuid())
                .userUuid(requestAddBuskerGroupVo.getUserUuid())
                .build();
    }

}
