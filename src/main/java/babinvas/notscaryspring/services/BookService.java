package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.BookEntity;
import babinvas.notscaryspring.entities.BookValueEntities;
import babinvas.notscaryspring.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;

	public void saveAll(List<BookEntity> books) {
		bookRepository.saveAll(books);
	}

	public List<BookEntity> findAll() {
		return bookRepository.findAll();
	}

	public List<String> joinBookString() {
		return bookRepository.joinBookString();
	}

	public List<Object[]> joinBookObj() {
		return bookRepository.joinBookObj();
	}

	public List<BookValueEntities> bookValueEntitiesList() {
		// Положим ответ от БД в переменную с типом Лист массивов Object-ов
		List<Object[]> objects = bookRepository.joinBookObj();

		// Создадим лист конечных объектов
		List<BookValueEntities> bookValueEntities = new ArrayList<>();

		// Берем переменную типа List<Object[]> (Лист массивов Object-ов), с ответом БД
		objects
				.stream() // Превращаем Лист, состоящий из массивов Object-ов в стрим
				.forEach( // Терминальный оператор, выполняет указанное действие для каждого элемента стрима
						// Дальше идет лямбда, она говорит фор ичу - что делать для каждого элемента стрима
						(obj) -> //Объявляем (называем) переменную "obj" ей будут присваиваться объекты стрима (массивы Object-ов)
						{
							bookValueEntities.add( // Фор ич возмет "obj" и добавит в List<BookValue>, предварительно сделав маппинг
									new BookValueEntities() // Создаем объект BookValueEntities
											// Ниже происходит собственно маппинг
											// Поля(элементы) "obj" записываются в соответсвующие поля созданного BookValueEntities
											// Так как поле "obj" имеет тип Object необходимо его привести к типу поля объекта BookValueEntities, т.е. String
											.setNameBook((String) obj[0]) // Записываем данные из одного поля в другое, [0] - значит первый элемент в массиве Object-ов
											.setFirstNameAuthor((String) obj[1])
											.setLastNameAuthor((String) obj[2])
											.setYearCreat((Integer) obj[3])
							);
						}
				);

		return bookValueEntities;
	}
}
