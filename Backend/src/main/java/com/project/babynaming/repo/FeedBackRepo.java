package com.project.babynaming.repo;

import com.project.babynaming.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepo extends JpaRepository<FeedBack,Integer> {
}
