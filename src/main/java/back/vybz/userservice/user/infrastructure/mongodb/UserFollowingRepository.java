package back.vybz.userservice.user.infrastructure.mongodb;

import back.vybz.userservice.user.domain.mongodb.UserFollowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserFollowingRepository extends MongoRepository<UserFollowing, String> {

    /**
     * 사용자 uuid로 팔로잉 정보 조회
     * @param userUuid
     */
    List<UserFollowing> findByUserUuid(String userUuid);

    /**
     * 사용자 uuid와 버스커 uuid로 팔로잉 여부 확인
     * @param userUuid
     * @param buskerUuid
     */
    @Query(value = "{ 'userUuid': ?0, 'following.buskerUuid': ?1 }", exists = true)
    boolean existsByUserUuidAndBuskerUuid(String userUuid, String buskerUuid);

    /**
     * 사용자 uuid와 버스커 uuid로 팔로잉 정보 조회
     * @param userUuid
     * @param buskerUuid
     */
    @Query(value = "{ 'userUuid': ?0, 'following.buskerUuid': ?1 }")
    Optional<UserFollowing> findByUserUuidAndBuskerUuid(String userUuid, String buskerUuid);

}
