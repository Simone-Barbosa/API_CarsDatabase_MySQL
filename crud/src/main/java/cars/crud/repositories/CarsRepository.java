package cars.crud.repositories;

import cars.crud.entities.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<CarsEntity, Long> {
}
