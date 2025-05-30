package back.vybz.userservice.user.dto.mongodb.request;

import back.vybz.userservice.user.vo.mongodb.request.RequestDeleteFollowVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteFollowDto {

    private String userUuid;
    private String buskerUuid;

    @Builder
    public RequestDeleteFollowDto(String userUuid, String buskerUuid) {
        this.userUuid = userUuid;
        this.buskerUuid = buskerUuid;
    }

    public static RequestDeleteFollowDto from(RequestDeleteFollowVo requestDeleteFollowVo) {
        return RequestDeleteFollowDto.builder()
                .userUuid(requestDeleteFollowVo.getUserUuid())
                .buskerUuid(requestDeleteFollowVo.getBuskerUuid())
                .build();
    }

}
