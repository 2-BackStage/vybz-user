package back.vybz.userservice.agreement.application;

import back.vybz.userservice.agreement.domain.mysql.Agreement;
import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import back.vybz.userservice.agreement.dto.request.RequestAddAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestDeleteAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestUpdateAgreementDto;
import back.vybz.userservice.agreement.dto.response.ResponseAgreementDto;
import back.vybz.userservice.agreement.infrastructure.AgreementRepository;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    /**
     * 약관 추가
     * @param requestAddAgreementDto
     */
    @Transactional
    @Override
    public void createAgreement(RequestAddAgreementDto requestAddAgreementDto) {
        if(agreementRepository.existsByTitle(requestAddAgreementDto.getTitle())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_AGREEMENT);
        }
        agreementRepository.save(requestAddAgreementDto.toEntity());
    }

    /**
     * 약관 제목으로 조회
     * @param title
     */
    @Override
    public ResponseAgreementDto getAgreementByTitle(String title) {
        Agreement agreement = agreementRepository.findByTitleAndDeletedFalse(title)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_AGREEMENT));
        return ResponseAgreementDto.from(agreement);
    }

    /**
     * 약관 타입으로 조회
     * @param agreementType
     */
    @Override
    public List<ResponseAgreementDto> getAgreementsByType(AgreementType agreementType) {
        return agreementRepository.findByAgreementType(agreementType)
                .stream()
                .map(ResponseAgreementDto::from)
                .toList();
    }

    /**
     * 모든 약관 조회
     */
    @Override
    public List<ResponseAgreementDto> getAllAgreement() {
        return agreementRepository.findAll()
                .stream()
                .map(ResponseAgreementDto::from)
                .toList();
    }

    /**
     * 약관 수정
     * @param requestUpdateAgreementDto
     */
    @Transactional
    @Override
    public void updateAgreement(RequestUpdateAgreementDto requestUpdateAgreementDto) {
        Agreement agreement = agreementRepository.findByTitleAndDeletedFalse(requestUpdateAgreementDto.getTitle())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_AGREEMENT));
        agreementRepository.save(requestUpdateAgreementDto.updateEntity(agreement));
    }

    /**
     * 약관 삭제
     * @param requestDeleteAgreementDto
     */
    @Transactional
    @Override
    public void deleteAgreement(RequestDeleteAgreementDto requestDeleteAgreementDto) {
        Agreement agreement = agreementRepository.findByIdAndDeletedFalse(requestDeleteAgreementDto.getId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_AGREEMENT));
        agreement.softDelete();
    }

}
