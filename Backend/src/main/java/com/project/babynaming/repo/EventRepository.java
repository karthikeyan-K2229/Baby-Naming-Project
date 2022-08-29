package com.project.babynaming.repo;

import com.project.babynaming.entity.EventModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface EventRepository  extends CrudRepository<EventModel,Long>{



      public List<EventModel> findByApplicantEmailId(String email);
      public List<EventModel> findByuserId(Long id);
      public EventModel findByeventid(Long id);

}
