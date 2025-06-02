package back.vybz.userservice.follow.dto.mongodb.response;

import back.vybz.userservice.follow.domain.mongodb.BuskerFollowerCount;
import back.vybz.userservice.follow.vo.mongodb.response.ResponseBuskerFollowerCountVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBuskerFollowerCountDto {

    private String buskerUuid;
    private int totalFollowerCount;

    @Builder
    public ResponseBuskerFollowerCountDto(String buskerUuid, int totalFollowerCount) {
        this.buskerUuid = buskerUuid;
        this.totalFollowerCount = totalFollowerCount;
    }

    public static ResponseBuskerFollowerCountDto from(BuskerFollowerCount buskerFollowerCount) {
        return ResponseBuskerFollowerCountDto.builder()
                .buskerUuid(buskerFollowerCount.getBuskerUuid())
                .totalFollowerCount(buskerFollowerCount.getTotalFollowerCount())
                .build();
    }

    public ResponseBuskerFollowerCountVo toVo() {
        return ResponseBuskerFollowerCountVo.builder()
                .buskerUuid(buskerUuid)
                .totalFollowerCount(totalFollowerCount)
                .build();
    }

}
