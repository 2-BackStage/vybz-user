package back.vybz.userservice.follow.application.mongodb;

import back.vybz.userservice.follow.dto.mongodb.response.ResponseBuskerFollowerCountDto;
import back.vybz.userservice.follow.dto.mongodb.response.ResponseUserFollowingCountDto;

public interface FollowCountService {

    /**
     * 사용자 팔로잉 수 조회
     * @param userUuid
     */
    ResponseUserFollowingCountDto getUserFollowingCount(String userUuid);

    /**
     * 버스커 팔로워 수 조회
     * @param buskerUuid
     */
    ResponseBuskerFollowerCountDto getBuskerFollowerCount(String buskerUuid);

}
