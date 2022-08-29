package com.project.babynaming.services;

import com.project.babynaming.dto.AdminfoodDto;
import com.project.babynaming.entity.AddOn;
import com.project.babynaming.entity.Adminfood;
import com.project.babynaming.entity.ThemeModel;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.Adminfoodrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Adminfoodservice {
    private  static final  String NOTFOUND="Theme does not exist with id";
    @Autowired
    Adminfoodrepository adminrepo;

    public Adminfood saveUser(Adminfood food)
    {
        return adminrepo.save(food);

    }


    public Adminfood savefood(Adminfood user) {

        return adminrepo.save(user);
    }

    public Adminfood findByFoodname(String currentfood) {
        Adminfood model= adminrepo.findByFoodname(currentfood);
        return model;
    }

    public List<Adminfood> getAllFood() {
        return  (List<Adminfood>)adminrepo.findAll();
    }

    public void deleteFoodById(Long id) {
        adminrepo.deleteById(id);
    }

    public Adminfood updateFood(Long id, Adminfood userDetails) {
        Adminfood user=adminrepo.findById(id).orElseThrow(()->new ResourceNotFoundException(NOTFOUND +id ));
        user.setFoodname(userDetails.getFoodname());
        user.setImageurl(userDetails.getImageurl());
        user.setCategory(userDetails.getCategory());
        user.setPrice(userDetails.getPrice());
       return adminrepo.save(user);

    }

    public Optional<Object> fetchById(Long id) {
        Adminfood user=adminrepo.findById(id).orElseThrow(()->new ResourceNotFoundException(NOTFOUND +id ));
        return Optional.ofNullable(user);
    }
}
