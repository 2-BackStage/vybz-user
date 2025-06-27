package back.vybz.user_info_service.user_info.infrastructure;

import back.vybz.user_info_service.user_info.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    /**
     * 유저 uuid로 삭제되지 않은 유저 조회
     * @param userUuid
     */
    Optional<UserInfo> findByUserUuidAndDeletedFalse(String userUuid);

    /**
     * 유저 uuid로 유저 존재 여부 확인
     * @param userUuid
     */
    boolean existsByUserUuid(String userUuid);

    /**
     * 유저 uuid에 해당하는 유저 정보 조회
     * @param userUuid
     */
    List<UserInfo> findByUserUuidIn(List<String> userUuid);

}
