package back.vybz.userservice.agreement.dto.request;

import back.vybz.userservice.agreement.domain.mysql.UserAgreement;
import back.vybz.userservice.agreement.vo.request.RequestAddUserAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddUserAgreementDto {

    private String userUuid;
    private Long agreementId;
    private boolean agreed;

    @Builder
    public RequestAddUserAgreementDto(String userUuid, Long agreementId, boolean agreed) {
        this.userUuid = userUuid;
        this.agreementId = agreementId;
        this.agreed = agreed;
    }

    public UserAgreement toEntity() {
        return UserAgreement.builder()
                .userUuid(userUuid)
                .agreementId(agreementId)
                .agreed(agreed)
                .build();
    }

    public static RequestAddUserAgreementDto from(RequestAddUserAgreementVo requestAddUserAgreementVo) {
        return RequestAddUserAgreementDto.builder()
                .userUuid(requestAddUserAgreementVo.getUserUuid())
                .agreementId(requestAddUserAgreementVo.getAgreementId())
                .agreed(requestAddUserAgreementVo.isAgreed())
                .build();
    }

}
