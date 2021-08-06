package babinvas.notscaryspring.services;

import babinvas.notscaryspring.entities.ProviderEntity;
import babinvas.notscaryspring.repositories.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
