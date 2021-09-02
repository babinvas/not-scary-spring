package babinvas.notscaryspring.entities.books;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BookValueEntitiesComparison {

	@Id
	@Column(name = "id_book")
	Integer id;

	// Поле и так называется как в запросе, потому что Hibernate сгенерирует для него имя сам (name_book)
	@Column
	String nameBook;

	@Column(name = "first_name")
	String firstNameAuthor;

	@Column(name = "last_name")
	String lastNameAuthor;

	// Поле и так называется как в запросе, потому что Hibernate сгенерирует для него имя сам (name_book)
	@Column
	String yearCreat;
}
