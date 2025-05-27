package back.vybz.userservice.agreement.vo.request;

import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddAgreementVo {

    private String title;
    private String content;
    private boolean required;
    private AgreementType agreementType;

    @Builder
    public RequestAddAgreementVo(String title, String content, boolean required, AgreementType agreementType) {
        this.title = title;
        this.content = content;
        this.required = required;
        this.agreementType = agreementType;
    }

}
