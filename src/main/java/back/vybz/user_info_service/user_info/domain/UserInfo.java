package back.vybz.user_info_service.user_info.domain;

import back.vybz.user_info_service.common.entity.SoftDeletableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info", indexes = {
        @Index(name = "idx_user_info_user_uuid", columnList = "user_uuid", unique = true)
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo extends SoftDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 회원 UUID
     * */
    @Column(name = "user_uuid", nullable = false, unique = true)
    private String userUuid;

    /**
     * 회원 프로필사진URL
     * */
    @Column(name = "profile_image_url")
    private String profileImageUrl;

    /**
     * 회원 별칭
     * */
    @Column(name = "nickname", nullable = false, length = 15)
    private String nickname;

    @Builder
    public UserInfo(Long id, String userUuid, String profileImageUrl, String nickname) {
        this.id = id;
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

}
