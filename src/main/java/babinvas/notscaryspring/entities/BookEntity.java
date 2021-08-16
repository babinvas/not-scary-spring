package babinvas.notscaryspring.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true)
@Entity
@Table(name = "BOOKENTITY")
@Data
public class BookEntity {

	@Id
	@Column(name = "id_book")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	Integer id;

	@Column(name = "name_book")
	String nameBook;

	@Column(name = "year_creat")
	Integer yearCreat;

	@Column(name = "author_id")
	Integer authorId;
}
