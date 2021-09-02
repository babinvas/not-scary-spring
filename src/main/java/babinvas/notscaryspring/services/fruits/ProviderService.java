package babinvas.notscaryspring.services.fruits;

import babinvas.notscaryspring.entities.fruits.ProviderEntity;
import babinvas.notscaryspring.repositories.fruits.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderService {
	private final ProviderRepository providerRepository;

	public void save(ProviderEntity providerEntity) {
		providerRepository.save(providerEntity);
	}

	public List<ProviderEntity> getAll() {
		return providerRepository.findAll();
	}

	public void saveAll(List<ProviderEntity> providerEntity) {
		providerRepository.saveAll(providerEntity);
	}

	public Optional<ProviderEntity> getById(Integer id) {
		return providerRepository.findById(id);
	}

	public void delById(Integer id) {
		providerRepository.deleteById(id);
	}

	public Boolean exist(Example<? extends ProviderEntity> example) {
		return providerRepository.exists(example);
	}
}
