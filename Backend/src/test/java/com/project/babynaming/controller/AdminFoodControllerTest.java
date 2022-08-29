package com.project.babynaming.controller;


import com.project.babynaming.entity.Adminfood;

import com.project.babynaming.repo.Adminfoodrepository;

import com.project.babynaming.services.Adminfoodservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
class AdminFoodControllerTest {
    private Adminfood Adminfood;
    @InjectMocks
    private Adminfoodservice Service;

    @Mock
    private Adminfoodrepository Repository;

    @BeforeEach
    void setUp() {
        Adminfood=Adminfood.builder()
                .id(1l)
                .name("pizza")
                .price("700")
                .image("image")

                .build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void userbookevent()throws Exception {
        given(Repository.findByFoodname(Adminfood.getFoodname())).willReturn(Adminfood);
        given(Repository.save(Adminfood)).willReturn(Adminfood);
        Adminfood addon=Service.savefood(Adminfood);
        assertThat(addon).isNotNull();
    }

    @Test
    void getAllUsers() {
        given(Repository.findAll()).willReturn(List.of(Adminfood));
        List<Adminfood> adminfood=Service.getAllFood();
        for(Adminfood adminfood1:adminfood)
        {
            assertThat(adminfood1).isNotNull();
        }
        assertThat(adminfood.size()).isEqualTo(1);
    }

    @Test
    void deleteUser() {
        willDoNothing().given(Repository).deleteById(Adminfood.getId());
        Service.deleteFoodById(Adminfood.getId());
        assertEquals(false,Repository.existsById(Adminfood.getId()));
    }

    @Test
    void getUserById() {
         given(Repository.findById(Adminfood.getId())).willReturn(Optional.of(Adminfood));
         Object adminfood=Service.fetchById(Adminfood.getId()).get();
         assertThat(adminfood).isNotNull();

    }


}