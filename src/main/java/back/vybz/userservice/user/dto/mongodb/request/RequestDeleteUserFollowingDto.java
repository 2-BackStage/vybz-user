package back.vybz.userservice.user.dto.mongodb.request;

import back.vybz.userservice.user.vo.mongodb.request.RequestDeleteUserFollowingVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteUserFollowingDto {

    private String userUuid;
    private String buskerUuid;

    @Builder
    public RequestDeleteUserFollowingDto(String userUuid, String buskerUuid) {
        this.userUuid = userUuid;
        this.buskerUuid = buskerUuid;
    }

    public static RequestDeleteUserFollowingDto from(RequestDeleteUserFollowingVo requestDeleteUserFollowingVo) {
        return RequestDeleteUserFollowingDto.builder()
                .userUuid(requestDeleteUserFollowingVo.getUserUuid())
                .buskerUuid(requestDeleteUserFollowingVo.getBuskerUuid())
                .build();
    }

}
