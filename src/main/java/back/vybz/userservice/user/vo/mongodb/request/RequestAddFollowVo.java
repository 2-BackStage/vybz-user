package back.vybz.userservice.user.vo.mongodb.request;

import back.vybz.userservice.user.domain.mongodb.Follower;
import back.vybz.userservice.user.domain.mongodb.Following;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RequestAddFollowVo {

    private List<Follower> follower;
    private List<Following> following;

}
