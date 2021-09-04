package babinvas.notscaryspring.services.mobilepayments;

import babinvas.notscaryspring.entities.mobilepayments.PhoneBalanceEntity;
import babinvas.notscaryspring.repositories.mobilepayments.PhoneBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhoneBalanceService {
	private final PhoneBalanceRepository phoneBalanceRepository;

	public List<PhoneBalanceEntity> findAll() {
		return phoneBalanceRepository.findAll();
	}

	public Optional<PhoneBalanceEntity> findById(Integer id) {
		return phoneBalanceRepository.findById(id);
	}

	public PhoneBalanceEntity findByNumberPhone(Integer numberPhone) {
		return phoneBalanceRepository.findByNumberPhone(numberPhone);
	}

	public List<PhoneBalanceEntity> findByNameCustomer(String nameCustomer) {
		return phoneBalanceRepository.findAllByNameCustomer(nameCustomer);
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
