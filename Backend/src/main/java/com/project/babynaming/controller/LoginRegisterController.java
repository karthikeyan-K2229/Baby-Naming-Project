package com.project.babynaming.controller;

import com.project.babynaming.entity.*;
import com.project.babynaming.security.JwtTokenUtil;
import com.project.babynaming.security.MyUserDetailsService;
import com.project.babynaming.services.FeedBackService;
import com.project.babynaming.services.loginRegisterService;
import com.project.babynaming.repo.LoginRegisterRepository;
import com.project.babynaming.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginRegisterController {
    Logger log= LoggerFactory.getLogger(LoginRegisterController.class);
@Autowired
private LoginRegisterRepository loginregiterrepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private loginRegisterService service;
    @Autowired
    private FeedBackService fservice;
    //register
    @PostMapping("/userregister")
    public ResponseEntity<LoginRegisterModel> register(@RequestBody LoginRegisterModel user)
    {
           try{
            LoginRegisterModel userObj = null;
            userObj = service.saveUser(user);
            log.info("Registered Successfully");
            return new ResponseEntity<LoginRegisterModel>(userObj, HttpStatus.OK);
            }
           catch(Exception e){
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

    //login
    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest)throws Exception
    {
        LoginRegisterModel userObj=null;
        userObj = service.findByEmail(authenticationRequest.getEmail());
        if(userObj!=null)
        {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean passwordexist = passwordEncoder.matches(authenticationRequest.getPassword(), userObj.getPassword());
            if(passwordexist){
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
            final String jwt = jwtTokenUtil.generateToken(userDetails);
            log.info("Login Successfull");
            return ResponseEntity.ok(new AuthenticationResponse(jwt, service.findByEmail(authenticationRequest.getEmail())));

        }
            else{
                return new ResponseEntity<>("password Mismatched",HttpStatus.BAD_REQUEST);
            }
        }

        else{
            return new ResponseEntity<>("Not found",HttpStatus.OK);
        }


    }

    
    //get all users
    @GetMapping("/getAllUsers")
    @CrossOrigin(origins="http://localhost:4200")
    public List<LoginRegisterModel> getAllUsers(){
        return loginregiterrepo.findAll();
    }
    

    //delete user rest api
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){
        LoginRegisterModel user=loginregiterrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +id ));
        loginregiterrepo.delete(user);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        log.info("Deleted Successfully");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<LoginRegisterModel> getUser(@PathVariable Long id)
    {
        LoginRegisterModel user=service.getById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/feedback")
    public ResponseEntity<FeedBack> userbookevent(@RequestBody FeedBack user)
    {
            FeedBack userObj = null;
            userObj = fservice.saveUser(user);
            log.info("feedback posted sucessfully");
            return new ResponseEntity<FeedBack>(userObj,HttpStatus.OK);
    }
    @GetMapping("/allFeedBack")
    public ResponseEntity<List<FeedBack>> getAllFeed()
    {
        List<FeedBack> feedBacks=fservice.getAllFeedback();
        return new ResponseEntity<>(feedBacks,HttpStatus.OK);
    }
}

