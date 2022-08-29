package com.project.babynaming.repo;

import com.project.babynaming.entity.LoginRegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginRegisterRepository extends JpaRepository<LoginRegisterModel,Long>
{

    LoginRegisterModel findByPhone(String currPhone) ;


    LoginRegisterModel findByEmail(String email);


    LoginRegisterModel findByEmailAndPassword(String currEmail, String currPassword);


}
