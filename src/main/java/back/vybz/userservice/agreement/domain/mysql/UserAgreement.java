package back.vybz.userservice.agreement.domain.mysql;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_agreement")
public class UserAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 회원 UUID
     */
    @Column(nullable = false, length = 255)
    private String userUuid;

    /**
     * 약관 id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agreement_id", nullable = false)
    private Agreement agreement;

    /**
     * 약관 동의 여부
     */
    private Boolean check;

    @Builder
    public UserAgreement(String userUuid,
                         Agreement agreement,
                         Boolean check) {
        this.userUuid = userUuid;
        this.agreement = agreement;
        this.check = check;
    }
}
