package back.vybz.userservice.user.dto.response;

import back.vybz.userservice.user.domain.mysql.UserInfo;
import back.vybz.userservice.user.vo.response.ResponseUserInfoListVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUserInfoListDto {

    private String userUuid;

    @Builder
    public ResponseUserInfoListDto(String userUuid) {
        this.userUuid = userUuid;
    }

    public static ResponseUserInfoListDto from(UserInfo userInfo) {
        return ResponseUserInfoListDto.builder()
                .userUuid(userInfo.getUserUuid())
                .build();
    }

    public ResponseUserInfoListVo toVo() {
        return ResponseUserInfoListVo.builder()
                .userUuid(userUuid)
                .build();
    }

}
