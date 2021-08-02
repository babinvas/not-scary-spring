package babinvas.notscaryspring.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

	public FruitEntity() {
	}

	public Integer getId() {
		return id;
	}

	public String getFruitName() {
		return fruitName;
	}

	public FruitEntity setFruitName(String fruitName) {
		this.fruitName = fruitName;
		return this;
	}

	public Integer getProviderCode() {
		return providerCode;
	}

	public FruitEntity setProviderCode(Integer providerCode) {
		this.providerCode = providerCode;
		return this;
	}

	@Override
	public String toString() {
		return "FruitEntity{" +
				"id=" + id +
				", fruitName='" + fruitName + "'" +
				", providerCode=" + providerCode +
				"}";
	}
}
