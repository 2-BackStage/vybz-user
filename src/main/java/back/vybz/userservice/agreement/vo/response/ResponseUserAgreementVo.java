package back.vybz.userservice.agreement.vo.response;

import back.vybz.userservice.agreement.domain.mysql.Agreement;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseUserAgreementVo {

    private String userUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public ResponseUserAgreementVo(String userUuid, Long agreementId, boolean agreed) {
        this.userUuid = userUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

}
