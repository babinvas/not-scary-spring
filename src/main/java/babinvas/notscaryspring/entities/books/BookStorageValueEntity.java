package babinvas.notscaryspring.entities.books;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Accessors(chain = true)
@Data
@Entity
public class BookStorageValueEntity {

	@Id
	Integer id;

	String nameBook;

	String status;
}
