package back.vybz.userservice.agreement.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "agreement")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Agreement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  /**
     * 약관 제목
     */

    @Column(nullable = false)
    private String agreementTitle;

    /**
     * 약관 내용
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String agreementContent;

   /**
     * 약관 종류
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AgreementCategory agreementCategory;

    @Builder
    public Agreement(String agreementTitle,
                     String agreementContent,
                     AgreementCategory agreementCategory)  {
        this.agreementTitle = agreementTitle;
        this.agreementContent = agreementContent;
        this.agreementCategory = agreementCategory;
    }

}
