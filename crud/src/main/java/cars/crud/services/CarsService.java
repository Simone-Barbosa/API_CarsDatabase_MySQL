package cars.crud.services;

import cars.crud.entities.CarsEntity;
import cars.crud.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    CarsRepository carsRepository;

    public List<CarsEntity> searchAllCars(){
        return carsRepository.findAll();
    }

    public void saveOrChangeCar(CarsEntity car){
        carsRepository.save(car);
    }

    public void deleteCar(Long id){
        carsRepository.deleteById(id);
    }

    public Optional<CarsEntity> searchCarByID(Long id){
        return carsRepository.findById(id);
    }

}
