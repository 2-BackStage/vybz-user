package back.vybz.userservice.user.dto.request;

import back.vybz.userservice.user.domain.mysql.UserInfo;
import back.vybz.userservice.user.vo.request.RequestAddUserInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddUserInfoDto {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

    @Builder
    public RequestAddUserInfoDto(String userUuid, String profileImageUrl, String nickname) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

    public UserInfo toEntity() {
        return UserInfo.builder()
                .userUuid(userUuid)
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .build();
    }

    public static RequestAddUserInfoDto from(RequestAddUserInfoVo requestAddUserInfoVo) {
        return RequestAddUserInfoDto.builder()
                .userUuid(requestAddUserInfoVo.getUserUuid())
                .profileImageUrl(requestAddUserInfoVo.getProfileImageUrl())
                .nickname(requestAddUserInfoVo.getNickname())
                .build();
    }

}
