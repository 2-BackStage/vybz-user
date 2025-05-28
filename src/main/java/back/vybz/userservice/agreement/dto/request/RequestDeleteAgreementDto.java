package back.vybz.userservice.agreement.dto.request;

import back.vybz.userservice.agreement.vo.request.RequestDeleteAgreementVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteAgreementDto {

    private Long id;

    @Builder
    public RequestDeleteAgreementDto(Long id) {
        this.id = id;
    }

    public static RequestDeleteAgreementDto from(RequestDeleteAgreementVo requestDeleteAgreementVo) {
        return RequestDeleteAgreementDto.builder()
                .id(requestDeleteAgreementVo.getId())
                .build();
    }

}
