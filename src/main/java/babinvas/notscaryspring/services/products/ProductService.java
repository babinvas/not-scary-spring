package babinvas.notscaryspring.services.products;

import babinvas.notscaryspring.dto.products.ProductDto;
import babinvas.notscaryspring.entities.products.ProductEntity;
import babinvas.notscaryspring.repositories.products.ProductRepository;
import babinvas.notscaryspring.utils.products.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;
	private final MappingUtil mappingUtil;

	// Это наша накрутка на цену
	private final Integer margin = 5;
	// Так будет выглядеть упаковка
	private final String packaging = "Упаковано в лучшем виде";

	public void saveAll(List<ProductEntity> productEntities) {
		productRepository.saveAll(productEntities);
	}

	public void save(ProductEntity productEntity) {
		productRepository.save(productEntity);
	}

	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}

	public Optional<ProductEntity> findById(Integer id) {
		return productRepository.findById(id);
	}

	public void deleteById(int id) {
		productRepository.deleteById(id);
	}

	public ProductDto findByIdDto(Integer id) {
		return mappingUtil.mapToProductDto(
				productRepository.findById(id)
						.orElse(new ProductEntity()) // Если ни чего не нашли, то возвращяем пустой entity
		);
	}

	public List<ProductDto> findAllDto() {
		return findAll()
				.stream() // Создали из листа стирим
				.map(mappingUtil::mapToProductDto) // Оператором из streamAPI map, использовали для каждого элемента метод mapToProductDto из класса MappingUtils
				.collect(Collectors.toList()); // Превратили стрим обратно в коллекцию, а точнее в лист
	}

	// Упаковываем товар
	public void pack(List<ProductDto> list) {
		list.forEach(
				productDto ->
						productDto.setPackaging(packaging)
		);
	}

	public void pack(ProductDto productDto) {
		productDto.setPackaging(packaging);
	}

	// Добавляем маржу
	public void addMargin(List<ProductDto> list) {
		list.forEach(
				productDto ->
						productDto.setSalePrice(productDto.getPurchasePrice() * margin)
		);
	}

	public void addMargin(ProductDto productDto) {
		productDto.setSalePrice(productDto.getPurchasePrice() * margin);
	}
}
