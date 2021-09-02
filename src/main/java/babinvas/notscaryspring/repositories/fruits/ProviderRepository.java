package babinvas.notscaryspring.repositories.fruits;

import babinvas.notscaryspring.entities.fruits.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity,Integer> {
}
