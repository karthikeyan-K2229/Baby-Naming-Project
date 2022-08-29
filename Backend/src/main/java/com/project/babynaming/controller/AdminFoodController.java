package com.project.babynaming.controller;

import com.project.babynaming.dto.AdminfoodDto;
import com.project.babynaming.entity.AddOn;
import com.project.babynaming.entity.Adminfood;
import com.project.babynaming.entity.ThemeModel;
import com.project.babynaming.services.Adminfoodservice;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.Adminfoodrepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200/")

public class AdminFoodController {
    Logger log= LoggerFactory.getLogger(AdminFoodController.class);


    @Autowired
    private Adminfoodservice adminservice;
    @Autowired

   private Adminfoodrepository adminrepo;
    @PostMapping("/admin/addfood")
    public ResponseEntity<Adminfood> userbookevent(@RequestBody Adminfood food)
    {
        try {
            Adminfood userObj = null;
            String currentfood = food.getFoodname();
                Adminfood userfooD=adminservice.findByFoodname(currentfood);
                if(userfooD!=null)
                {
                    throw new Exception(" alreay exist");
                }
            userObj = adminservice.saveUser(food);
                log.info("Saved Successfully");
            return new ResponseEntity<Adminfood>(userObj, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/admin/getfood")
    public ResponseEntity<List<Adminfood>> getAllUsers()throws ResourceNotFoundException{
    	List<Adminfood> food= adminservice.getAllFood();
        return new ResponseEntity<List<Adminfood>>(food, HttpStatus.OK);
    }
    
    @DeleteMapping("/admin/deletefood/{id}")
    public ResponseEntity<Adminfood> deleteUser(@PathVariable Long id){
        adminservice.deleteFoodById(id);
        log.info("Deleted Successfully");
        return new ResponseEntity<Adminfood>(HttpStatus.OK);
    }
    @GetMapping("/admin/getfoodbyid/{id}")
        public ResponseEntity<Optional<Object>> getUserById(@PathVariable Long id) {
            Optional<Object> user = adminservice.fetchById(id);
            return ResponseEntity.ok(user);

    }
    
    @PutMapping("/admin/updatefood/{id}")
    public ResponseEntity<Adminfood> updateUser(@PathVariable Long id, @RequestBody Adminfood userDetails) throws ResourceNotFoundException {

        adminservice.updateFood(id,userDetails);
        log.info("Updated Successfully");
        return new ResponseEntity<Adminfood>(HttpStatus.OK);
    }
}
