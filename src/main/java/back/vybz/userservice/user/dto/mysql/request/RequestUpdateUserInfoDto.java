package back.vybz.userservice.user.dto.mysql.request;

import back.vybz.userservice.user.domain.mysql.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class RequestUpdateUserInfoDto {

    private String userUuid;
    private MultipartFile profileImage;
    private String nickname;

    @Builder
    public RequestUpdateUserInfoDto(String userUuid, MultipartFile profileImage, String nickname) {
        this.userUuid = userUuid;
        this.profileImage = profileImage;
        this.nickname = nickname;
    }

    public void updateEntity(UserInfo userInfo, String imageUrl) {
        if (nickname != null) {
            userInfo.updateNickname(nickname);
        }
        if (imageUrl != null) {
            userInfo.updateProfileImageUrl(imageUrl);
        }
    }

    public static RequestUpdateUserInfoDto of(String userUuid, MultipartFile profileImage, String nickname) {
        return RequestUpdateUserInfoDto.builder()
                .userUuid(userUuid)
                .profileImage(profileImage)
                .nickname(nickname)
                .build();
    }

}
