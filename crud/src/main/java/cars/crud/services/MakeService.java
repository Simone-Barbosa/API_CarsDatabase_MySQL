package cars.crud.services;

import cars.crud.entities.MakeEntity;
import cars.crud.repositories.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeService {

    @Autowired
    MakeRepository makeRepository;

    public List<MakeEntity> searchAllMakes(){
        return makeRepository.findAll();
    }

    public void saveOrChangeMake(MakeEntity marca){
        makeRepository.save(marca);
    }

    public void deleteMake(Long id){
        makeRepository.deleteById(id);
    }

}
