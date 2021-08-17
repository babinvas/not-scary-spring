package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.AuthorEntity;
import babinvas.notscaryspring.entities.BookEntity;
import babinvas.notscaryspring.entities.FruitEntity;
import babinvas.notscaryspring.entities.ProviderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
// Ломбок аннотация
@RequiredArgsConstructor
public class InitiateService implements CommandLineRunner {
	// Имплементируем интерфейс CommandLineRunner (командная строка запуска)

	private final FruitService fruitService;
	private final ProviderService providerService;

	private final BookService bookService;
	private final AuthorService authorService;

	// Переопределяем метод который позволит
	// нам выполнять методы нашего приложения при запуске
	@Override
	public void run(String ... args) throws Exception {

		showWorkWithFruitAndProviders();

		List<BookEntity> bookEntityList = new ArrayList<>(
				Arrays.asList(
						new BookEntity()
								.setNameBook("Горе от ума")
								.setYearCreat(1824)
								.setAuthorId(1),
						new BookEntity()
								.setNameBook("Война и мир")
								.setYearCreat(1863)
								.setAuthorId(2),
						new BookEntity()
								.setNameBook("Мцыри")
								.setYearCreat(1838)
								.setAuthorId(3),
						new BookEntity()
								.setNameBook("Евгений Онегин")
								.setYearCreat(1833)
								.setAuthorId(4)
				)
		);

		List<AuthorEntity> authorEntityList = new ArrayList<>(
				Arrays.asList(
						new AuthorEntity()
								.setFirstNameAuthor("Александр")
								.setLastNameAuthor("Грибоедов"),
						new AuthorEntity()
								.setFirstNameAuthor("Лев")
								.setLastNameAuthor("Толстой"),
						new AuthorEntity()
								.setFirstNameAuthor("Михаил")
								.setLastNameAuthor("Лермонтов"),
						new AuthorEntity()
								.setFirstNameAuthor("Александр")
								.setLastNameAuthor("Пушкин")
				));

		bookService.saveAll(bookEntityList);
		authorService.saveAll(authorEntityList);

		System.out.println("\nТаблица книг");
		for(BookEntity book: bookService.findAll()){
			System.out.println(book);
		}

		System.out.println("\nТаблица авторов");
		for(AuthorEntity author : authorService.findAll()){
			System.out.println(author);
		}
	}

	private void showWorkWithFruitAndProviders() {
		// Инициализируем таблицу с фруктами
		List<FruitEntity> fruit = new ArrayList<>(      // Создаем обычный ArrayList
				Arrays.asList(                          // Создаем обертку, которая превращает список объектов FruitEntity в List
						new FruitEntity()               // Создаем экземпляр класса FruitEntity
								.setFruitName("Fruit1") // Через сеттеры заполняем поля сущности
								.setProviderCode(
										Math.abs(new Random().nextInt() % 10) // Добавлен метод случайного числа от 0 до 10
								),
						new FruitEntity()
								.setFruitName("Fruit2")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit3")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit4")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit5")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit6")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit7")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit8")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit9")
								.setProviderCode(Math.abs(new Random().nextInt() % 10)),
						new FruitEntity()
								.setFruitName("Fruit10")
								.setProviderCode(Math.abs(new Random().nextInt() % 10))
				)
		);

		// Инициализируем таблицу с поставщиками
		List<ProviderEntity> providers = new ArrayList<>(
				Arrays.asList(
						new ProviderEntity()
								.setProviderName("Provider1"),
						new ProviderEntity()
								.setProviderName("Provider2"),
						new ProviderEntity()
								.setProviderName("Provider3"),
						new ProviderEntity()
								.setProviderName("Provider4"),
						new ProviderEntity()
								.setProviderName("Provider5")
				)
		);

		// Сохраняем List фруктов в базу данных
		fruitService.saveAll(fruit);

		System.out.println("\nТаблица фруктов");
		for (FruitEntity fruitEntity : fruitService.getAll()) {
			System.out.println(fruitEntity);
		}

		// Сохраняем List поставщиков в базу данных
		providerService.saveAll(providers);

		System.out.println("\nТаблица поставщиков");
		for (ProviderEntity providerEntity : providerService.getAll()) {
			System.out.println(providerEntity);
		}

		// Получаем фрукт и поставщика из базы данных по id
		Optional<FruitEntity> optionalFruitEntity = fruitService.getById(3);
		Optional<ProviderEntity> optionalProviderEntity = providerService.getById(4);
		FruitEntity fruitEntity = optionalFruitEntity.get();
		ProviderEntity providerEntity = optionalProviderEntity.get();

		System.out.println("\n" + fruitEntity);
		System.out.println(providerEntity);

		// Проверяем существует ли фрукт и поставщик в базе данных
		Example<FruitEntity> fruitEntityExample = Example.of(fruitEntity);
		Example<ProviderEntity> providerEntityExample = Example.of(providerEntity);

		System.out.println("\n" + fruitService.exist(fruitEntityExample));
		System.out.println(providerService.exist(providerEntityExample));

		// Удаляем фрукт и поставщика из базы данных по id
		fruitService.delById(3);
		providerService.delById(4);

		System.out.println("\n" + fruitService.exist(fruitEntityExample));
		System.out.println(providerService.exist(providerEntityExample));

		System.out.println("\nТаблица фруктов и их поставщиков");
		for (String join : fruitService.joinString()) {
			System.out.println(join);
		}

		System.out.println("\nТаблица фруктов и их поставщиков");
		for (FruitEntity join : fruitService.joinFruit()) {
			System.out.println(join);
		}

		System.out.println("\nТаблица фруктов и их поставщиков");
		for (String join : fruitService.joinSqlFruit()) {
			System.out.println(join);
		}

		System.out.println("\nТаблица фруктов и их поставщиков по id поставщему (промежуток)");
		for (FruitEntity join : fruitService.findByProviderCodeBetween(2, 5)) {
			System.out.println(join);
		}
	}
}
