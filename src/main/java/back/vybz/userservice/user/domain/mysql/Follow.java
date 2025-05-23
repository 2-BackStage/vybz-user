package back.vybz.userservice.user.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    /**
     * 회원 UUID
     * */
    @Column(nullable = false, length = 255)
    private String userUuid;

    /**
     * 버스커 UUID
     * */
    @Column(nullable = false, length = 255)
    private String buskerUuid;

    @Builder
    public Follow(String userUuid,
                  String buskerUuid) {
        this.userUuid = userUuid;
        this.buskerUuid = buskerUuid;
    }
}
