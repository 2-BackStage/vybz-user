package back.vybz.userservice.user_withdrwal_pending.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_withdrawal_pending")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserWithdrawalPending extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 회원 UUID
     */
    @Column(name = "user_uuid", nullable = false, unique = true, length = 40, updatable = false)
    private String userUuid;

    /**
     * 탈퇴 신청 일시
     */

    @Column(name = "request_at", nullable = false, updatable = false)
    private LocalDate requestAt;

    /**
     * 탈퇴 예정 일시
     */

    @Column(name = "scheduled_at", nullable = false, updatable = false)
    private LocalDate scheduledAt;

    /**
     * 이유
     */

    @Column(name = "reason", nullable = false, length = 255)
    private String reason;


    @Builder
    public UserWithdrawalPending(String userUuid,
                                 LocalDate requestAt,
                                 LocalDate scheduledAt,
                                 String reason) {
        this.userUuid = userUuid;
        this.requestAt = requestAt;
        this.scheduledAt = scheduledAt;
        this.reason = reason;
    }
}
