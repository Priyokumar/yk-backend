package prilax.yk.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.product.*;
import prilax.yk.service.product.CategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public CategoriesResponseDto findCategories(@RequestParam(name = "topCategory", required = false) Boolean topCategory)   {
        return categoryService.findCategories(topCategory);
    }

    @PostMapping
    public ResponseEntity<ActionResponseDto> createOrUpdateCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        ActionResponseDto response = categoryService.createOrUpdateCategory(categoryRequestDto, null);
        ResponseEntity<ActionResponseDto> responseEntity = new ResponseEntity<ActionResponseDto>(response,
                HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public CategoryResponseDto findCategory(@PathVariable("id") String id) {
        return categoryService.findCategory(id);
    }

    @PutMapping(value = "/{id}")
    public ActionResponseDto createOrUpdateCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto, @PathVariable("id") String id) {
        return categoryService.createOrUpdateCategory(categoryRequestDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public ActionResponseDto deleteCategory(@PathVariable("id") String id) {
        return categoryService.deleteCategory(id);
    }

}
