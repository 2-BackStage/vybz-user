package back.vybz.userservice.agreement.presentation;

import back.vybz.userservice.agreement.application.AgreementService;
import back.vybz.userservice.agreement.domain.mysql.AgreementType;
import back.vybz.userservice.agreement.dto.request.RequestAddAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestDeleteAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestUpdateAgreementDto;
import back.vybz.userservice.agreement.dto.response.ResponseAgreementDto;
import back.vybz.userservice.agreement.vo.request.RequestAddAgreementVo;
import back.vybz.userservice.agreement.vo.request.RequestDeleteAgreementVo;
import back.vybz.userservice.agreement.vo.request.RequestUpdateAgreementVo;
import back.vybz.userservice.agreement.vo.response.ResponseAgreementVo;
import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agreement")
public class AgreementController {

    private final AgreementService agreementService;

    /**
     * 약관 추가
     *
     * @param requestAddAgreementVo
     */
    @Operation(summary = "약관 추가 API", description = "약관 추가 API 입니다.", tags = {"Agreement-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createAgreement(@RequestBody RequestAddAgreementVo requestAddAgreementVo) {
        agreementService.createAgreement(RequestAddAgreementDto.from(requestAddAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 약관 제목으로 조회
     *
     * @param title
     */
    @Operation(summary = "약관 제목으로 조회 API", description = "약관 제목으로 조회 API 입니다.", tags = {"Agreement-Service"})
    @GetMapping("/{title}")
    public BaseResponseEntity<ResponseAgreementVo> getAgreementByTitle(@PathVariable("title") String title) {
        ResponseAgreementDto responseAgreementDto = agreementService.getAgreementByTitle(title);
        return new BaseResponseEntity<>(responseAgreementDto.toVo());
    }

    /**
     * 약관 타입으로 조회
     *
     * @param agreementType
     */
    @Operation(summary = "약관 타입으로 약관 리스트 조회 API", description = "약관 타입으로 약관 리스트 조회 API 입니다.", tags = {"Agreement-Service"})
    @GetMapping("/type/{agreementType}")
    public BaseResponseEntity<List<ResponseAgreementVo>> getAgreementsByType(@PathVariable("agreementType") AgreementType agreementType) {
        List<ResponseAgreementVo> responseAgreementVo = agreementService.getAgreementsByType(agreementType)
                .stream()
                .map(ResponseAgreementDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseAgreementVo);
    }

    /**
     * 모든 약관 조회
     */
    @Operation(summary = "모든 약관 조회 API", description = "모든 약관 조회 API 입니다.", tags = {"Agreement-Service"})
    @GetMapping("/list")
    public BaseResponseEntity<List<ResponseAgreementVo>> getAllAgreement() {
        List<ResponseAgreementVo> responseAgreementVo = agreementService.getAllAgreement()
                .stream()
                .map(ResponseAgreementDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseAgreementVo);
    }

    /**
     * 약관 수정
     * @param requestUpdateAgreementVo
     */
    @Operation(summary = "약관 수정 API", description = "약관 수정 API 입니다.", tags = {"Agreement-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateAgreement(@RequestBody RequestUpdateAgreementVo requestUpdateAgreementVo) {
        agreementService.updateAgreement(RequestUpdateAgreementDto.from(requestUpdateAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 약관 삭제
     * @param requestDeleteAgreementVo
     */
    @Operation(summary = "약관 삭제 API", description = "약관 삭제 API 입니다.", tags = {"Agreement-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteAgreement(@RequestBody RequestDeleteAgreementVo requestDeleteAgreementVo) {
        agreementService.deleteAgreement(RequestDeleteAgreementDto.from(requestDeleteAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
