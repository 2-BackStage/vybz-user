package back.vybz.userservice.user.infrastructure;

import back.vybz.userservice.user.domain.mysql.UserInfo;
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
     * softdelete된 유저 중 프로필 이미지가 있는 유저 조회
     */
    List<UserInfo> findAllByDeletedTrueAndProfileImageUrlIsNotNull();

}
