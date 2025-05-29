package back.vybz.userservice.user.dto.mongodb.response;

import back.vybz.userservice.user.domain.mongodb.Following;
import back.vybz.userservice.user.domain.mongodb.UserFollowing;
import back.vybz.userservice.user.vo.mongodb.response.ResponseUserFollowingVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ResponseUserFollowingDto {

    private String userUuid;
    private List<Following> following;

    @Builder
    public ResponseUserFollowingDto(String userUuid, List<Following> following) {
        this.userUuid = userUuid;
        this.following = following;
    }

    public static ResponseUserFollowingDto from(UserFollowing userFollowing) {
        return ResponseUserFollowingDto.builder()
                .userUuid(userFollowing.getUserUuid())
                .following(userFollowing.getFollowing())
                .build();
    }

    public ResponseUserFollowingVo toVo() {
        return ResponseUserFollowingVo.builder()
                .userUuid(userUuid)
                .following(following)
                .build();
    }

}
