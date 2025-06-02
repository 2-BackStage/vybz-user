package back.vybz.userservice.follow.application.mongodb;

import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import back.vybz.userservice.follow.domain.mongodb.BuskerFollowerCount;
import back.vybz.userservice.follow.domain.mongodb.UserFollowingCount;
import back.vybz.userservice.follow.dto.mongodb.response.ResponseBuskerFollowerCountDto;
import back.vybz.userservice.follow.dto.mongodb.response.ResponseUserFollowingCountDto;
import back.vybz.userservice.follow.infrastructure.mongodb.BuskerFollowerCountRepository;
import back.vybz.userservice.follow.infrastructure.mongodb.UserFollowingCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowCountServiceImpl implements FollowCountService {

    private final UserFollowingCountRepository userFollowingCountRepository;
    private final BuskerFollowerCountRepository buskerFollowerCountRepository;

    /**
     * 유저의 팔로잉 수 조회
     * @param userUuid
     */
    @Override
    public ResponseUserFollowingCountDto getUserFollowingCount(String userUuid) {
        UserFollowingCount userFollowingCount = userFollowingCountRepository.findByUserUuid(userUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_USER));
        return ResponseUserFollowingCountDto.from(userFollowingCount);
    }

    /**
     * 버스커의 팔로워 수 조회
     * @param buskerUuid
     */
    @Override
    public ResponseBuskerFollowerCountDto getBuskerFollowerCount(String buskerUuid) {
        BuskerFollowerCount buskerFollowerCount = buskerFollowerCountRepository.findByBuskerUuid(buskerUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER));
        return ResponseBuskerFollowerCountDto.from(buskerFollowerCount);
    }
}
