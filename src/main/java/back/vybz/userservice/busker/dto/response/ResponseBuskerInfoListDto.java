package back.vybz.userservice.busker.dto.response;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.vo.response.ResponseBuskerInfoListVo;
import back.vybz.userservice.user.dto.response.ResponseUserInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBuskerInfoListDto {

    private String userUuid;

    @Builder
public ResponseBuskerInfoListDto(String userUuid) {
        this.userUuid = userUuid;
    }

    public static ResponseBuskerInfoListDto from(BuskerInfo buskerInfo) {
        return ResponseBuskerInfoListDto.builder()
                .userUuid(buskerInfo.getUserUuid())
                .build();
    }

    public ResponseBuskerInfoListVo toVo() {
        return ResponseBuskerInfoListVo.builder()
                .userUuid(userUuid)
                .build();
    }

}
