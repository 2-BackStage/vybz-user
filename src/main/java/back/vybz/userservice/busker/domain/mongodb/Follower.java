package back.vybz.userservice.busker.domain.mongodb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@NoArgsConstructor
@Document("follower")
public class Follower {

    @Id
    private ObjectId id;

    // 버스커 uuid
    @Field(name = "busker_uuid")
    private String buskerUuid;

    // 팔로잉 리스트
    @Field(name = "following")
    private List<Following> following;

}
