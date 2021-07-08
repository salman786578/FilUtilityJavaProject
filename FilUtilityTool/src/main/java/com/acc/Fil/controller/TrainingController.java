package com.acc.Fil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.Fil.entity.TrainingEntity;
import com.acc.Fil.service.TrainingServiceImpl;

@RestController
public class TrainingController {

	@Autowired
	private TrainingServiceImpl trainingServiceImpl;
	
	@RequestMapping(value = "/filTools/v1/training/getDetails", method = RequestMethod.GET)
	public List getAllTraining() {
		return trainingServiceImpl.getAllTraining();
	}
	
	@RequestMapping(value = "/filTools/v1/training/getDetailsById/{id}", method = RequestMethod.GET)
	public Object getTraining(@PathVariable int id) {
		return  trainingServiceImpl.getTraining(id);
	}
	
	@RequestMapping(value = "/filTools/v1/training/addtraining", method =RequestMethod.POST)
	public void addTraining(@RequestBody TrainingEntity tentity) {
		trainingServiceImpl.addTraining(tentity);
	}
	
	@RequestMapping(value = "/filTools/v1/training/updateTraining/{id}", method = RequestMethod.PUT)
	public void updateTraining(@RequestBody TrainingEntity tentity,@PathVariable int id) {
		trainingServiceImpl.updateTraining(id, tentity);
	}
	@RequestMapping(value = "/filTools/v1/training/deleteTraining/{id}", method = RequestMethod.DELETE)
	public void deleteTraining(@PathVariable int id) {
		trainingServiceImpl.deleteTraining(id);
	}
	
}
