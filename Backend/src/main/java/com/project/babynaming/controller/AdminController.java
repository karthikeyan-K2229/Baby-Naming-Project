package com.project.babynaming.controller;



import com.project.babynaming.entity.AddOn;
import com.project.babynaming.entity.ThemeModel;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.ThemeRepository;
import com.project.babynaming.services.ThemeService;
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
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
    Logger log= LoggerFactory.getLogger(AdminController.class);

private  static final  String NOTFOUND="Theme does not exist with id";
    @Autowired  ThemeService themeservice;
    @Autowired
    ThemeRepository themerepo;
    @PostMapping("/admin/addtheme")
    public ResponseEntity<ThemeModel> register(@RequestBody ThemeModel theme)
    {

        try {
            ThemeModel userObj = null;
            String currtheme=theme.getThemeName();
            ThemeModel userobj=themeservice.findByThemeName(currtheme);
            if(userobj !=null)
            {

                throw new Exception("Already Exits");
            }

            userObj=themeservice.saveUser(theme);
            log.info("Saved Successfully");
            return new ResponseEntity<ThemeModel>(userObj, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/user/getAllThemes")
    public ResponseEntity<List<ThemeModel>> getAllThemes() throws ResourceNotFoundException
    {
        List<ThemeModel> theme=themeservice.getAllTheme();
        return new ResponseEntity<List<ThemeModel>>(theme, HttpStatus.OK);
    }

    @GetMapping("/user/getTheme/{id}")
    public ResponseEntity<ThemeModel> getTheme(@PathVariable Long id) throws ResourceNotFoundException
    {
        ThemeModel themeModel1 = themeservice.fetchByThemeId(id);
        return new ResponseEntity<ThemeModel>(themeModel1, HttpStatus.OK);
    }

    @DeleteMapping("/admin/deletetheme/{themeid}")
    public ResponseEntity<AddOn> deleteUser(@PathVariable Long themeid){
        themeservice.deleteThemeById(themeid);
        log.info("Deleted Successfully");
        return new ResponseEntity<AddOn>(HttpStatus.OK);

    }
    @PutMapping("/admin/updatetheme/{themeid}")
    public ResponseEntity<ThemeModel> updateUser(@PathVariable Long themeid, @RequestBody ThemeModel userDetails) throws ResourceNotFoundException {

        themeservice.updatetheme(userDetails,themeid);
        log.info("Updated Successfully");
        return new ResponseEntity<ThemeModel>(HttpStatus.OK);
    }
    
    @GetMapping("/admin/getthemebyid/{themeid}")
    public ResponseEntity<Optional<ThemeModel>> getUserById(@PathVariable Long themeid){
            Optional<ThemeModel> food = themeservice.fetchById(themeid);
            return ResponseEntity.ok(food);

    }
}
