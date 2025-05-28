package back.vybz.userservice.agreement.dto.request;

import back.vybz.userservice.agreement.domain.mysql.Agreement;
import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import back.vybz.userservice.agreement.vo.request.RequestUpdateAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateAgreementDto {

    private String title;
    private String content;
    private boolean required;
    private AgreementType agreementType;

    @Builder
    public RequestUpdateAgreementDto(String title, String content, boolean required, AgreementType agreementType) {
        this.title = title;
        this.content = content;
        this.required = required;
        this.agreementType = agreementType;
    }

    public Agreement updateEntity(Agreement agreement) {
        return Agreement.builder()
                .id(agreement.getId())
                .title(title)
                .content(content)
                .required(required)
                .agreementType(agreementType)
                .build();
    }

    public static RequestUpdateAgreementDto from(RequestUpdateAgreementVo requestUpdateAgreementVo) {
        return RequestUpdateAgreementDto.builder()
                .title(requestUpdateAgreementVo.getTitle())
                .content(requestUpdateAgreementVo.getContent())
                .required(requestUpdateAgreementVo.isRequired())
                .agreementType(requestUpdateAgreementVo.getAgreementType())
                .build();
    }

}
