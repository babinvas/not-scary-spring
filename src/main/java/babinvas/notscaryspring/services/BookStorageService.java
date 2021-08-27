package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.BookStorageEntity;
import babinvas.notscaryspring.entities.BookStorageValueEntity;
import babinvas.notscaryspring.entities.BookStorageValueEntityAnnotation;
import babinvas.notscaryspring.entities.BookStorageValueEntityComparison;
import babinvas.notscaryspring.repositories.BookStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStorageService {

	private final BookStorageRepository bookStorageRepository;
	private final EntityManager entityManager;

	private final String SQL_COMPARISON = "select BOOKENTITY.id_book, BOOKENTITY.name_book, book_storage_entity.status " +
			"from BOOKENTITY join book_storage_entity on BOOKENTITY.id_book = book_storage_entity.book_id";

	private final String SQL_ANNOTATION = "select BOOKENTITY.id_book as id_book_value, BOOKENTITY.name_book, book_storage_entity.status " +
			"from BOOKENTITY join book_storage_entity on BOOKENTITY.id_book = book_storage_entity.book_id";

	public void saveAll(List<BookStorageEntity> storages) {
		bookStorageRepository.saveAll(storages);
	}

	public List<BookStorageEntity> findAll() {
		return bookStorageRepository.findAll();
	}

	public List<String> joinString() {
		return bookStorageRepository.joinString();
	}

	public List<String> joinSqlString() {
		return bookStorageRepository.joinSqlString();
	}

	public List<Object[]> joinBookStorageObj() {
		return bookStorageRepository.joinBookStorageObj();
	}

	public List<BookStorageValueEntity> bookStorageValueEntityList() {
		List<Object[]> objects = bookStorageRepository.joinBookStorageObj();

		List<BookStorageValueEntity> bookStorageValueEntities = new ArrayList<>();

		objects
				.stream()
				.forEach(
						(obj) ->
						{
							bookStorageValueEntities.add(
								new BookStorageValueEntity()
										.setNameBook((String) obj[0])
										.setStatus((String) obj[1])
							);
						}
				);

		return bookStorageValueEntities;
	}

	public List<BookStorageValueEntityComparison> bookStorageValueEntityComparisonList() {
		return entityManager
				.createNativeQuery(
						SQL_COMPARISON,
						BookStorageValueEntityComparison.class)
				.getResultList();
	}

	public List<BookStorageValueEntityAnnotation> bookStorageValueEntityAnnotationList() {
		return entityManager
				.createNativeQuery(
						SQL_ANNOTATION,
						"BookStorageValueMapping")
				.getResultList();
	}
}
