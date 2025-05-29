package back.vybz.userservice.busker.dto.mysql.request;

import back.vybz.userservice.busker.vo.mysql.request.RequestDeleteBuskerGroupVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteBuskerGroupDto {

    private String groupUuid;
    private String userUuid;

    @Builder
    public RequestDeleteBuskerGroupDto(String groupUuid, String userUuid) {
        this.groupUuid = groupUuid;
        this.userUuid = userUuid;
    }

    public static RequestDeleteBuskerGroupDto from(RequestDeleteBuskerGroupVo requestDeleteBuskerGroupVo) {
        return RequestDeleteBuskerGroupDto.builder()
                .groupUuid(requestDeleteBuskerGroupVo.getGroupUuid())
                .userUuid(requestDeleteBuskerGroupVo.getUserUuid())
                .build();
    }

}
