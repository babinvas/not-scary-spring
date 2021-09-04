package babinvas.notscaryspring.utils.mobilepayments;

import babinvas.notscaryspring.dto.mobilepayments.PhoneBalanceDto;
import babinvas.notscaryspring.entities.mobilepayments.PhoneBalanceEntity;
import org.springframework.stereotype.Service;

@Service
public class PhoneBalanceMappingUtil {
	public PhoneBalanceDto mapToPhoneBalanceDto(PhoneBalanceEntity entity) {
		PhoneBalanceDto dto = new PhoneBalanceDto();

		dto.setId(entity.getId());
		dto.setNameCustomer(entity.getNameCustomer());
		dto.setNumberPhone(entity.getNumberPhone());
		dto.setBalance(entity.getBalance());

		return dto;
	}

	public PhoneBalanceEntity mapToPhoneBalanceEntity(PhoneBalanceDto dto) {
		PhoneBalanceEntity entity = new PhoneBalanceEntity();

		entity.setId(dto.getId());
		entity.setNameCustomer(dto.getNameCustomer());
		entity.setNumberPhone(dto.getNumberPhone());
		entity.setBalance(dto.getBalance());

		return entity;
	}
}
