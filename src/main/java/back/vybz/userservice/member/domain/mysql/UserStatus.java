package back.vybz.userservice.member.domain.mysql;

import lombok.Getter;

@Getter
public enum UserStatus {
    WITHDRAWAL("탈퇴"),
    ACTIVE("활성"),
    BANNED("정지");

    private final String description;

    UserStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

