package back.vybz.user_info_service.user_info.application;

import back.vybz.user_info_service.user_info.dto.request.RequestAddUserInfoDto;
import back.vybz.user_info_service.user_info.dto.request.RequestDeleteUserInfoDto;
import back.vybz.user_info_service.user_info.dto.request.RequestUpdateUserInfoDto;
import back.vybz.user_info_service.user_info.dto.response.ResponseUserInfoDto;

import java.util.List;

public interface UserInfoService {

    /**
     * 유저 정보 추가
     * @param requestAddUserInfoDto
     */
    void createUserInfo(RequestAddUserInfoDto requestAddUserInfoDto);

    /**
     * userUuid로 유저 정보 조회
     * @param userUuid
     */
    ResponseUserInfoDto getUserInfoByUuid(String userUuid);

    /**
     * 모든 유저 정보 조회
     */
    List<ResponseUserInfoDto> getAllUserInfo();

    /**
     * 유저 정보 수정
     * @param requestUpdateUserInfoDto
     */
    void updateUserInfo(RequestUpdateUserInfoDto requestUpdateUserInfoDto);

    /**
     * 유저 정보 삭제
     * @param requestDeleteUserInfoDto
     */
    void deleteUserInfo(RequestDeleteUserInfoDto requestDeleteUserInfoDto);

}
