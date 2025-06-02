package back.vybz.userservice.follow.application.mongodb;

import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import back.vybz.userservice.follow.domain.mongodb.Follow;
import back.vybz.userservice.follow.dto.mongodb.request.RequestAddFollowDto;
import back.vybz.userservice.follow.dto.mongodb.request.RequestDeleteFollowDto;
import back.vybz.userservice.follow.dto.mongodb.response.ResponseFollowDto;
import back.vybz.userservice.follow.infrastructure.mongodb.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    /**
     * 팔로우 생성
     * @param requestAddFollowDto
     */
    @Override
    public void createFollow(RequestAddFollowDto requestAddFollowDto) {
        if(followRepository.existsByUserUuidAndBuskerUuid(
                requestAddFollowDto.getFollower().get(0).getUserUuid(), requestAddFollowDto.getFollowing().get(0).getBuskerUuid())) {
            throw new BaseException(BaseResponseStatus.ALREADY_FOLLOWED);
        }
        followRepository.save(requestAddFollowDto.toDocument());
    }

    /**
     * 팔로우 여부 확인
     * @param userUuid
     * @param buskerUuid
     * @return
     */
    @Override
    public boolean checkFollow(String userUuid, String buskerUuid) {
        return followRepository.existsByUserUuidAndBuskerUuid(userUuid, buskerUuid);
    }

    /**
     * 유저 팔로잉 리스트 조회
     * @param userUuid
     */
    @Override
    public List<ResponseFollowDto> getFollowingByUserUuid(String userUuid) {
        return followRepository.findAllByUserUuid(userUuid)
                .stream()
                .map(ResponseFollowDto::from)
                .toList();
    }

    /**
     * 버스커 팔로워 리스트 조회
     * @param buskerUuid
     */
    @Override
    public List<ResponseFollowDto> getFollowerByBuskerUuid(String buskerUuid) {
        return followRepository.findAllByBuskerUuid(buskerUuid)
                .stream()
                .map(ResponseFollowDto::from)
                .toList();
    }

    /**
     * 팔로우 삭제
     * @param requestDeleteFollowDto
     */
    @Override
    public void deleteFollowing(RequestDeleteFollowDto requestDeleteFollowDto) {
        Follow follow = followRepository.findByUserUuidAndBuskerUuid(requestDeleteFollowDto.getUserUuid(), requestDeleteFollowDto.getBuskerUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FOLLOW));
        followRepository.delete(follow);
    }

}
