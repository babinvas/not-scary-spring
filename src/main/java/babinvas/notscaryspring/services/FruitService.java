package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.FruitEntity;
import babinvas.notscaryspring.repositories.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

	public void saveAll(List<FruitEntity> fruitEntities) {
		fruitRepository.saveAll(fruitEntities);
	}
}
