package back.vybz.userservice.busker.domain.mongodb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@Document("follower_count")
public class FollowerCount {

    @Id
    private ObjectId id;

    // 버스커 uuid
    @Field(name = "busker_uuid")
    private String buskerUuid;

    // 총 팔로워 수
    @Field(name = "total_follower_count")
    private Integer totalFollowerCount = 0;

}
