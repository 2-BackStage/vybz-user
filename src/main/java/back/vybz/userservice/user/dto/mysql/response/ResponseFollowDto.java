package back.vybz.userservice.user.dto.mysql.response;

import back.vybz.userservice.user.domain.mysql.Follow;
import back.vybz.userservice.user.vo.mysql.response.ResponseFollowVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseFollowDto {

    private String userUuid;
    private String buskerUuid;

    @Builder
    public ResponseFollowDto(String userUuid, String buskerUuid) {
        this.userUuid = userUuid;
        this.buskerUuid = buskerUuid;
    }

    public static ResponseFollowDto from(Follow follow) {
        return ResponseFollowDto.builder()
                .userUuid(follow.getUserUuid())
                .buskerUuid(follow.getBuskerUuid())
                .build();
    }

    public ResponseFollowVo toVo() {
        return ResponseFollowVo.builder()
                .userUuid(userUuid)
                .buskerUuid(buskerUuid)
                .build();
    }

}
