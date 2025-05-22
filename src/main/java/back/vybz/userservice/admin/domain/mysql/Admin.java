package back.vybz.userservice.admin.domain.mysql;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 관리자 UUID
     */
    @Column(nullable = false, unique = true)
    private String adminUuid;

    /**
     * 관리자 아이디
     */
    @Column(nullable = false, length = 255)
    private String adminEmail;

    /**
     * 관리자 비밀번호
     */
    @Column(nullable = false, length = 255)
    private String adminPassword;

    @Builder
    public Admin(String adminUuid,
                 String adminEmail,
                 String adminPassword) {
        this.adminUuid = adminUuid;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }
}
