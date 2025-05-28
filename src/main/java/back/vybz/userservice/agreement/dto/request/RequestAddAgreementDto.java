package back.vybz.userservice.agreement.dto.request;

import back.vybz.userservice.agreement.domain.mysql.Agreement;
import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import back.vybz.userservice.agreement.vo.request.RequestAddAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddAgreementDto {

    private String title;
    private String content;
    private boolean required;
    private AgreementType agreementType;

    @Builder
    public RequestAddAgreementDto(String title, String content, boolean required, AgreementType agreementType) {
        this.title = title;
        this.content = content;
        this.required = required;
        this.agreementType = agreementType;
    }

    public Agreement toEntity() {
        return Agreement.builder()
                .title(title)
                .content(content)
                .required(required)
                .agreementType(agreementType)
                .build();
    }

    public static RequestAddAgreementDto from(RequestAddAgreementVo requestAddAgreementVo) {
        return RequestAddAgreementDto.builder()
                .title(requestAddAgreementVo.getTitle())
                .content(requestAddAgreementVo.getContent())
                .required(requestAddAgreementVo.isRequired())
                .agreementType(requestAddAgreementVo.getAgreementType())
                .build();
    }

}
