package back.vybz.userservice.agreement.vo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateUserAgreementVo {

    private String userUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public RequestUpdateUserAgreementVo(String userUuid, Long agreementId, boolean agreed) {
        this.userUuid = userUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

}
