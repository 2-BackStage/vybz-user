package back.vybz.userservice.follow.vo.mongodb.response;

import back.vybz.userservice.follow.domain.mongodb.Follower;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseBuskerFollowerVo {

    private String buskerUuid;
    private List<Follower> follower;

    @Builder
    public ResponseBuskerFollowerVo(String buskerUuid, List<Follower> follower) {
        this.buskerUuid = buskerUuid;
        this.follower = follower;
    }

}
