package back.vybz.user_info_service.user_info.dto.request;

import back.vybz.user_info_service.user_info.domain.UserInfo;
import back.vybz.user_info_service.user_info.vo.request.RequestUpdateUserInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateUserInfoDto {

    private String userUuid;
    private String profileImageUrl;
    private String nickname;

    @Builder
    public RequestUpdateUserInfoDto(String userUuid, String profileImageUrl, String nickname) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

    public UserInfo updateEntity(UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .userUuid(userUuid)
                .profileImageUrl(this.profileImageUrl)
                .nickname(this.nickname)
                .build();
    }

    public static RequestUpdateUserInfoDto from(RequestUpdateUserInfoVo requestUpdateUserInfoVo) {
        return RequestUpdateUserInfoDto.builder()
                .userUuid(requestUpdateUserInfoVo.getUserUuid())
                .profileImageUrl(requestUpdateUserInfoVo.getProfileImageUrl())
                .nickname(requestUpdateUserInfoVo.getNickname())
                .build();
    }

}
