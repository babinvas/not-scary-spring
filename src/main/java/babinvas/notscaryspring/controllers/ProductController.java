package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.dto.ProductDto;
import babinvas.notscaryspring.entities.ProductEntity;
import babinvas.notscaryspring.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speculation")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping("/simple")
	public String simple() {
		return "Легкий GET запросик";
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> readProduct(@PathVariable(name = "id") int id) {
		final ProductDto productDto = productService.findByIdDto(id);

		if (productDto.getId() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		productService.pack(productDto);
		productService.addMargin(productDto);

		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> readProduct() {
		final List<ProductDto> productDtos = productService.findAllDto();

		if (productDtos == null || productDtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		productService.pack(productDtos);
		productService.addMargin(productDtos);

		return new ResponseEntity<>(productDtos, HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<?> createProduct(@RequestBody ProductEntity productEntity) {
		productService.save(productEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") int id, @RequestBody ProductEntity product) {
		Optional<ProductEntity> optionalProductEntity = productService.findById(id);

		if (!optionalProductEntity.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		ProductEntity productEntity = optionalProductEntity.get();

		if (product.getName() != null) {
			productEntity.setName(product.getName());
		}

		if (product.getPurchasePrice() != null) {
			productEntity.setPurchasePrice(product.getPurchasePrice());
		}

		productService.save(productEntity);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") int id) {
		Optional<ProductEntity> optionalProductEntity = productService.findById(id);

		if (!optionalProductEntity.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		productService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
