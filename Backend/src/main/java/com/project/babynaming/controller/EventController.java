package com.project.babynaming.controller;

import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.services.EventService;
import com.project.babynaming.entity.EventModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class EventController {

    Logger log= LoggerFactory.getLogger(EventController.class);
    @Autowired
    private EventService eventService;

    @PostMapping("/user/bookTheme")
    public ResponseEntity<EventModel> userbookevent(@RequestBody EventModel user)
    {
            EventModel userObj = null;
            userObj = eventService.saveUser(user);
            if(userObj!=null) {
                log.info("Saved Successfully");
                return new ResponseEntity<EventModel>(userObj, HttpStatus.OK);
            }else
            {
                return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
            }

    }

    @GetMapping("/user/viewBookedTheme/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<EventModel>> getByEmail(@PathVariable Long id) throws ResourceNotFoundException
    {
        
        List<EventModel> EventList = eventService.fetchByApplicantId(id);
        return new ResponseEntity<List<EventModel>>(EventList, HttpStatus.OK);
    }

    @DeleteMapping("/user/deleteEvent/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EventModel> DeleteByEventId(@PathVariable Long id) throws ResourceNotFoundException
    {
        eventService.deleteById(id);
        log.info("Deleted Successfully");
        return new ResponseEntity<EventModel>(HttpStatus.OK);
    }


    @GetMapping("/user/getBookedTheme/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EventModel> getByEventId(@PathVariable Long id) throws ResourceNotFoundException
    {
        
        EventModel Event = eventService.fetchByEventId(id);
        return new ResponseEntity<EventModel>(Event, HttpStatus.OK);
    }


    @PutMapping("/user/UpdateBookedTheme/{id}")
    public ResponseEntity<EventModel> UpdateEvent(@RequestBody EventModel user) throws ResourceNotFoundException {
        EventModel event = eventService.editEventById(user.getEventid(),user);
       
        return new ResponseEntity<EventModel>(event,HttpStatus.OK);
    }
}



