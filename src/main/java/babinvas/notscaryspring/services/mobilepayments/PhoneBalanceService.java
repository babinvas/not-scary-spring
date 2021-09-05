package babinvas.notscaryspring.services.mobilepayments;

import babinvas.notscaryspring.dto.mobilepayments.PhoneBalanceDto;
import babinvas.notscaryspring.entities.mobilepayments.PhoneBalanceEntity;
import babinvas.notscaryspring.repositories.mobilepayments.PhoneBalanceRepository;
import babinvas.notscaryspring.utils.mobilepayments.PhoneBalanceMappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhoneBalanceService {
	private final PhoneBalanceRepository phoneBalanceRepository;
	private final PhoneBalanceMappingUtil mappingUtil;

	public List<PhoneBalanceEntity> findAll() {
		return phoneBalanceRepository.findAll();
	}

	public List<PhoneBalanceDto> findAllDto() {
		return phoneBalanceRepository.findAll()
				.stream()
				.map(mappingUtil::mapToPhoneBalanceDto)
				.collect(Collectors.toList());
	}

	public Optional<PhoneBalanceEntity> findById(Integer id) {
		return phoneBalanceRepository.findById(id);
	}

	public PhoneBalanceDto findDtoById(Integer id) {
		return mappingUtil.mapToPhoneBalanceDto(
				phoneBalanceRepository.findById(id)
						.orElse(new PhoneBalanceEntity())
		);
	}

	public PhoneBalanceEntity findByNumberPhone(Integer numberPhone) {
		return phoneBalanceRepository.findByNumberPhone(numberPhone);
	}

	public List<PhoneBalanceEntity> findByNameCustomer(String nameCustomer) {
		return phoneBalanceRepository.findAllByNameCustomer(nameCustomer);
	}

	public List<PhoneBalanceDto> findDtoByNameCustomer(String nameCustomer) {
		return phoneBalanceRepository.findAllByNameCustomer(nameCustomer)
				.stream()
				.map(mappingUtil::mapToPhoneBalanceDto)
				.collect(Collectors.toList());
	}

	public void saveAll(List<PhoneBalanceEntity> list) {
		phoneBalanceRepository.saveAll(list);
	}

	public void save(PhoneBalanceEntity entity) {
		phoneBalanceRepository.save(entity);
	}

	public void deleteById(Integer id) {
		phoneBalanceRepository.deleteById(id);
	}

	public void addingMoneyToBalance(Integer numberPhone, Integer sum) {

	}
}
