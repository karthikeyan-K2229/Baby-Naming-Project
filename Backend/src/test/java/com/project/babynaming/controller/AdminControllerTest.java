package com.project.babynaming.controller;


import com.project.babynaming.entity.AddOn;
import com.project.babynaming.entity.ThemeModel;

import com.project.babynaming.repo.ThemeRepository;

import com.project.babynaming.services.ThemeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class AdminControllerTest {
    private ThemeModel themeModel;
    @InjectMocks
    private ThemeService service;

    @Mock
    private ThemeRepository repository;
    @BeforeEach
    void setUp() {
        themeModel=themeModel.builder()
                .id(1l)
                .themeName("birthday")
                .photographer("jd")
                .videographer("rolex")
                .gift("gift")
                .cost("1000")
                .build();
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void register() {
        given(repository.findByThemeName(themeModel.getThemeName())).willReturn(themeModel);
        given(repository.save(themeModel)).willReturn(themeModel);
        ThemeModel theme= null;
        try {
            theme = service.saveUser(themeModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(theme).isNotNull();

    }

    @Test
    void getAllThemes() {
        given(repository.findAll()).willReturn(List.of(themeModel));
        List<ThemeModel> themeModelList=service.getAllTheme();

        for(ThemeModel themeModel:themeModelList) {
            assertThat(themeModel).isNotNull();
        }
        assertThat(themeModelList.size()).isEqualTo(1);
    }

    @Test
    void getTheme() {
        given(repository.findBythemeid(themeModel.getThemeid())).willReturn(themeModel);
        ThemeModel thememodel1=service.fetchByThemeId(themeModel.getThemeid());
        assertThat(thememodel1).isNotNull();
    }

    @Test
    void deleteUser() {
        willDoNothing().given(repository).deleteById(themeModel.getThemeid());
        service.deleteThemeById(themeModel.getThemeid());
        assertEquals(false,repository.existsById(themeModel.getThemeid()));

    }




}