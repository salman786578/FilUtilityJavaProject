package com.acc.Fil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acc.Fil.entity.ResourceTrainingDetailsEntity;
import com.acc.Fil.entity.TrainingEntity;


public interface ResourceTrainingDao extends JpaRepository<ResourceTrainingDetailsEntity, Integer> {
	
	  @Query("SELECT count(r) FROM ResourceTrainingDetailsEntity r WHERE r.aid = :aid and r.status= :status and r.training_id= :training_id"
	  ) public int existsEntityLikeCustomQuery(@Param("aid") String aid,@Param("status") String status,@Param("training_id") TrainingEntity training_id);
	 

	
	
}
