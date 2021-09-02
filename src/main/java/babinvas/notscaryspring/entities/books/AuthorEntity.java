package babinvas.notscaryspring.entities.books;


import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true)
@Entity
@Table(name = "AUTHORENTITY")
@Data
public class AuthorEntity {

	@Id
	@Column(name = "id_author")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	Integer id;

	@Column(name = "first_name")
	String firstNameAuthor;

	@Column(name = "last_name")
	String lastNameAuthor;
}
