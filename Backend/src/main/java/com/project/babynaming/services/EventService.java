package com.project.babynaming.services;

import com.project.babynaming.entity.EventModel;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.babynaming.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public EventModel saveUser(EventModel event)
    {
        return eventRepository.save(event);
    }


    public List<EventModel> fetchByApplicantId(Long id) {
       
        return (List<EventModel>)eventRepository.findByuserId(id);
       
    }
    
    public EventModel fetchByEventId(Long id) {

        return eventRepository.findByeventid(id);
    }


    public void deleteById(Long id){
       EventModel event= eventRepository.findByeventid(id);
        eventRepository.delete(event);
    	
    }
    
    public EventModel editEventById(Long id, EventModel event) {
        EventModel newEvent = event;
        return eventRepository.save(newEvent);
    }

}

