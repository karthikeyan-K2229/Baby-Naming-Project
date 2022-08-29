package com.project.babynaming.repo;

import com.project.babynaming.entity.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddOnRepository extends JpaRepository<AddOn, Long>{
    AddOn findByName(String currentfood);

}
