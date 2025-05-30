package back.vybz.userservice.user.vo.mysql.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class RequestUpdateUserInfoVo {

    private String userUuid;
    private MultipartFile profileImage;
    private String nickname;

}
