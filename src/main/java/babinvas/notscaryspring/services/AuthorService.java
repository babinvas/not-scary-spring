package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.AuthorEntity;
import babinvas.notscaryspring.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

	private final AuthorRepository authorRepository;

	public void saveAll(List<AuthorEntity> books) {
		authorRepository.saveAll(books);
	}

	public List<AuthorEntity> findAll() {
		return authorRepository.findAll();
	}
}
