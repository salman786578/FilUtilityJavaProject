package com.acc.Fil.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.Fil.entity.ResourceTrainingDetailsEntity;
import com.acc.Fil.entity.TrainingTestEntity;
import com.acc.Fil.service.ResourceTrainingService;


@RestController
public class ResourceTrainingController {

	@Autowired
	private ResourceTrainingService testService;
	
	private static boolean hasNullValues;

	
	@RequestMapping(value = "/filTools/v1/training/saveExcelData2", method =RequestMethod.POST)
	public ResponseEntity<String> saveTrainingData2() throws IOException {
								
								List<ResourceTrainingDetailsEntity> listOfExistingEntities;
								String filePath="src/main/resources/Fil_Data.xlsx";
								listOfExistingEntities= testService.saveTrainingData(filePath);
							ResourceTrainingController controllerObject=new ResourceTrainingController();
							
								int listSize=listOfExistingEntities.size();
								ResourceTrainingService tImpl =new ResourceTrainingService();
								int noOfInsertedEntities=tImpl.getTotalNoOfEntities();
								System.out.println(noOfInsertedEntities);
								boolean hasNullValues=controllerObject.retrieveNull();
								
							
								if(listSize>0 && listSize==noOfInsertedEntities) 
									return new ResponseEntity<String>("Following Data Already Exists In DB!! \n"+listOfExistingEntities,HttpStatus.BAD_REQUEST);
								else if(listSize>0 && listSize<noOfInsertedEntities && hasNullValues)
									return new ResponseEntity<String>("New Data Inserted But Some Null or Blank Values(Null values are not inserted into DB) Found and Following Data Already Exists In DB!! \n"+listOfExistingEntities+" \n",HttpStatus.OK);
								else if(listSize>0 && listSize<noOfInsertedEntities && hasNullValues==false)
									return new ResponseEntity<String>("New Data Inserted But Following Data Already Exists In DB!! \n"+listOfExistingEntities,HttpStatus.OK);
								else if(listSize==0 && noOfInsertedEntities>0 && hasNullValues)
									return new ResponseEntity<String>("New Data Inserted SuccessFully but some null values found (Null values are not inserted into DB)",HttpStatus.OK);
	
								else
									return new ResponseEntity<String>("New Data Inserted SuccessFully",HttpStatus.OK);
	
	}
	

	@RequestMapping(value = "/filTools/v1/training/getTrainingTestDetails2", method = RequestMethod.GET)
	public List getAllTraining2() {
		return testService.getAllTraining();
	}
	
	
	@RequestMapping(value = "/filTools/v1/training/getTrainingTestDetailsById2/{id}", method = RequestMethod.GET)
	public Object getTraining2(@PathVariable int id) {
		return testService.getTraining(id);
	}
	public void containsNull(boolean hasNullValues) {
		this.hasNullValues=hasNullValues;
		System.out.println("From contains:"+hasNullValues);
		
	}
	public boolean retrieveNull() {

		System.out.println("From retrieve:"+this.hasNullValues);
		return this.hasNullValues;
		
	}

}