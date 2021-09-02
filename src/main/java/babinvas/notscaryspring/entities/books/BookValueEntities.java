package babinvas.notscaryspring.entities.books;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Accessors(chain = true)
@Entity
@Data
public class BookValueEntities {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	Integer id;

	String nameBook;
	String firstNameAuthor;
	String lastNameAuthor;
	Integer yearCreat;
}
