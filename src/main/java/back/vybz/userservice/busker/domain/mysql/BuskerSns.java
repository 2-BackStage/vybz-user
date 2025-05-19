package back.vybz.userservice.busker.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "busker_sns")
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BuskerSns extends BaseEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    /**
     * 버스커 uuid
     */
    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    /**
     * 버스커 sns Url
     */
    @Column(name = "sns_url", nullable = false)
    private String snsUrl;

    @Builder
    public BuskerSns(Long id, String userUuid, String snsUrl) {
        this.id = id;
        this.userUuid = userUuid;
        this.snsUrl = snsUrl;
    }

}
