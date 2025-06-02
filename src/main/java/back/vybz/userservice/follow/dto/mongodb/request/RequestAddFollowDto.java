package back.vybz.userservice.follow.dto.mongodb.request;

import back.vybz.userservice.follow.domain.mongodb.Follow;
import back.vybz.userservice.follow.domain.mongodb.Follower;
import back.vybz.userservice.follow.domain.mongodb.Following;
import back.vybz.userservice.follow.vo.mongodb.request.RequestAddFollowVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RequestAddFollowDto {

    private List<Follower> follower;
    private List<Following> following;

    @Builder
    public RequestAddFollowDto(List<Follower> follower, List<Following> following) {
        this.follower = follower;
        this.following = following;
    }

    public Follow toDocument() {
        return Follow.builder()
                .follower(follower)
                .following(following)
                .build();
    }

    public static RequestAddFollowDto from(RequestAddFollowVo requestAddFollowVo) {
        return RequestAddFollowDto.builder()
                .follower(requestAddFollowVo.getFollower())
                .following(requestAddFollowVo.getFollowing())
                .build();
    }

}
