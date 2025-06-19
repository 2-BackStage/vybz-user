package back.vybz.user_info_service.user_info.dto.response;


import back.vybz.user_info_service.user_info.vo.response.ResponseUserProfileVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUserProfileDto {

    private String nickname;

    private String profileImageUrl;

    @Builder
    public ResponseUserProfileDto(String nickname, String profileImageUrl) {
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public ResponseUserProfileVo toResponseUserProfileVo() {
        return ResponseUserProfileVo.builder()
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .build();
    }
}
