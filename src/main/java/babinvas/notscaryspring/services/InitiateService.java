package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.FruitEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitiateService implements CommandLineRunner {
	// Имплементируем интерфейс CommandLineRunner (командная строка запуска)

	private final FruitService fruitService;

	public InitiateService(FruitService fruitService) {
		this.fruitService = fruitService;
	}

	// Переопределяем метод который позволит
	// нам выполнять методы нашего приложения при запуске
	@Override
	public void run(String ... args) throws Exception {
		FruitEntity fruitEntity1 = new FruitEntity();
		fruitEntity1.setFruitName("fruit1");
		fruitEntity1.setProviderCode(1);

		FruitEntity fruitEntity2 = new FruitEntity();
		fruitEntity2.setFruitName("fruit2");
		fruitEntity2.setProviderCode(2);

		FruitEntity fruitEntity3 = new FruitEntity();
		fruitEntity3.setFruitName("fruit3");
		fruitEntity3.setProviderCode(3);

		// Сохраняем в базу, по разу для одного объекта
		fruitService.save(fruitEntity1);
		fruitService.save(fruitEntity2);
		fruitService.save(fruitEntity3);

		// Получаем базу
		List<FruitEntity> fruitEntityList = fruitService.getAll();

		for (FruitEntity entity : fruitEntityList) {
			System.out.println(entity);
		}

		FruitEntity fruitEntity4 = new FruitEntity();
		fruitEntity4.setFruitName("fruit4");
		fruitEntity4.setProviderCode(4);

		FruitEntity fruitEntity5 = new FruitEntity();
		fruitEntity5.setFruitName("fruit5");
		fruitEntity5.setProviderCode(5);

		List<FruitEntity> listForSaving = new ArrayList<>();
		listForSaving.add(fruitEntity4);
		listForSaving.add(fruitEntity5);

		fruitService.saveAll(listForSaving);

		fruitEntityList = fruitService.getAll();

		System.out.println();

		for (FruitEntity entity : fruitEntityList) {
			System.out.println(entity);
		}
	}
}
