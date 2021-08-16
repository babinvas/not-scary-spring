package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.BookEntity;
import babinvas.notscaryspring.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
