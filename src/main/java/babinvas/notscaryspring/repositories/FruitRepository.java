package babinvas.notscaryspring.repositories;

import babinvas.notscaryspring.entities.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Помечаем бин как репозиторий
@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
	// Репозиторий является интерфейсом, который наследуется от другого интерфейса JpaRepository<T, ID>
	// для него необходимо указать с какой сущность он должен работать, у нас это FruitEntity
	// и тип данных у поля id данной сущности, у нас это Integer
}
