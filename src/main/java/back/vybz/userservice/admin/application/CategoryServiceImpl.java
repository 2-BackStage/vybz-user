package back.vybz.userservice.admin.application;

import back.vybz.userservice.admin.domain.mysql.Category;
import back.vybz.userservice.admin.dto.request.RequestAddCategoryDto;
import back.vybz.userservice.admin.dto.request.RequestDeleteCategoryDto;
import back.vybz.userservice.admin.dto.request.RequestUpdateCategoryDto;
import back.vybz.userservice.admin.dto.response.ResponseCategoryDto;
import back.vybz.userservice.admin.infrastructure.CategoryRepository;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 추가
     * @param requestAddCategoryDto
     */
    @Transactional
    @Override
    public void createCategory(RequestAddCategoryDto requestAddCategoryDto) {
        if(categoryRepository.existsByName(requestAddCategoryDto.getName())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_CATEGORY);
        }
        categoryRepository.save(requestAddCategoryDto.toEntity());
    }

    /**
     * 카테고리 id로 카테고리 조회
     * @param id
     */
    @Override
    public ResponseCategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY));
        return ResponseCategoryDto.from(category);
    }

    /**
     * 카테고리 이름으로 카테고리 조회
     * @param name
     */
    @Override
    public ResponseCategoryDto getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY));
        return ResponseCategoryDto.from(category);
    }

    /**
     * 카테고리 전체 조회
     */
    @Override
    public List<ResponseCategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(ResponseCategoryDto::from)
                .toList();
    }

    /**
     * 카테고리 수정
     * @param requestUpdateCategoryDto
     */
    @Transactional
    @Override
    public void updateCategory(RequestUpdateCategoryDto requestUpdateCategoryDto) {
        categoryRepository.save(requestUpdateCategoryDto.updateEntity());
    }

    /**
     * 카테고리 삭제
     * @param requestDeleteCategoryDto
     */
    @Transactional
    @Override
    public void deleteCategory(RequestDeleteCategoryDto requestDeleteCategoryDto) {
        Category category = categoryRepository.findById(requestDeleteCategoryDto.getId())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_CATEGORY));
        categoryRepository.delete(category);
    }

}
