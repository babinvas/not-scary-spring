package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.BookStorageEntity;
import babinvas.notscaryspring.repositories.BookStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
