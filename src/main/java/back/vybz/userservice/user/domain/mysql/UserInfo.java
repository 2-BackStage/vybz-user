package back.vybz.userservice.user.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import back.vybz.userservice.common.entity.SoftDeletableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo extends SoftDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 회원 UUID
     * */
    @Column(name = "user_uuid", nullable = false, unique = true, length = 255)
    private String userUuid;

    /**
     * 회원 프로필사진URL
     * */
    @Column(name = "profile_image_url", length = 255)
    private String profileImageUrl;

    /**
     * 회원 별칭
     * */
    @Column(name = "nickname", nullable = false, length = 15)
    private String nickname;

    @Builder
    public UserInfo(String userUuid, String profileImageUrl, String nickname) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

}
