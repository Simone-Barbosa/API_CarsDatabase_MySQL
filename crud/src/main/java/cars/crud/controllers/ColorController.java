package cars.crud.controllers;

import cars.crud.entities.ColorEntity;
import cars.crud.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("color")
@CrossOrigin(origins = "http://localhost:4200")

public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping
    public List<ColorEntity> getAllColors(){
        return  colorService.searchAllColors();
    }

    @PostMapping
    public ResponseEntity addColor(@RequestBody ColorEntity color){
        if(color.getId() == null){
            colorService.saveOrChangeColor(color);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping
    public ResponseEntity changeColor(@RequestBody ColorEntity color){
        if(color.getId() != null){
            colorService.saveOrChangeColor(color);
            return ResponseEntity.status(200).build();
        } else{
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable Long id){
        colorService.deleteColor(id);
    }
}
