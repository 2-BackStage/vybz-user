package back.vybz.userservice.user.application.mongodb;

import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import back.vybz.userservice.user.domain.mongodb.UserFollowing;
import back.vybz.userservice.user.dto.mongodb.request.RequestAddUserFollowingDto;
import back.vybz.userservice.user.dto.mongodb.request.RequestDeleteUserFollowingDto;
import back.vybz.userservice.user.dto.mongodb.response.ResponseUserFollowingDto;
import back.vybz.userservice.user.infrastructure.mongodb.UserFollowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFollowingServiceImpl implements UserFollowingService {

    private final UserFollowingRepository userFollowingRepository;

    /**
     * 사용자 팔로우 생성
     * @param requestAddUserFollowingDto
     */
    @Override
    public void createFollowing(RequestAddUserFollowingDto requestAddUserFollowingDto) {
        if (userFollowingRepository.existsByUserUuidAndBuskerUuid(requestAddUserFollowingDto.getUserUuid(), requestAddUserFollowingDto.getFollowing().get(0).getBuskerUuid())) {
            throw new BaseException(BaseResponseStatus.ALREADY_FOLLOWED);
        }
        userFollowingRepository.save(requestAddUserFollowingDto.toDocument());
    }

    /**
     * 사용자 팔로우 여부 확인
     * @param userUuid
     * @param buskerUuid
     */
    @Override
    public boolean checkFollowing(String userUuid, String buskerUuid) {
        return userFollowingRepository.existsByUserUuidAndBuskerUuid(userUuid, buskerUuid);
    }

    /**
     * 사용자 팔로우 조회
     * @param userUuid
     */
    @Override
    public List<ResponseUserFollowingDto> getFollowingByUserUuid(String userUuid) {
        return userFollowingRepository.findByUserUuid(userUuid)
                .stream()
                .map(ResponseUserFollowingDto::from)
                .toList();
    }

    /**
     * 사용자 팔로우 삭제
     * @param requestDeleteUserFollowingDto
     */
    @Override
    public void deleteFollowing(RequestDeleteUserFollowingDto requestDeleteUserFollowingDto) {
        UserFollowing userFollowing = userFollowingRepository.findByUserUuidAndBuskerUuid(requestDeleteUserFollowingDto.getUserUuid(), requestDeleteUserFollowingDto.getBuskerUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FOLLOW));
        userFollowingRepository.delete(userFollowing);
    }

}
