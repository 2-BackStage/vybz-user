package back.vybz.userservice.agreement.application;

import back.vybz.userservice.agreement.dto.request.RequestAddUserAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestDeleteUserAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestUpdateUserAgreementDto;
import back.vybz.userservice.agreement.dto.response.ResponseUserAgreementDto;

import java.util.List;

public interface UserAgreementService {

    /**
     * 유저 약관 동의 생성
     * @param requestAddUserAgreementDto
     */
    void createUserAgreement(RequestAddUserAgreementDto requestAddUserAgreementDto);

    /**
     * 유저 uuid로 약관 동의 여부 리스트 조회
     * @param userUuid
     */
    List<ResponseUserAgreementDto> getUserAgreementByUserUuid(String userUuid);

    /**
     * 유저 약관 동의 업데이트
     * @param requestUpdateUserAgreementDto
     */
    void updateUserAgreement(RequestUpdateUserAgreementDto requestUpdateUserAgreementDto);

    /**
     * 유저 약관 동의 삭제
     * @param requestDeleteUserAgreementDto
     */
    void deleteUserAgreement(RequestDeleteUserAgreementDto requestDeleteUserAgreementDto);

}
