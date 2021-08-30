package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.dto.ProductDto;
import babinvas.notscaryspring.entities.ProductEntity;
import babinvas.notscaryspring.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

		return productDto.getId() != null
				? new ResponseEntity<>(productDto, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> readProduct() {
		final List<ProductDto> productDtos = productService.findAllDto();

		return productDtos != null && !productDtos.isEmpty()
				? new ResponseEntity<>(productDtos, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
