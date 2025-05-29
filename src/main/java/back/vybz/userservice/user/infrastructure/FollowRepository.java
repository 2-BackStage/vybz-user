package back.vybz.userservice.user.infrastructure;

import back.vybz.userservice.user.domain.mysql.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    /**
     * 팔로우 여부 확인
     * @param userUuid
     * @param buskerUuid
     */
    boolean existsByUserUuidAndBuskerUuid(String userUuid, String buskerUuid);

    /**
     * 삭제되지 않은 팔로우 유무 확인
     * @param userUuid
     * @param buskerUuid
     */
    boolean existsByUserUuidAndBuskerUuidAndDeletedFalse(String userUuid, String buskerUuid);

    /**
     * 팔로우 정보 조회
     * @param userUuid
     * @param buskerUuid
     */
    Optional<Follow> findByUserUuidAndBuskerUuid(String userUuid, String buskerUuid);

}
