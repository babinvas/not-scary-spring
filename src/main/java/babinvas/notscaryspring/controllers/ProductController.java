package babinvas.notscaryspring.controllers;

import babinvas.notscaryspring.dto.ProductDto;
import babinvas.notscaryspring.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		final ProductDto product = productService.findByIdDto(1);

		return product != null
				? new ResponseEntity<>(product, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
