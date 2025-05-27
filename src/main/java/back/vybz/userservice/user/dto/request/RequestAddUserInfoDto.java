package back.vybz.userservice.user.dto.request;

import back.vybz.userservice.user.domain.mysql.UserInfo;
import back.vybz.userservice.user.vo.request.RequestAddUserInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddUserInfoDto {

    private String userUuid;
    private String nickname;

    @Builder
    public RequestAddUserInfoDto(String userUuid, String nickname) {
        this.userUuid = userUuid;
        this.nickname = nickname;
    }

    public UserInfo toEntity() {
        return UserInfo.builder()
                .userUuid(userUuid)
                .nickname(nickname)
                .build();
    }

    public static RequestAddUserInfoDto from(RequestAddUserInfoVo requestAddUserInfoVo) {
        return RequestAddUserInfoDto.builder()
                .userUuid(requestAddUserInfoVo.getUserUuid())
                .nickname(requestAddUserInfoVo.getNickname())
                .build();
    }

}
