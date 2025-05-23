package back.vybz.userservice.admin.dto.request;

import back.vybz.userservice.admin.domain.mysql.Category;
import back.vybz.userservice.admin.vo.request.RequestAddCategoryVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestAddCategoryDto {

    private String name;

    @Builder
    public RequestAddCategoryDto(String name) {
        this.name = name;
    }

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .build();
    }

    public static RequestAddCategoryDto from(RequestAddCategoryVo requestAddCategoryVo) {
        return RequestAddCategoryDto.builder()
                .name(requestAddCategoryVo.getName())
                .build();
    }

}
