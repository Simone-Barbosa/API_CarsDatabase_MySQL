package cars.crud.services;

import cars.crud.entities.ColorEntity;
import cars.crud.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    ColorRepository colorRepository;

    public List<ColorEntity> searchAllColors(){
        return colorRepository.findAll();
    }

    public void saveOrChangeColor(ColorEntity color){
        colorRepository.save(color);
    }

    public void deleteColor(Long id){
        colorRepository.deleteById(id);
    }

}
