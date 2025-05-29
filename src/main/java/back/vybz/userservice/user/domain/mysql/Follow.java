package back.vybz.userservice.user.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import back.vybz.userservice.common.entity.SoftDeletableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow extends SoftDeletableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    /**
     * 회원 UUID
     * */
    @Column(nullable = false)
    private String userUuid;

    /**
     * 버스커 UUID
     * */
    @Column(nullable = false)
    private String buskerUuid;

    @Builder
    public Follow(Long id, String userUuid, String buskerUuid) {
        this.id = id;
        this.userUuid = userUuid;
        this.buskerUuid = buskerUuid;
    }
}
