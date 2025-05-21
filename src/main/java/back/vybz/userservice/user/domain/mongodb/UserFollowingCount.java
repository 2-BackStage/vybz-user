package back.vybz.userservice.user.domain.mongodb;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@Document("user_following_count")
public class UserFollowingCount {

    @Id
    private ObjectId id;

    @Field(name = "user_uuid")
    private String userUuid;

    @Field(name = "total_following_count")
    private Integer totalFollowingCount;

    @Builder
    public UserFollowingCount(ObjectId id, String userUuid, Integer totalFollowingCount) {
        this.id = id;
        this.userUuid = userUuid;
        this.totalFollowingCount = totalFollowingCount;
    }
}
