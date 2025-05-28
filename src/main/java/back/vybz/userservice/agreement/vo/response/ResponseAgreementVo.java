package back.vybz.userservice.agreement.vo.response;

import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseAgreementVo {

    private Long id;
    private String title;
    private String content;
    private boolean required;
    private AgreementType agreementType;

    @Builder
    public ResponseAgreementVo(Long id, String title, String content, boolean required, AgreementType agreementType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.required = required;
        this.agreementType = agreementType;
    }

}
