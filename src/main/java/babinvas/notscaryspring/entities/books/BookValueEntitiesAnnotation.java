package babinvas.notscaryspring.entities.books;

import lombok.Data;

import javax.persistence.*;

@SqlResultSetMapping(
		name = "BookValueMapping", // Даём название нашему маппингу
		entities = @EntityResult(
				entityClass = BookValueEntitiesAnnotation.class, // Указываем конечный класс куда будем маппить
				fields = { // В блоке полей указываем соответствие полей (name =) конечного класса и полей (column =) результата запроса
						@FieldResult(name = "id", column = "id_book_value"),
						@FieldResult(name = "nameBook", column = "name_book"),
						@FieldResult(name = "firstNameAuthor", column = "first_name"),
						@FieldResult(name = "lastNameAuthor", column = "last_name"),
						@FieldResult(name = "yearCreat", column = "year_creat")
				}
		)
)

@Data
@Entity
@Table(name = "BookValueEntitiesAnnotation")
public class BookValueEntitiesAnnotation {
	@Id
	@Column
	Integer id;

	@Column
	String nameBook;

	@Column
	String firstNameAuthor;

	@Column
	String lastNameAuthor;

	@Column
	Integer yearCreat;
}
