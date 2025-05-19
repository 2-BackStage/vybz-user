package back.vybz.userservice.busker.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "busker_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BuskerMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    /**
     * 버스커 uuid
     */
    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    /**
     * 버스커 그룹 uuid
     */
    @Column(name = "group_uuid", nullable = false)
    private String groupUuid;

    /**
     * 상태
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private BuskerState state;

    @Builder
    public BuskerMember(Long id, String userUuid, String groupUuid, BuskerState state) {
        this.id = id;
        this.userUuid = userUuid;
        this.groupUuid = groupUuid;
        this.state = state;
    }

}
