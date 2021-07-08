package com.acc.Fil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.acc.Fil.entity.TrainingTestEntity;

public interface TrainingTestDao extends JpaRepository<TrainingTestEntity, Integer> {
	
	
	@Query("select case when count(t)> 0 then true else false end from TrainingTestEntity t where lower(t.aid) like lower(:aid) and lower(t.status) like lower(:status) ")
	boolean existsEntityLikeCustomQuery(@Param("aid") String aid, @Param("status") String status);
}
