package back.vybz.userservice.agreement.infrastructure;

import back.vybz.userservice.agreement.domain.mysql.Agreement;
import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    /**
     * 약관 제목 존재 여부 확인
     * @param title
     */
    boolean existsByTitle(String title);

    /**
     * 약관 ID로 삭제되지 않은 약관 조회
     * @param id
     */
    Optional<Agreement> findByIdAndDeletedFalse(Long id);

    /**
     * 약관 제목으로 약관 조회
     * @param title
     */
    Optional<Agreement> findByTitleAndDeletedFalse(String title);

    /**
     * 약관 종류로 약관 조회
     * @param agreementType
     */
    List<Agreement> findByAgreementType(AgreementType agreementType);

}
