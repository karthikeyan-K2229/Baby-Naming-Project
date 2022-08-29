package com.project.babynaming.services;


import com.project.babynaming.entity.FeedBack;
import com.project.babynaming.repo.FeedBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {

@Autowired
private FeedBackRepo feedBackRepo;

    public List<FeedBack> getAllFeedback()
    {
        return feedBackRepo.findAll();
    }

    public FeedBack saveUser(FeedBack user) {
        return  feedBackRepo.save(user);
    }

}
