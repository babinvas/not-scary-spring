package babinvas.notscaryspring.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// Ломбок аннотация
@Data
// Помечаем бин как сущность
@Entity
// В этой аннотации можно указать имя создаваемой таблицы
@Table(name = "fruit_table")
public class FruitEntity {

	// Помечаем поле как id
	@Id
	// В этой аннотации можно указать имя поля
	@Column(name = "id_fruit")
    // hibernate, аннотация указывает, что id будет автоматически увеличиваться
	// при новых записях
	@GenericGenerator(name = "generator", strategy = "increment")
	//Аннотация генерации id
	@GeneratedValue(generator = "generator")
	private Integer id;

	@Column(name = "fruit_name")
	private String fruitName;

	@Column(name = "provider_code")
	private Integer providerCode;
}
