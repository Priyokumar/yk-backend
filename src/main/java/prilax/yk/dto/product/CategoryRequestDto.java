package prilax.yk.dto.product;

import java.io.Serializable;
import java.util.List;

public class CategoryRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String description;

    private Boolean topCategory;

    private List<String> subCategoryIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSubCategoryIds() {
        return subCategoryIds;
    }

    public void setSubCategoryIds(List<String> subCategoryIds) {
        this.subCategoryIds = subCategoryIds;
    }

    public Boolean getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(Boolean topCategory) {
        this.topCategory = topCategory;
    }
}
