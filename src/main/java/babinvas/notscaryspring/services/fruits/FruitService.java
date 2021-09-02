package babinvas.notscaryspring.services.fruits;

import babinvas.notscaryspring.entities.fruits.FruitEntity;
import babinvas.notscaryspring.repositories.fruits.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Ломбок аннотация
@RequiredArgsConstructor
// Помечаем бин как сервис
@Service
public class FruitService {
	// Final переменная репозитория
	private final FruitRepository fruitRepository;

	// Принимает сущность и сохраняет ее в базу
	public void save(FruitEntity fruitEntity) {
		// Реализовали метод внедренного бина
		fruitRepository.save(fruitEntity);
	}

	// Возвращает список всех сущностей из базы
	public List<FruitEntity> getAll() {
		// Реализовали метод внедренного бина
		return fruitRepository.findAll();
	}

	// Сохраняет список всех сущностей из списка в базу
	public void saveAll(List<FruitEntity> fruitEntities) {
		fruitRepository.saveAll(fruitEntities);
	}

	// Возвращает запись из таблицы по id
	public Optional<FruitEntity> getById(Integer id) {
		return fruitRepository.findById(id);
	}

	// Удаляет запись из таблицы по id
	public void delById(Integer id) {
		fruitRepository.deleteById(id);
	}

	// Возвращает true или false при поиске в таблице Фруктов объекта,
	// который соответствует типу FruitEntity
	// или принадлежит к типу объекта, который наследуется от FruitEntity
	public Boolean exist(Example<? extends FruitEntity> example) {
		return fruitRepository.exists(example);
	}

	public List<String> joinString() {
		return fruitRepository.joinString();
	}

	public List<FruitEntity> joinFruit() {
		return fruitRepository.joinFruit();
	}

	public List<String> joinSqlFruit() {
		return fruitRepository.joinSqlFruit();
	}

	public List<FruitEntity> findByProviderCodeBetween(Integer from, Integer to) {
		return fruitRepository.findByProviderCodeBetween(from, to);
	}
}
