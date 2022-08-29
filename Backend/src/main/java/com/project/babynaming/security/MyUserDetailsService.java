package com.project.babynaming.security;


import com.project.babynaming.entity.LoginRegisterModel;
import com.project.babynaming.repo.LoginRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginRegisterRepository userrepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginRegisterModel user = userrepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());

    }
}