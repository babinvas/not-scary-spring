package babinvas.notscaryspring.entities.books;

import lombok.Data;

import javax.persistence.*;

@SqlResultSetMapping(
		name = "BookStorageValueMapping",
		entities = @EntityResult(
				entityClass = BookStorageValueEntityAnnotation.class,
				fields = {
						@FieldResult(name = "id", column = "id_book_value"),
						@FieldResult(name = "nameBook", column = "name_book"),
						@FieldResult(name = "status", column = "status")
				}
		)
)

@Data
@Entity
@Table(name = "BookStorageValueEntityAnnotation")
public class BookStorageValueEntityAnnotation {
	@Id
	@Column(name = "id_book")
	Integer id;

	@Column
	String nameBook;

	@Column
	String status;
}
