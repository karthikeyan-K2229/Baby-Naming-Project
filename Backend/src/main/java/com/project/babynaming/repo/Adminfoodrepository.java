package com.project.babynaming.repo;

import com.project.babynaming.entity.Adminfood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Adminfoodrepository extends JpaRepository<Adminfood,Long> {
    Adminfood findByFoodname(String currentfood);
}
