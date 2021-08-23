package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.BookStorageEntity;
import babinvas.notscaryspring.entities.BookStorageValueEntity;
import babinvas.notscaryspring.repositories.BookStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStorageService {

	private final BookStorageRepository bookStorageRepository;

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

	List<Object[]> joinBookStorageObj() {
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
}
