package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.ProductEntity;
import babinvas.notscaryspring.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public void saveAll(List<ProductEntity> productEntities) {
		productRepository.saveAll(productEntities);
	}

	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}
}
