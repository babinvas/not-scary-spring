package babinvas.notscaryspring.utils;

import babinvas.notscaryspring.dto.ProductDto;
import babinvas.notscaryspring.entities.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingUtil {
	// Из entity в dto
	public ProductDto mapToProductDto(ProductEntity entity) {
		ProductDto dto = new ProductDto();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPurchasePrice(entity.getPurchasePrice());

		return dto;
	}

	// Из dto в entity
	public ProductEntity mapToProductEntity(ProductDto dto) {
		ProductEntity entity = new ProductEntity();

		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPurchasePrice(entity.getPurchasePrice());

		return entity;
	}
}
