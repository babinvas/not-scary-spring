package babinvas.notscaryspring.entities.fruits;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true)
@Entity
@Data
@Table(name ="provider_table")
public class ProviderEntity {
	@Id
	@Column(name = "id_provider")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private Integer id;

	@Column(name = "provider_name")
	private String providerName;
}
