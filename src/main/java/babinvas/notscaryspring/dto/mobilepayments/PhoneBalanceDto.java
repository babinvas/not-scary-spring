package babinvas.notscaryspring.dto.mobilepayments;

import lombok.Data;

@Data
public class PhoneBalanceDto {
	Integer id;

	Integer numberPhone;
	String nameCustomer;
	Integer balance;
}
