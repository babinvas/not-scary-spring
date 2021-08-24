package babinvas.notscaryspring.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "BookStorageEntity")
public class BookStorageEntity {

	@Id
	@Column
	Integer id;

	@Column
	Integer bookId;

	// Книга выдана или нет
	@Column
	String status;
}
