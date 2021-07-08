
package com.acc.Fil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.Fil.dao.TrainingDao;
import com.acc.Fil.entity.TrainingEntity;

@Service
public class TrainingServiceImpl{

	@Autowired
	private TrainingDao trainingDaoWrapper;

	@SuppressWarnings("unchecked")
	public List getAllTraining() {
		List training = new ArrayList<>();
	trainingDaoWrapper.findAll().forEach(training::add);
		return training;
	}
	public Object getTraining(int id) {
		return trainingDaoWrapper.findById(id);
	}
	public void addTraining(TrainingEntity tentity) {
		trainingDaoWrapper.save(tentity);
	}
	
	public void updateTraining(int id, TrainingEntity tentity) {
		
	
		TrainingEntity tentity2 = trainingDaoWrapper.findById(id).get();
	
		tentity2.setTrainingName(tentity.getTrainingName());
		tentity2.setTrainingDesc(tentity.getTrainingDesc());
		tentity2.setTrainingStatus(tentity.getTrainingStatus());
		tentity2.setStartDate(tentity.getStartDate());
		tentity2.setCompletedDate(tentity.getCompletedDate());
		
		trainingDaoWrapper.save(tentity2);
		
	}
	public void deleteTraining(int id) {
		trainingDaoWrapper.deleteById(id);;
	}
	
	
	
}