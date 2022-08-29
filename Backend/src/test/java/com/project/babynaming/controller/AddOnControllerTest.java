package com.project.babynaming.controller;


import com.project.babynaming.entity.AddOn;
import com.project.babynaming.repo.AddOnRepository;
import com.project.babynaming.services.AddOnService;
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
class AddOnControllerTest {
    @InjectMocks
    private AddOnService addonService;

    @Mock
    private AddOnRepository addonRepository;
       private AddOn AddOn;
    @BeforeEach
    void setUp() {
        AddOn=AddOn.builder()
                .id(1l)
                .name("sri")
                .price("7222")
                .image("image")

                .build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addNewFood() throws Exception {
        given(addonRepository.findByName(AddOn.getName())).willReturn(AddOn);
        given(addonRepository.save(AddOn)).willReturn(AddOn);
        AddOn AddOn1=addonService.saveFood(AddOn);
        assertThat(AddOn1).isNotNull();
    }

@Test
    void getAllEmployees() {
        given(addonRepository.findAll()).willReturn(List.of(AddOn));
        List<AddOn> addon=addonService.findAllAddOn();
        for(AddOn addon1: addon)
        {
            assertThat(addon1).isNotNull();
        }
         assertThat(addon.size()).isEqualTo(1);
    }

@Test
    void getEmployeeById() {
        given(addonRepository.findById(AddOn.getId())).willReturn(Optional.of(AddOn));
        Object addon1=  addonService.fetchById(AddOn.getId()).get();
        assertThat(addon1).isNotNull();
    }

@Test
    void deleteEmployee() {
      willDoNothing().given(addonRepository).deleteById(AddOn.getId());
      addonService.deleteFoodById(AddOn.getId());
      assertEquals(false,addonRepository.existsById(AddOn.getId()));

    }



}