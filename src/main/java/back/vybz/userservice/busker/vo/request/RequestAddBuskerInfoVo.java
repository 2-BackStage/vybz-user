package back.vybz.userservice.busker.vo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class RequestAddBuskerInfoVo {

    private String userUuid;
    private MultipartFile profileImageUrl;
    private String nickname;
    private Long categoryId;

}
