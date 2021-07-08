package com.acc.Fil.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.acc.Fil.entity.TrainingTestEntity;
import com.acc.Fil.service.TrainingTestImpl;


@RestController
public class TrainingTestController {

	@Autowired
	private TrainingTestImpl testService;
	
	private static boolean hasNullValues;

	
	@RequestMapping(value = "/filTools/v1/training/saveExcelData", method =RequestMethod.POST)
	public ResponseEntity<String> saveTrainingData() throws IOException {
								
								List<TrainingTestEntity> listOfExistingEntities;
								String filePath="src/main/resources/Fil_Data.xlsx";
								listOfExistingEntities= testService.saveTrainingData(filePath);
							TrainingTestController controllerObject=new TrainingTestController();
							
								int listSize=listOfExistingEntities.size();
								TrainingTestImpl tImpl =new TrainingTestImpl();
								int noOfInsertedEntities=tImpl.getTotalNoOfEntities();
								System.out.println(noOfInsertedEntities);
								boolean hasNullValues=controllerObject.retrieveNull();
								boolean ifNullExist=controllerObject.retrieveNull();
							
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
	

	@RequestMapping(value = "/filTools/v1/training/getTrainingTestDetails", method = RequestMethod.GET)
	public List getAllTraining() {
		return testService.getAllTraining();
	}
	
	
	@RequestMapping(value = "/filTools/v1/training/getTrainingTestDetailsById/{id}", method = RequestMethod.GET)
	public Object getTraining(@PathVariable int id) {
		return testService.getTraining(id);
	}
	

	@RequestMapping(value = "/filTools/v1/training/updateTrainingTest/{id}", method = RequestMethod.PUT)
	public void updateTraining(@RequestBody TrainingTestEntity tentity,@PathVariable int id) {
		testService.updateTraining(id, tentity);
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
