package back.vybz.userservice.busker.domain.mongodb;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Following {

    // 유저 uuid
    private String userUuid;

    // 닉네임
    private String nickname;

    // 프로필 사진 url
    private String profileImageUrl;

}
