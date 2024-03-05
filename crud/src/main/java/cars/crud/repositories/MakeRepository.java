package cars.crud.repositories;

import cars.crud.entities.MakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeRepository extends JpaRepository<MakeEntity, Long> {
}
