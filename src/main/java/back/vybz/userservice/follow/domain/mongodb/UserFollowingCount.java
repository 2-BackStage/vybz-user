package back.vybz.userservice.follow.domain.mongodb;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@Document("user_following_count")
public class UserFollowingCount {

    @Id
    private String id;

    @Field(name = "user_uuid")
    private String userUuid;

    @Field(name = "total_following_count")
    private Integer totalFollowingCount;

    @Builder
    public UserFollowingCount(String id, String userUuid, Integer totalFollowingCount) {
        this.id = id;
        this.userUuid = userUuid;
        this.totalFollowingCount = totalFollowingCount;
    }
}
