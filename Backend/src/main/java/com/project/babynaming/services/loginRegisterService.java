package com.project.babynaming.services;

import com.project.babynaming.entity.AuthenticationRequest;
import com.project.babynaming.entity.FeedBack;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.LoginRegisterRepository;
import com.project.babynaming.entity.LoginRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class loginRegisterService {
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    private LoginRegisterRepository repository;
    //Register
    public LoginRegisterModel saveUser(LoginRegisterModel user)throws  Exception
    {
        String currentMail=user.getEmail();
        String currPhone=user.getPhone();
        LoginRegisterModel userObj = repository.findByEmail(currentMail);
        LoginRegisterModel UserPhn=repository.findByPhone(currPhone);

        if(userObj != null && UserPhn !=null)
        {
            throw new Exception("Email and phone number already exists !!!");
        }
        if(userObj != null)
        {
            throw new Exception("Email id already exists !!!");
        }
        if(UserPhn != null)
        {
            throw new Exception("Phone number already exists !!!");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    //Login
    public LoginRegisterModel fetchByEmail(LoginRegisterModel user)throws ResourceNotFoundException
    {
        String currEmail=user.getEmail();
        String currPassword=user.getPassword();
        LoginRegisterModel userObj = repository.findByEmailAndPassword(currEmail,currPassword);
        return userObj;
    }


    public LoginRegisterModel findByEmail(String email) {
        LoginRegisterModel user = repository.findByEmail(email);
        return user;
    }


    public LoginRegisterModel getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
    }


}