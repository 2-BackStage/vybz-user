package back.vybz.userservice.agreement.presentation;

import back.vybz.userservice.agreement.application.UserAgreementService;
import back.vybz.userservice.agreement.dto.request.RequestAddUserAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestDeleteUserAgreementDto;
import back.vybz.userservice.agreement.dto.request.RequestUpdateUserAgreementDto;
import back.vybz.userservice.agreement.dto.response.ResponseUserAgreementDto;
import back.vybz.userservice.agreement.vo.request.RequestAddUserAgreementVo;
import back.vybz.userservice.agreement.vo.request.RequestDeleteUserAgreementVo;
import back.vybz.userservice.agreement.vo.request.RequestUpdateUserAgreementVo;
import back.vybz.userservice.agreement.vo.response.ResponseUserAgreementVo;
import back.vybz.userservice.common.entity.BaseResponseEntity;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-agreement")
public class UserAgreementController {

    private final UserAgreementService userAgreementService;

    /**
     * 유저 약관 동의 추가
     * @param requestAddUserAgreementVo
     */
    @Operation(summary = "유저 약관 동의 추가 API", description = "유저 약관 동의 추가 API 입니다.", tags = {"User-Agreement-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createUserAgreement(@RequestBody RequestAddUserAgreementVo requestAddUserAgreementVo) {
        userAgreementService.createUserAgreement(RequestAddUserAgreementDto.from(requestAddUserAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 유저 UUID로 약관 동의 리스트 조회
     * @param userUuid
     */
    @Operation(summary = "유저 UUID로 약관 동의 리스트 조회 API", description = "유저 UUID로 약관 동의 리스트 조회 API 입니다.", tags = {"User-Agreement-Service"})
    @GetMapping("/list/{userUuid}")
    public BaseResponseEntity<List<ResponseUserAgreementVo>> getUserAgreementByUserUuid(@PathVariable("userUuid") String userUuid) {
        List<ResponseUserAgreementVo> responseUserAgreementVo = userAgreementService.getUserAgreementByUserUuid(userUuid)
                .stream()
                .map(ResponseUserAgreementDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseUserAgreementVo);
    }

    /**
     * 유저 약관 동의 수정
     * @param requestUpdateUserAgreementVo
     */
    @Operation(summary = "유저 약관 동의 수정 API", description = "유저 약관 동의 수정 API 입니다.", tags = {"User-Agreement-Service"})
    @PutMapping
    public BaseResponseEntity<Void> updateUserAgreement(@RequestBody RequestUpdateUserAgreementVo requestUpdateUserAgreementVo) {
        userAgreementService.updateUserAgreement(RequestUpdateUserAgreementDto.from(requestUpdateUserAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 유저 약관 동의 삭제
     * @param requestDeleteUserAgreementVo
     */
    @Operation(summary = "유저 약관 동의 삭제 API", description = "유저 약관 동의 삭제 API 입니다.", tags = {"User-Agreement-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteUserAgreement(@RequestBody RequestDeleteUserAgreementVo requestDeleteUserAgreementVo) {
        userAgreementService.deleteUserAgreement(RequestDeleteUserAgreementDto.from(requestDeleteUserAgreementVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
