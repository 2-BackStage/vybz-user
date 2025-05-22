package back.vybz.userservice.member.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

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


    @Builder
    public User(String userUuid,
                String profileImageUrl,
                String nickname,
                UserStatus userStatus,
                UserRole userRole) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.userStatus = userStatus;
        this.userRole = userRole;
    }

}
