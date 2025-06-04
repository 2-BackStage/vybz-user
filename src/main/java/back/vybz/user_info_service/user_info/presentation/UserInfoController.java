package back.vybz.user_info_service.user_info.presentation;

import back.vybz.user_info_service.common.entity.BaseResponseEntity;
import back.vybz.user_info_service.common.entity.BaseResponseStatus;
import back.vybz.user_info_service.user_info.application.UserInfoService;
import back.vybz.user_info_service.user_info.dto.request.RequestAddUserInfoDto;
import back.vybz.user_info_service.user_info.dto.request.RequestDeleteUserInfoDto;
import back.vybz.user_info_service.user_info.dto.request.RequestUpdateUserInfoDto;
import back.vybz.user_info_service.user_info.dto.response.ResponseUserInfoDto;
import back.vybz.user_info_service.user_info.vo.request.RequestAddUserInfoVo;
import back.vybz.user_info_service.user_info.vo.request.RequestDeleteUserInfoVo;
import back.vybz.user_info_service.user_info.vo.request.RequestUpdateUserInfoVo;
import back.vybz.user_info_service.user_info.vo.response.ResponseUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    /**
     * 유저 정보 추가
     * @param requestAddUserInfoVo
     */
    @Operation(summary = "유저 정보 추가 API", description = "유저 정보를 추가 API 입니다.", tags = {"User-Service"})
    @PostMapping
    public BaseResponseEntity<Void> createUserInfo(@RequestBody RequestAddUserInfoVo requestAddUserInfoVo) {
        userInfoService.createUserInfo(RequestAddUserInfoDto.from(requestAddUserInfoVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 유저 uuid로 유저 정보 조회
     * @param userUuid
     */
    @Operation(summary = "유저 uuid로 유저 정보 조회 API", description = "유저 uuid로 유저 정보 조회 API 입니다.", tags = {"User-Service"})
    @GetMapping("/{userUuid}")
    public BaseResponseEntity<ResponseUserInfoVo> getUserInfoByUuid(@PathVariable("userUuid") String userUuid) {
        ResponseUserInfoDto responseUserInfoDto = userInfoService.getUserInfoByUuid(userUuid);
        return new BaseResponseEntity<>(responseUserInfoDto.toVo());
    }

    /**
     * 모든 유저 정보 조회
     */
    @Operation(summary = "모든 유저 정보 조회 API", description = "모든 유저 정보 조회 API 입니다.", tags = {"User-Service"})
    @GetMapping("/list")
    public BaseResponseEntity<List<ResponseUserInfoVo>> getAllUserInfo() {
        List<ResponseUserInfoVo> responseUserInfoListVo = userInfoService.getAllUserInfo()
                .stream()
                .map(ResponseUserInfoDto::toVo)
                .toList();
        return new BaseResponseEntity<>(responseUserInfoListVo);
    }

    /**
     * 유저 정보 수정
     * @param requestUpdateUserInfoVo
     */
    @Operation(summary = "유저 정보 수정 API", description = "유저 정보 수정 API 입니다.", tags = {"User-Service"})
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BaseResponseEntity<Void> updateUserInfo(@ModelAttribute RequestUpdateUserInfoVo requestUpdateUserInfoVo) {
        userInfoService.updateUserInfo(RequestUpdateUserInfoDto.from(requestUpdateUserInfoVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    /**
     * 유저 정보 삭제
     * @param requestDeleteUserInfoVo
     */
    @Operation(summary = "유저 정보 삭제 API", description = "유저 정보 삭제 API 입니다.", tags = {"User-Service"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteUserInfo(@RequestBody RequestDeleteUserInfoVo requestDeleteUserInfoVo) {
        userInfoService.deleteUserInfo(RequestDeleteUserInfoDto.from(requestDeleteUserInfoVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
