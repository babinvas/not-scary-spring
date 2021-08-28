package babinvas.notscaryspring.dto;

import lombok.Data;

@Data
public class ProductDto {
	Integer id;

	String name;
	Integer purchasePrice;

	// Упаковка
	String  packaging;
	// Цена реализации
	Integer salePrice;
}
