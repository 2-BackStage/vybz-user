package back.vybz.userservice.user.domain.mongodb;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@NoArgsConstructor
@Document("user_following")
public class UserFollowing {

    @Id
    private ObjectId id;

    @Field(name = "user_uuid")
    private String userUuid;

    @Field(name = "following")
    private List<Following> following;

    @Builder
    public UserFollowing(ObjectId id, String userUuid, List<Following> following) {
        this.id = id;
        this.userUuid = userUuid;
        this.following = following;
    }
}
