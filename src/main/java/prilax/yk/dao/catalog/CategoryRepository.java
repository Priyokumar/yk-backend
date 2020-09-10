package prilax.yk.dao.catalog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import prilax.yk.entity.catalog.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {

    @Query(value = "SELECT entity FROM Category entity WHERE entity.topCategory = :topCategory")
    public List<Category> findCategoryByTopCategory(@Param("topCategory") Boolean topCategory);


}
