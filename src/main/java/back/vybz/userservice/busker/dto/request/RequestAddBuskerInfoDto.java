package back.vybz.userservice.busker.dto.request;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.vo.request.RequestAddBuskerInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddBuskerInfoDto {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;
    private Long categoryId;

    @Builder
    public RequestAddBuskerInfoDto(String userUuid, String profileImageUrl, String nickname, Long categoryId) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

    public BuskerInfo toEntity() {
        return BuskerInfo.builder()
                .userUuid(userUuid)
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .categoryId(categoryId)
                .build();
    }

    public static RequestAddBuskerInfoDto from(RequestAddBuskerInfoVo requestAddBuskerInfoVo) {
        return RequestAddBuskerInfoDto.builder()
                .userUuid(requestAddBuskerInfoVo.getUserUuid())
                .profileImageUrl(requestAddBuskerInfoVo.getProfileImageUrl())
                .nickname(requestAddBuskerInfoVo.getNickname())
                .categoryId(requestAddBuskerInfoVo.getCategoryId())
                .build();
    }

}
