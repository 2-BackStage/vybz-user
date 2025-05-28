package back.vybz.userservice.agreement.dto.request;

import back.vybz.userservice.agreement.vo.request.RequestDeleteUserAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteUserAgreementDto {

    private String userUuid;

    @Builder
    public RequestDeleteUserAgreementDto(String userUuid) {
        this.userUuid = userUuid;
    }

    public static RequestDeleteUserAgreementDto from(RequestDeleteUserAgreementVo requestDeleteUserAgreementVo) {
        return RequestDeleteUserAgreementDto.builder()
                .userUuid(requestDeleteUserAgreementVo.getUserUuid())
                .build();
    }

}
