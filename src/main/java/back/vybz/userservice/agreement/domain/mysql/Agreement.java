package back.vybz.userservice.agreement.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import back.vybz.userservice.common.entity.SoftDeletableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "agreement")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Agreement extends SoftDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  /**
     * 약관 제목
     */

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    /**
     * 약관 내용
     */
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    /**
     * 필수 여부
     */
    @Column(name = "required", nullable = false)
    private Boolean required;

   /**
     * 약관 종류
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "agreement_type", nullable = false)
    private AgreementType agreementType;

    @Builder
    public Agreement(Long id, String title, String content, boolean required, AgreementType agreementType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.required = required;
        this.agreementType = agreementType;
    }

}
