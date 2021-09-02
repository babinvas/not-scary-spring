package babinvas.notscaryspring.services.books;

import babinvas.notscaryspring.entities.books.AuthorEntity;
import babinvas.notscaryspring.repositories.books.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

	private final AuthorRepository authorRepository;

	public void saveAll(List<AuthorEntity> author) {
		authorRepository.saveAll(author);
	}

	public List<AuthorEntity> findAll() {
		return authorRepository.findAll();
	}
}
