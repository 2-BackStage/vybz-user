package back.vybz.userservice.user.application.mongodb;

import back.vybz.userservice.user.dto.mongodb.request.RequestAddUserFollowingDto;
import back.vybz.userservice.user.dto.mongodb.request.RequestDeleteUserFollowingDto;
import back.vybz.userservice.user.dto.mongodb.response.ResponseUserFollowingDto;

import java.util.List;

public interface UserFollowingService {

    /**
     * 사용자 팔로우 등록
     * @param requestAddUserFollowingDto
     */
    void createFollowing(RequestAddUserFollowingDto requestAddUserFollowingDto);

    /**
     * 사용자 팔로우 여부 확인
     * @param userUuid
     * @param buskerUuid
     */
    boolean checkFollowing(String userUuid, String buskerUuid);

    /**
     * 사용자 팔로우 리스트 조회
     * @param userUuid
     */
    List<ResponseUserFollowingDto> getFollowingByUserUuid(String userUuid);

    /**
     * 사용자 팔로우 삭제
     * @param requestDeleteUserFollowingDto
     */
    void deleteFollowing(RequestDeleteUserFollowingDto requestDeleteUserFollowingDto);

}
