package babinvas.notscaryspring.entities.products;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Accessors(chain = true)
@Data
@Entity
public class ProductEntity {
	@Id
	@Column
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	Integer id;

	@Column
	String name;

	@Column
	Integer purchasePrice;
}
