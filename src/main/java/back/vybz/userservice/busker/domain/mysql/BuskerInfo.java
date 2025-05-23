package back.vybz.userservice.busker.domain.mysql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "busker_info")
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BuskerInfo {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    /**
     * 버스커 uuid
     */
    @Column(name = "user_uuid", nullable = false, unique = true)
    private String userUuid;

    /**
     * 회원 프로필사진URL
     * */
    @Column(name = "profile_image_url")
    private String profileImageUrl;

    /**
     * 버스커 활동명
     * */
    @Column(name = "nickname", nullable = false, length = 15)
    private String nickname;

    /**
     * 카테고리
     */
    @Column(name = "category_id", nullable = false)
    private Long categoryId;


}
