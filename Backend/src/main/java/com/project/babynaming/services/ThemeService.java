package com.project.babynaming.services;

import java.util.List;
import java.util.Optional;

import com.project.babynaming.entity.ThemeModel;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    private  static final  String NOTFOUND="Theme does not exist with id";
    final private static org.apache.log4j.Logger log=org.apache.log4j.LogManager.getLogger(AddOnService.class);
    @Autowired
    ThemeRepository themerepository;

    public ThemeModel saveUser(ThemeModel theme)  {



        return themerepository.save(theme);
    }

    public List<ThemeModel> getAllTheme() {
        return  (List<ThemeModel>)themerepository.findAll();
    }

    public ThemeModel fetchByThemeId(Long themeid) {

        return (ThemeModel)themerepository.findBythemeid(themeid);
    }

    public void deleteThemeById(Long themeid) {
        themerepository.deleteById(themeid);
    }

    public ThemeModel updatetheme(ThemeModel userDetails, Long themeid) {
        ThemeModel user=themerepository.findById(themeid).orElseThrow(()->new ResourceNotFoundException(NOTFOUND +themeid ));
        user.setPhotographerDetails(userDetails.getPhotographerDetails());
        user.setVideographerDetails(userDetails.getVideographerDetails());
        user.setReturnGift(userDetails.getReturnGift());
        user.setThemeCost(userDetails.getThemeCost());
        user.setImageUrl(userDetails.getImageUrl());
        user.setThemeName(userDetails.getThemeName());
        user.setThemeDiscription(userDetails.getThemeDiscription());
         return themerepository.save(user);


    }

    public Optional<ThemeModel> fetchById(Long themeid) {
        ThemeModel user=themerepository.findById(themeid).orElseThrow(()->new ResourceNotFoundException(NOTFOUND +themeid ));
        return Optional.ofNullable(user);
    }

    public ThemeModel findByThemeName(String currtheme) {
       ThemeModel model= themerepository.findByThemeName(currtheme);
       return model;
    }
}
