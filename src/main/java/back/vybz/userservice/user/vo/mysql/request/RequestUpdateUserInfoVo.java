package back.vybz.userservice.user.vo.mysql.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class RequestUpdateUserInfoVo {

    private String userUuid;
    private MultipartFile profileImage;
    private String nickname;

}
