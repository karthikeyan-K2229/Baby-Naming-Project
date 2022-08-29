package com.project.babynaming.services;



import java.util.List;
import java.util.Optional;

import com.project.babynaming.entity.AddOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.babynaming.repo.AddOnRepository;
import org.springframework.web.client.ResourceAccessException;


@Service
public class AddOnService {
   final private static org.apache.log4j.Logger log=org.apache.log4j.LogManager.getLogger(AddOnService.class);
    @Autowired
    AddOnRepository repository;

    public AddOn saveFood(AddOn food) throws Exception {

        return repository.save(food);
    }



    public Optional<AddOn> getFoodById(long id) {
        return repository.findById(id);
    }

    public boolean checkExistedFood(long id) {
        if(repository.existsById((long) id)) {
            return true;
        }
        return false;
    }

    public AddOn updateFood(AddOn food,long id){
        AddOn addon = repository.findById(id).orElseThrow(() -> new ResourceAccessException("Addon not exist with id :" + id));
        addon.setName(food.getName());
        addon.setPrice(food.getPrice());
        addon.setImage(food.getImage());
        return repository.save(addon);
    }

    public void deleteFoodById(long id) {
        repository.deleteById(id);
    }


    public List<AddOn> findAllAddOn() {
        return repository.findAll();
    }

    public Optional<Object> fetchById(Long id) {
        AddOn food = repository.findById(id).orElseThrow(() -> new ResourceAccessException("Addon not exist with id :" + id));
        return Optional.ofNullable(food);
    }


    public AddOn findByName(String currentfood) {
        AddOn addon=repository.findByName(currentfood);
        return  addon;
    }
}