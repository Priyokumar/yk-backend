package prilax.yk.controller.product;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import prilax.yk.dto.common.ActionResponseDto;
import prilax.yk.dto.product.*;
import prilax.yk.service.product.ProductService;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {

    final Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@GetMapping
	public ProductsResponseDto findProducts(
			@RequestParam(required = false) String categoryId
	) {
		return productService.findProducts(categoryId);
	}

	@PostMapping
	public ResponseEntity<ActionResponseDto> createProduct(@Valid @RequestBody ProductDto productDto) {
		ActionResponseDto response = productService.createOrUpdateProduct(productDto, null);
		ResponseEntity<ActionResponseDto> responseEntity = new ResponseEntity<ActionResponseDto>(response,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(value = "/{id}")
	public ProductResponseDto findProduct(@PathVariable("id") String id) {
		return productService.findProduct(id);
	}

	@PutMapping(value = "/{id}")
	public ActionResponseDto updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable("id") String id) {
		return productService.createOrUpdateProduct(productDto, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponseDto deleteProduct(@PathVariable("id") String id) {
		return productService.deleteProduct(id);
	}

}
