package com.project.babynaming.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.project.babynaming.entity.AddOn;
import com.project.babynaming.entity.EventModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;


import com.project.babynaming.entity.Message;
import com.project.babynaming.services.AddOnService;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.AddOnRepository;



@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AddOnController {
    Logger log= LoggerFactory.getLogger(AddOnController.class);

    @Autowired
    AddOnService foodServices;
    @Autowired
    private AddOnRepository foodRepository;
    @PostMapping("/addAddon")
    public ResponseEntity<Message> addNewFood(@RequestBody AddOn food) {
        try {
            String currentfood = food.getName();
            AddOn userfood=foodServices.findByName(currentfood);
            if(userfood!=null)
            {
                throw new Exception("Add_on alreay exist");
            }
            AddOn returnedFood = foodServices.saveFood(food);
             log.info("Saved Successfully");
            return new ResponseEntity<Message>(new Message("Upload Successfully!",
                    Arrays.asList(returnedFood), ""), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<Message>(new Message("Fail to post a new addon!",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getAddon")
    @ResponseBody
    public List<AddOn> getAllEmployees(){
        return foodServices.findAllAddOn();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Object>> getEmployeeById(@PathVariable Long id) {
        Optional<Object> food = foodServices.fetchById(id);
        return ResponseEntity.ok(food);
    }


    @DeleteMapping("/deleteAddon/{id}")
    public ResponseEntity<AddOn> deleteAddon(@PathVariable long id)throws ResourceNotFoundException
    {
        foodServices.deleteFoodById(id);
        log.info("Deleted Successfully");
        return new ResponseEntity<AddOn>(HttpStatus.OK);
    }



    @PutMapping("/editAddon/{id}")
    public ResponseEntity<AddOn> updateCustomerById(@RequestBody AddOn food,
                                                      @PathVariable long id) {
       foodServices.updateFood(food,id);
       log.info("Updated Successfully");
       return new ResponseEntity<AddOn>(HttpStatus.OK);
    }



}
