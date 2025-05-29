package back.vybz.userservice.user.dto.mongodb.request;

import back.vybz.userservice.user.domain.mongodb.Following;
import back.vybz.userservice.user.domain.mongodb.UserFollowing;
import back.vybz.userservice.user.vo.mongodb.request.RequestAddUserFollowingVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RequestAddUserFollowingDto {

    private String userUuid;
    private List<Following> following;

    @Builder
    public RequestAddUserFollowingDto(String userUuid, List<Following> following) {
        this.userUuid = userUuid;
        this.following = following;
    }

    public UserFollowing toDocument() {
        return UserFollowing.builder()
                .userUuid(userUuid)
                .following(following)
                .build();
    }

    public static RequestAddUserFollowingDto from(RequestAddUserFollowingVo requestAddUserFollowingVo) {
        return RequestAddUserFollowingDto.builder()
                .userUuid(requestAddUserFollowingVo.getUserUuid())
                .following(requestAddUserFollowingVo.getFollowing())
                .build();
    }

}
