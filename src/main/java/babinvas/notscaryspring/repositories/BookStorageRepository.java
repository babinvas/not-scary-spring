package babinvas.notscaryspring.repositories;

import babinvas.notscaryspring.entities.BookStorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStorageRepository extends JpaRepository<BookStorageEntity, Integer> {
}
