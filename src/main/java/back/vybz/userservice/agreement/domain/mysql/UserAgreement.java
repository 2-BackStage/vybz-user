package back.vybz.userservice.agreement.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_agreement")
public class UserAgreement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 회원 UUID
     */
    @Column(name = "user_uuid", nullable = false, length = 255)
    private String userUuid;

    /**
     * 약관 id
     */
    @JoinColumn(name = "agreement_id", nullable = false)
    private Long agreementId;

    /**
     * 약관 동의 여부
     */
    @Column(name = "agreed", nullable = false)
    private Boolean agreed;

    @Builder
    public UserAgreement(Long id, String userUuid, Long agreementId, Boolean agreed) {
        this.id = id;
        this.userUuid = userUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

}
