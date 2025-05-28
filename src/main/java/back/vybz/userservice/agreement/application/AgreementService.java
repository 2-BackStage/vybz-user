package back.vybz.userservice.agreement.application;

import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import back.vybz.userservice.agreement.dto.request.RequestAddAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestDeleteAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestUpdateAgreementDto;
import back.vybz.userservice.agreement.dto.response.ResponseAgreementDto;

import java.util.List;

public interface AgreementService {

    /**
     * 약관 생성
     * @param requestAddAgreementDto
     */
    void createAgreement(RequestAddAgreementDto requestAddAgreementDto);

    /**
     * 약관 제목으로 약관 조회
     * @param title
     */
    ResponseAgreementDto getAgreementByTitle(String title);

    /**
     * 약관 타입으로 약관 리스트 조회
     * @param agreementType
     */
    List<ResponseAgreementDto> getAgreementsByType(AgreementType agreementType);

    /**
     * 모든 약관 조회
     */
    List<ResponseAgreementDto> getAllAgreement();

    /**
     * 약관 수정
     * @param requestUpdateAgreementDto
     */
    void updateAgreement(RequestUpdateAgreementDto requestUpdateAgreementDto);

    /**
     * 약관 삭제
     * @param requestDeleteAgreementDto
     */
    void deleteAgreement(RequestDeleteAgreementDto requestDeleteAgreementDto);

}
