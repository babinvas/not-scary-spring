package babinvas.notscaryspring.repositories.fruits;

import babinvas.notscaryspring.entities.fruits.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Помечаем бин как репозиторий
@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
	// Репозиторий является интерфейсом, который наследуется от другого интерфейса JpaRepository<T, ID>
	// для него необходимо указать с какой сущность он должен работать, у нас это FruitEntity
	// и тип данных у поля id данной сущности, у нас это Integer

	@Query("select f.fruitName, p.providerName from FruitEntity f left join ProviderEntity p on f.providerCode = p.id")
	List<String> joinString();

	@Query("select f from FruitEntity f join ProviderEntity p on f.providerCode = p.id")
	List<FruitEntity> joinFruit();

	// Истользование SQL запрос.
	// Нужно только пометить nativeQuery = true
	@Query(
			value = "select fruit_table.fruit_name, provider_table.provider_name from fruit_table " +
					"join provider_table on fruit_table.provider_code = provider_table.id_provider",
			nativeQuery = true
	)
	List<String> joinSqlFruit();

	List<FruitEntity> findByProviderCodeBetween(Integer from, Integer to);
}
