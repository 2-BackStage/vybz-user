package back.vybz.userservice.user.dto.request;

import back.vybz.userservice.user.vo.request.RequestDeleteUserInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteUserInfoDto {

    private String userUuid;

    @Builder
    public RequestDeleteUserInfoDto(String userUuid) {
        this.userUuid = userUuid;
    }

    public static RequestDeleteUserInfoDto from(RequestDeleteUserInfoVo requestDeleteUserInfoVo) {
        return RequestDeleteUserInfoDto.builder()
                .userUuid(requestDeleteUserInfoVo.getUserUuid())
                .build();
    }

}
