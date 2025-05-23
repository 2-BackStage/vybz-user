package back.vybz.userservice.admin.dto.request;

import back.vybz.userservice.admin.domain.mysql.Category;
import back.vybz.userservice.admin.vo.request.RequestUpdateCategoryVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUpdateCategoryDto {

    private Long id;
    private String name;

    @Builder
    public RequestUpdateCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category updateEntity() {
        return Category.builder()
                .id(id)
                .name(name)
                .build();
    }

    public static RequestUpdateCategoryDto from(RequestUpdateCategoryVo requestUpdateCategoryVo) {
        return RequestUpdateCategoryDto.builder()
                .id(requestUpdateCategoryVo.getId())
                .name(requestUpdateCategoryVo.getName())
                .build();
    }

}
