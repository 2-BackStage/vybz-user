package back.vybz.userservice.busker.domain.mysql;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BuskerState {

    PENDING("대기"),
    APPROVED("승인"),
    REJECTED("거절");

    private final String description;

}
