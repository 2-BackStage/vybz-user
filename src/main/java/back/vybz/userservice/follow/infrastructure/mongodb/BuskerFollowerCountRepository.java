package back.vybz.userservice.follow.infrastructure.mongodb;

import back.vybz.userservice.follow.domain.mongodb.BuskerFollowerCount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BuskerFollowerCountRepository extends MongoRepository<BuskerFollowerCount, String> {

    /**
     * 버스커 uuid로 팔로워 수 조회
     * @param buskerUuid
     */
    Optional<BuskerFollowerCount> findByBuskerUuid(String buskerUuid);

}
