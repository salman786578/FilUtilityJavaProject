
package com.acc.Fil.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.acc.Fil.entity.TrainingEntity;

public interface TrainingDao extends JpaRepository<TrainingEntity, Integer> {

}