package babinvas.notscaryspring.entities.mobilepayments;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "balance_phone")
public class PhoneBalanceEntity {
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	Integer id;

	@Column(name = "number_phone")
	Integer numberPhone;

	@Column(name = "name_customer")
	String nameCustomer;

	@Column
	Integer balance;
}
