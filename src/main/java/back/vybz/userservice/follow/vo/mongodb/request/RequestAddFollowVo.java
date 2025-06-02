package back.vybz.userservice.follow.vo.mongodb.request;

import back.vybz.userservice.follow.domain.mongodb.Follower;
import back.vybz.userservice.follow.domain.mongodb.Following;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RequestAddFollowVo {

    private List<Follower> follower;
    private List<Following> following;

}
