package back.vybz.userservice.user.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo extends BaseEntity {

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
    @Column(nullable = false, length = 15)
    private String nickname;

    /**
     * 회원 상태
     * */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserStatus userStatus;

    /**
     * 회원 역할
     * */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserRole userRole;

    /**
     * 카테고리 ID
     * */
    @Column(name = "category_id")
    private Long categoryId;

    @Builder
    public UserInfo(Long id, String userUuid, String profileImageUrl, String nickname, UserStatus userStatus, UserRole userRole, Long categoryId) {
        this.id = id;
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.userStatus = userStatus;
        this.userRole = userRole;
        this.categoryId = categoryId;
    }

}
