package cars.crud.controllers;

import cars.crud.entities.MakeEntity;
import cars.crud.services.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("make")
@CrossOrigin(origins = "http://localhost:4200")
public class MakeController {

    @Autowired
    MakeService makeService;

    @GetMapping
    public List<MakeEntity> getAllMakes(){
        return  makeService.searchAllMakes();
    }

    @PostMapping
    public ResponseEntity addMake(@RequestBody MakeEntity make){
        if(make.getId() == null){
            makeService.saveOrChangeMake(make);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping
    public ResponseEntity changeMake(@RequestBody MakeEntity make){
        if(make.getId() != null){
            makeService.saveOrChangeMake(make);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMake(@PathVariable Long id){
        makeService.deleteMake(id);
    }
}
