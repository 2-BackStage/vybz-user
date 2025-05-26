package back.vybz.userservice.busker.infrastructure;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuskerInfoRepository extends JpaRepository<BuskerInfo, Long> {

    /**
     * 버스커 uuid로 삭제되지 않은 버스커 조회
     * @param userUuid
     */
    Optional<BuskerInfo> findByUserUuidAndDeletedFalse(String userUuid);

    /**
     * 버스커 uuid로 버스커 존재 여부 확인
     * @param userUuid
     */
    boolean existsByUserUuid(String userUuid);

    /**
     * 삭제되지 않은 모든 버스커 조회
     */
    List<BuskerInfo> findAllByDeletedFalse();

}
