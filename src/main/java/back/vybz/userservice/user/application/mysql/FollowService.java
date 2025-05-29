package back.vybz.userservice.user.application.mysql;

import back.vybz.userservice.user.dto.mysql.request.RequestToggleFollowDto;

public interface FollowService {

    /**
     * 팔로우 토글
     * @param requestToggleFollowDto
     */
    void toggleFollow(RequestToggleFollowDto requestToggleFollowDto);

    /**
     * 팔로우 상태 확인
     * @param userUuid
     * @param buskerUuid
     */
    boolean checkFollow(String userUuid, String buskerUuid);

}
