package babinvas.notscaryspring.repositories.mobilepayment;

import babinvas.notscaryspring.entities.mobilepayment.PhoneBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneBalanceRepository extends JpaRepository<PhoneBalanceEntity, Integer> {

	PhoneBalanceEntity findByNumberPhone(Integer numberPhone);

	List<PhoneBalanceEntity> findAllByNameCustomer(String nameCustomer);
}
