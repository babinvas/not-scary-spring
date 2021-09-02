package babinvas.notscaryspring.repositories.books;

import babinvas.notscaryspring.entities.books.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
