package back.vybz.userservice.user.dto.request;

import back.vybz.userservice.user.domain.mysql.Follow;
import back.vybz.userservice.user.vo.request.RequestToggleFollowVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestToggleFollowDto {

    private String userUuid;
    private String buskerUuid;

    @Builder
    public RequestToggleFollowDto(String userUuid, String buskerUuid) {
        this.userUuid = userUuid;
        this.buskerUuid = buskerUuid;
    }

    public Follow toEntity() {
        return Follow.builder()
                .userUuid(userUuid)
                .buskerUuid(buskerUuid)
                .build();
    }

    public static RequestToggleFollowDto from(RequestToggleFollowVo requestToggleFollowVo) {
        return RequestToggleFollowDto.builder()
                .userUuid(requestToggleFollowVo.getUserUuid())
                .buskerUuid(requestToggleFollowVo.getBuskerUuid())
                .build();
    }

}
