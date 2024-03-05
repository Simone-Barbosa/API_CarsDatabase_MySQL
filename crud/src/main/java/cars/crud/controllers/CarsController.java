package cars.crud.controllers;

import cars.crud.entities.CarsEntity;
import cars.crud.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarsController {


    @Autowired
    CarsService carsService;

    @GetMapping
    public List<CarsEntity> getAllCars(){
        return carsService.searchAllCars();
    }

    @GetMapping("/{id}")
    public Optional<CarsEntity> getCarByID(@PathVariable Long id){
        return carsService.searchCarByID(id);
    }

    @PostMapping
    public ResponseEntity addCar(@RequestBody CarsEntity car){
        if(car.getId() == null){
            carsService.saveOrChangeCar(car);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping
    public ResponseEntity changeCar(@RequestBody CarsEntity car){
        if(car.getId() != null){
            carsService.saveOrChangeCar(car);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id){
        carsService.deleteCar(id);
    }
}
