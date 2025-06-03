package back.vybz.user_info_service.user_info.dto.request;

import back.vybz.user_info_service.user_info.domain.UserInfo;
import back.vybz.user_info_service.user_info.vo.request.RequestUpdateUserInfoVo;
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

    public static RequestUpdateUserInfoDto from(RequestUpdateUserInfoVo requestUpdateUserInfoVo) {
        return RequestUpdateUserInfoDto.builder()
                .userUuid(requestUpdateUserInfoVo.getUserUuid())
                .profileImage(requestUpdateUserInfoVo.getProfileImage())
                .nickname(requestUpdateUserInfoVo.getNickname())
                .build();
    }

}
