package back.vybz.userservice.user.application.mysql;

import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import back.vybz.userservice.user.domain.mysql.Follow;
import back.vybz.userservice.user.dto.mysql.request.RequestToggleFollowDto;
import back.vybz.userservice.user.infrastructure.mysql.FollowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    /**
     * 팔로우 토글
     *
     * @param requestToggleFollowDto
     */
    @Transactional
    @Override
    public void toggleFollow(RequestToggleFollowDto requestToggleFollowDto) {
        boolean exists = followRepository.existsByUserUuidAndBuskerUuid(requestToggleFollowDto.getUserUuid(), requestToggleFollowDto.getBuskerUuid());

        if (exists) {
            Follow follow = followRepository.findByUserUuidAndBuskerUuid(requestToggleFollowDto.getUserUuid(), requestToggleFollowDto.getBuskerUuid())
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_FOLLOW));
            follow.toggleDelete();
            return;
        }

        followRepository.save(requestToggleFollowDto.toEntity());
    }

    /**
     * 팔로우 여부 확인
     * @param userUuid
     * @param buskerUuid
     */
    @Transactional
    @Override
    public boolean checkFollow(String userUuid, String buskerUuid) {
        return followRepository.existsByUserUuidAndBuskerUuidAndDeletedFalse(userUuid, buskerUuid);
    }

}
