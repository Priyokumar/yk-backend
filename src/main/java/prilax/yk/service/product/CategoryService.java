package prilax.yk.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prilax.yk.dao.catalog.CategoryRepository;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.common.ApiUtilDto;
import prilax.yk.dto.product.*;
import prilax.yk.entity.catalog.Category;
import prilax.yk.error.exception.NotFoundException;
import prilax.yk.service.common.CommonService;
import prilax.yk.util.Util;
import prilax.yk.vo.common.FieldType;
import prilax.yk.vo.common.Filter;
import prilax.yk.vo.common.Operator;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CommonService commonService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoriesResponseDto findCategories(Boolean topCategory) {

        CategoriesResponseDto res = new CategoriesResponseDto();

        List<Category> categories = null;

        if(topCategory != null){

            List<Filter> filters = new ArrayList<>();
            filters.add(new Filter("topCategory", Operator.EQUAL,FieldType.STRING,topCategory));
            categories=  commonService.find(filters,Category.class);

        } else {
            categories = commonService.findAll(Category.class);
        }

        if (!Util.isAllPresent(categories))
            throw new NotFoundException("No categories are found !");

        List<CategoryDto> categoriesDto = new ArrayList<>();
        categories.forEach(category->{
            categoriesDto.add(setCategoryToDto(category));
        });

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        res.setData(categoriesDto);

        return res;
    }

    public ActionResponseDto createOrUpdateCategory(CategoryRequestDto categoryRequestDto, String id) {

        ActionResponseDto res = new ActionResponseDto();

        Category category = new Category();
        if (Util.isAllPresent(id)) {
            category = commonService.findById(id, Category.class);
            if (!Util.isAllPresent(category))
                throw new NotFoundException("No category are found !");
        }

        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        category.setTopCategory(categoryRequestDto.getTopCategory());

        category.setSubCategories(new ArrayList<>());
        List<String> subCategoryIds = categoryRequestDto.getSubCategoryIds();
        if (Util.isAllPresent(subCategoryIds)) {
            for(String subCategoryId: subCategoryIds){
                Category subCategory = commonService.findById(subCategoryId, Category.class);
                if(Util.isAllPresent(subCategory)){
                    category.getSubCategories().add(subCategory);
                }
            }
        }

        commonService.save(category);

        String message = "";
        if (Util.isAllPresent(id)) {
            message = "Successfully updated the category data";
            res.setApiMessage(ApiUtilDto.okMessage(message));
        } else {
            message = "Successfully created a category";
            res.setApiMessage(ApiUtilDto.createdMessage(message));
            res.setActionMessage(message);
        }

        return res;
    }

    public CategoryResponseDto findCategory(String id) {

        CategoryResponseDto res = new CategoryResponseDto();

        Category category = commonService.findById(id, Category.class);

        if (!Util.isAllPresent(category))
            throw new NotFoundException("No category can be found !");

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        res.setData(setCategoryToDto(category));

        return res;
    }

    public CategoryDto setCategoryToDto(Category category) {

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setTopCategory(category.getTopCategory());

        List<Category> subCategories = category.getSubCategories();
        if (Util.isAllPresent(subCategories)) {
            List<CategoryDto> categoriesDto = new ArrayList<>();
            subCategories.forEach(subCategory->{
                categoriesDto.add(setCategoryToDto(subCategory));
            });
            categoryDto.setSubCategories(categoriesDto);
        }
        return categoryDto;
    }

    public ActionResponseDto deleteCategory(String id) {

        ActionResponseDto res = new ActionResponseDto();

        Category category = commonService.findById(id, Category.class);

        if (!Util.isAllPresent(category))
            throw new NotFoundException("No category can be found !");

        commonService.delete(category);

        res.setApiMessage(ApiUtilDto.okMessage("Successfully deleted"));
        return res;
    }
}
