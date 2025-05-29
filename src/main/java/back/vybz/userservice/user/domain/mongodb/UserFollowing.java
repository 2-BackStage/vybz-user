package back.vybz.userservice.user.domain.mongodb;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Getter
@NoArgsConstructor
@Document("user_following")
public class UserFollowing {

    @Id
    private String id;

    @Field(name = "user_uuid")
    private String userUuid;

    @Field(name = "following")
    private List<Following> following;

    @CreatedDate
    @Field(name = "created_at")
    private Instant createdAt;

    @LastModifiedDate
    @Field(name = "updated_at")
    private Instant updatedAt;

    @Builder
    public UserFollowing(String id, String userUuid, List<Following> following) {
        this.id = id;
        this.userUuid = userUuid;
        this.following = following;
    }
}
