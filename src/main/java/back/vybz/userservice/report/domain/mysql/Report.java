package back.vybz.userservice.report.domain.mysql;

import back.vybz.userservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "report")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * 신고한 유저 UUID
     * */
    @Column( nullable = false, length = 255)
    private String reportUserUuid;

    /*
     * 신고한 유저 타입
     * */
    @Enumerated(EnumType.STRING)
    @Column(name = "report_type", nullable = false, length = 20)
    private ReportUserType reportType;

    /*
     * 신고당한 유저 UUID
     * */
    @Column(name = "target_user_uuid", nullable = false, length = 255)
    private String targetUserUuid;

    /*
     * 신고당한 유저 타입
     * */
    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false, length = 20)
    private ReportUserType targetType;

    /*
     * 신고 사유
     * */
    @Column(nullable = false, length = 255)
    private String reason;

    @Builder
    public Report(String reportUserUuid,
                  ReportUserType reportType,
                  String targetUserUuid,
                  ReportUserType targetType,
                  String reason) {
        this.reportUserUuid = reportUserUuid;
        this.reportType = reportType;
        this.targetUserUuid = targetUserUuid;
        this.targetType = targetType;
        this.reason = reason;
    }


}
