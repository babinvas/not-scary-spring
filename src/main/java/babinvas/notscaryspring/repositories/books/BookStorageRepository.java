package babinvas.notscaryspring.repositories.books;

import babinvas.notscaryspring.entities.books.BookStorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStorageRepository extends JpaRepository<BookStorageEntity, Integer> {
	@Query("select b.nameBook, ' '||s.status from BookEntity b left join BookStorageEntity s on b.id = s.bookId")
	List<String> joinString();

	@Query(
			value ="select BOOKENTITY.name_book, ' '||book_storage_entity.status " +
					"from BOOKENTITY join book_storage_entity on BOOKENTITY.id_book = book_storage_entity.book_id",
			nativeQuery = true)
	List<String> joinSqlString();

	@Query("select b.nameBook, s.status from BookEntity b left join BookStorageEntity s on b.id = s.bookId")
	List<Object[]> joinBookStorageObj();
}
