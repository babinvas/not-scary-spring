package babinvas.notscaryspring.repositories.books;

import babinvas.notscaryspring.entities.books.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	@Query("select b.nameBook, a.firstNameAuthor, a.lastNameAuthor, b.yearCreat " +
			"from AuthorEntity a left join BookEntity b on a.id = b.authorId")
	List<String> joinBookString();

	@Query("select b.nameBook, a.firstNameAuthor, a.lastNameAuthor, b.yearCreat " +
			"from  AuthorEntity a left join BookEntity b on a.id = b.authorId")
	List<Object[]> joinBookObj();
}
