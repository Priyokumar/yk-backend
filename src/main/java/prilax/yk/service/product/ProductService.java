package prilax.yk.service.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prilax.yk.dao.product.ProductRepository;
import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.common.ApiUtilDto;
import prilax.yk.dto.product.*;
import prilax.yk.entity.catalog.Category;
import prilax.yk.entity.catalog.Product;
import prilax.yk.error.exception.NotFoundException;
import prilax.yk.service.common.CommonService;
import prilax.yk.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommonService commonService;

    public ProductsResponseDto findProducts(String categoryId) {

        ProductsResponseDto res = new ProductsResponseDto();

        List<Product> products = null;

        if(Util.isAllPresent(categoryId)){
            products = productRepository.findProductsCategory(categoryId);
        } else{
            products = (List<Product>) productRepository.findAll();
        }

        if (!Util.isAllPresent(products))
            throw new NotFoundException("No products are found !");

        List<ProductDto> productsDto = new ArrayList<>();
        products.forEach(product -> {
            productsDto.add(setProductToDto(product));
        });

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        res.setData(productsDto);

        return res;
    }

    public ActionResponseDto createOrUpdateProduct(ProductDto productDto, String id) {

        ActionResponseDto res = new ActionResponseDto();

        Product product = new Product();

        if (Util.isAllPresent(id)) {
            product = commonService.findById(id, Product.class);
            if (!Util.isAllPresent(product)) {
                throw new NotFoundException("Product not found.");
            }
        }

        product.setCustomizable(productDto.getCustomizable());
        product.setMediaId(productDto.getMediaId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setWeights(productDto.getWeights());
        product.setPcs(productDto.getPcs());
        product.setUnit(productDto.getUnit());

        String catId = productDto.getCategoryId();
            if(Util.isAllPresent(catId)) {
                Category category = commonService.findById(catId, Category.class);
                if(Util.isAllPresent(category)){
                    product.setCategory(category);
                }
            }

        commonService.save(product);

        String message = "";
        if (Util.isAllPresent(id)) {
            message = "Successfully updated the product data";
            res.setApiMessage(ApiUtilDto.okMessage(message));
        } else {
            message = "Successfully created a product";
            res.setApiMessage(ApiUtilDto.createdMessage(message));
            res.setActionMessage(message);
        }

        return res;
    }

    public ProductResponseDto findProduct(String id) {

        ProductResponseDto res = new ProductResponseDto();

        Optional<Product> productOpt = productRepository.findById(id);

        if (!productOpt.isPresent())
            throw new NotFoundException("No product can be found !");

        res.setApiMessage(ApiUtilDto.okMessage("Success"));
        res.setData(setProductToDto(productOpt.get()));

        return res;
    }

    public ProductDto setProductToDto(Product product) {

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setCustomizable(product.getCustomizable());
        productDto.setMediaId(product.getMediaId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setWeights(product.getWeights());
        productDto.setUnit(product.getUnit());
        productDto.setPcs(product.getPcs());

        Category category = product.getCategory();
        if(Util.isAllPresent(category)){
            productDto.setCategoryId(category.getId());
        }

        return productDto;
    }

    public ActionResponseDto deleteProduct(String id) {

        ActionResponseDto res = new ActionResponseDto();

        Optional<Product> productOpt = productRepository.findById(id);

        if (!productOpt.isPresent())
            throw new NotFoundException("No product can be found !");

        commonService.delete(productOpt.get());

        res.setApiMessage(ApiUtilDto.okMessage("Successfully deleted"));
        return res;
    }
}
