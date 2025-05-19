package back.vybz.userservice.agreement.domain.mysql;

import lombok.Getter;

@Getter
public enum AgreementCategory {

    MEMBER("회원 약관"),
    PRIVACY("개인정보 처리방침"),
    LIVE("라이브 서비스 약관"),
    SETTLEMENT("정산 약관"),
    DONATION("후원 약관");

    private final String description;
    AgreementCategory(String description) {
        this.description = description;
    }
}
