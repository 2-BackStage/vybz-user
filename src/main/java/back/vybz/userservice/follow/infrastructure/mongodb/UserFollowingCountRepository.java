package back.vybz.userservice.follow.infrastructure.mongodb;

import back.vybz.userservice.follow.domain.mongodb.UserFollowingCount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserFollowingCountRepository extends MongoRepository<UserFollowingCount, String> {

    /**
     * 사용자 uuid로 팔로잉 수 조회
     * @param userUuid
     */
    Optional<UserFollowingCount> findByUserUuid(String userUuid);

}
