package babinvas.notscaryspring.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
