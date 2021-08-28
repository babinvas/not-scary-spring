package babinvas.notscaryspring.services;

import babinvas.notscaryspring.dto.ProductDto;
import babinvas.notscaryspring.entities.ProductEntity;
import babinvas.notscaryspring.repositories.ProductRepository;
import babinvas.notscaryspring.utils.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}

	public ProductDto findById(Integer id) {
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

	// Добавляем маржу
	public void addMargin(List<ProductDto> list) {
		list.forEach(
				productDto ->
						productDto.setSalePrice(productDto.getPurchasePrice() * margin)
		);
	}
}
