package babinvas.notscaryspring.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BookStorageValueEntityComparison {
	@Id
	@Column(name = "id_book")
	Integer id;

	@Column
	String nameBook;

	@Column
	String status;
}
