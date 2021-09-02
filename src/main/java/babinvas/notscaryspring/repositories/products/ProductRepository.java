package babinvas.notscaryspring.repositories.products;

import babinvas.notscaryspring.entities.products.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
