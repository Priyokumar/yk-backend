package prilax.yk.dao.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import prilax.yk.entity.catalog.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    @Query(value = "SELECT entity FROM Product entity WHERE entity.category.id = :categoryId")
    public List<Product> findProductsCategory(@Param("categoryId") String categoryId);
}
