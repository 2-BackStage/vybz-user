package back.vybz.userservice.busker.dto.mysql.request;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.vo.mysql.request.RequestUpdateBuskerInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class RequestUpdateBuskerInfoDto {

    private String userUuid;
    private MultipartFile profileImageUrl;
    private String nickname;
    private Long categoryId;

    @Builder
    public RequestUpdateBuskerInfoDto(String userUuid, MultipartFile profileImageUrl, String nickname, Long categoryId) {
        this.userUuid = userUuid;
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
        this.categoryId = categoryId;
    }

    public void updateEntity(BuskerInfo buskerInfo, String imageUrl) {
        if (nickname != null) {
            buskerInfo.updateNickname(nickname);
        }
        if (categoryId != null) {
            buskerInfo.updateCategoryId(categoryId);
        }
        if (profileImageUrl != null && !profileImageUrl.isEmpty() && imageUrl != null) {
            buskerInfo.updateProfileImage(imageUrl);
        }
    }

    public static RequestUpdateBuskerInfoDto from(RequestUpdateBuskerInfoVo requestUpdateBuskerInfoVo) {
        return RequestUpdateBuskerInfoDto.builder()
                .userUuid(requestUpdateBuskerInfoVo.getUserUuid())
                .profileImageUrl(requestUpdateBuskerInfoVo.getProfileImageUrl())
                .nickname(requestUpdateBuskerInfoVo.getNickname())
                .categoryId(requestUpdateBuskerInfoVo.getCategoryId())
                .build();
    }

}
