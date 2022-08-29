package com.project.babynaming.controller;

import static org.assertj.core.api.Java6Assertions.assertThat; 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.mockito.BDDMockito.willDoNothing;

import org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;


import com.project.babynaming.controller.EventController;
import com.project.babynaming.entity.EventModel;
import com.project.babynaming.repo.EventRepository;
import com.project.babynaming.services.EventService;



@RunWith(MockitoJUnitRunner.class)
class EventTest {

    private EventModel eventModel;
    @InjectMocks
    private EventService eventService;
    @Mock
    private EventRepository eventRepo;
    @InjectMocks
    private EventController eventController;
    @BeforeEach
    void setUp() {
        eventModel=eventModel.builder()
                .eventid(1L)
                .eventName("Abirthday")
                .applicantName("Yamini")
                .applicantAddress("chennai")
                .applicantMobileNo("9177802710")
                .applicantEmailId("yamini@gmail.com")
                .eventAddress("chennai")
                .eventDate("12-08-2022")
                .eventTime("12:30")
                .noOfPeople("100")
                .selectFoodCategory("veg")
                .quantityOfVeg("20")
                .quantityOfNonVeg("0")
                .userId(2)
                .themePrice(10000)
                .addOnPrice(3000)
                .build();
        MockitoAnnotations.initMocks(this);


    }
    @Test
    void bookTheme() throws Exception{
        when(eventRepo.findByeventid(eventModel.getEventid())).thenReturn(eventModel);
        when(eventRepo.save(eventModel)).thenReturn(eventModel);
        EventModel eventmodel1=eventService.saveUser(eventModel);
        assertThat(eventmodel1).isNotNull();

    }

    @Test
    void getBookedTheme() {
        when(eventRepo.findByeventid(eventModel.getUserid())).thenReturn(eventModel);
        EventModel eventmodel1=eventService.fetchByEventId(eventModel.getUserid());
        assertThat(eventmodel1).isNotNull();
    }
    @Test
    void viewBookedTheme() {
        when(eventRepo.findByuserId(eventModel.getUserid())).thenReturn(List.of(eventModel));
        List<EventModel> eventModelList=eventService.fetchByApplicantId(eventModel.getUserid());
        for(EventModel eventModel:eventModelList) {
            assertThat(eventModel).isNotNull();
        }
        assertThat(eventModelList.size()).isEqualTo(1);
    }
    @Test
    void deleteEvent() {
        willDoNothing().given(eventRepo).deleteById(eventModel.getEventid());
        eventService.deleteById(eventModel.getEventid());
        assertEquals(false,eventRepo.existsById(eventModel.getUserid()));
    }

}