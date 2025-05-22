package back.vybz.userservice.report.domain.mysql;

import lombok.Getter;

@Getter
public enum ReportUserType {
    USER("일반 유저"),
    BUSKER("버스커");

    private final String description;

    ReportUserType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

