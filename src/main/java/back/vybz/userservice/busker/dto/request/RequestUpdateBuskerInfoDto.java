package back.vybz.userservice.busker.dto.request;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.vo.request.RequestUpdateBuskerInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerInfoDto {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;
    private Long categoryId;

    @Builder
    public RequestUpdateBuskerInfoDto(String userUuid, String profileImageUrl, String nickname, Long categoryId) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

    public BuskerInfo updateEntity(BuskerInfo buskerInfo) {
        return BuskerInfo.builder()
                .id(buskerInfo.getId())
                .userUuid(userUuid)
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .categoryId(categoryId)
                .build();
    }

    public static RequestUpdateBuskerInfoDto from(RequestUpdateBuskerInfoVo requestUpdateBuskerInfoVo) {
        return RequestUpdateBuskerInfoDto.builder()
                .userUuid(requestUpdateBuskerInfoVo.getUserUuid())
                .profileImageUrl(requestUpdateBuskerInfoVo.getProfileImageUrl())
                .nickname(requestUpdateBuskerInfoVo.getNickname())
                .categoryId(requestUpdateBuskerInfoVo.getCategoryId())
                .build();
    }

}
