package com.project.babynaming.repo;

import com.project.babynaming.entity.ThemeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeModel,Long> {


    ThemeModel findByThemeName(String currtheme);
    ThemeModel findBythemeid(long themeid);


}
