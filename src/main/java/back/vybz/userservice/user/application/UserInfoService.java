package back.vybz.userservice.user.application;

import back.vybz.userservice.user.dto.request.RequestAddUserInfoDto;
import back.vybz.userservice.user.dto.request.RequestDeleteUserInfoDto;
import back.vybz.userservice.user.dto.request.RequestUpdateUserInfoDto;
import back.vybz.userservice.user.dto.response.ResponseUserInfoDto;
import back.vybz.userservice.user.dto.response.ResponseUserInfoListDto;

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
    List<ResponseUserInfoListDto> getAllUserInfo();

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
