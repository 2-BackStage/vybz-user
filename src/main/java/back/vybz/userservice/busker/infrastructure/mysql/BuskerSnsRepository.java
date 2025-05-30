package back.vybz.userservice.busker.infrastructure.mysql;

import back.vybz.userservice.busker.domain.mysql.BuskerSns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuskerSnsRepository extends JpaRepository<BuskerSns, Long> {

    /**
     * 유저 uuid와 snsUrl로 버스커 sns 확인
     * @param userUuid
     * @param snsUrl
     */
    boolean existsByUserUuidAndSnsUrlAndDeletedFalse(String userUuid, String snsUrl);

    /**
     * 유저 uuid와 snsUrl로 버스커 sns 조회
     * @param userUuid
     * @param snsUrl
     */
    Optional<BuskerSns> findByUserUuidAndSnsUrlAndDeletedFalse(String userUuid, String snsUrl);

    /**
     * 유저 uuid로 버스커 sns 조회
     * @param userUuid
     */
    List<BuskerSns> findAllByUserUuidAndDeletedFalse(String userUuid);

}
