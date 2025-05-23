package back.vybz.userservice.admin.dto.request;

import back.vybz.userservice.admin.vo.request.RequestDeleteCategoryVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestDeleteCategoryDto {

    private Long id;

    @Builder
    public RequestDeleteCategoryDto(Long id) {
        this.id = id;
    }

    public static RequestDeleteCategoryDto from(RequestDeleteCategoryVo requestDeleteCategoryVo) {
        return RequestDeleteCategoryDto.builder()
                .id(requestDeleteCategoryVo.getId())
                .build();
    }

}
