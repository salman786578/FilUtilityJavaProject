package com.acc.Fil.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.acc.Fil.controller.TrainingTestController;
import com.acc.Fil.dao.TrainingTestDao;
import com.acc.Fil.entity.TrainingTestEntity;

@Service
public class TrainingTestImpl {

	@Autowired
	private TrainingTestDao trainingTestDaoWrapper;

	private static int countEntities;
		
			@SuppressWarnings("resource")
			public List<TrainingTestEntity> saveTrainingData(String filePath) throws IOException  
			
			{
				
				List<TrainingTestEntity> listOfExistingEntities=null;
				String[] extension=filePath.split("\\.");
				if(extension[1].equalsIgnoreCase("xlsx")) 
				{  
					listOfExistingEntities=saveTrainingDataXLSX(filePath);
					
				}
				else if(extension[1].equalsIgnoreCase("xls")) {
					listOfExistingEntities=saveTrainingDataXLS(filePath);
				}
				else if (extension[1].equalsIgnoreCase("csv"))
				{
					
					listOfExistingEntities=saveTrainingDataCSV(filePath);
				}
				return listOfExistingEntities;
			}
			
			// Method for Handling spreadsheets with extension xlsx
			
			public List<TrainingTestEntity> saveTrainingDataXLSX(String filePath) throws IOException {
					FileInputStream file = new FileInputStream(new File(filePath));
					countEntities=0;
					
					@SuppressWarnings("resource")
					XSSFWorkbook workbook = new XSSFWorkbook (file);
					XSSFSheet sheet;
					
				
					
					
					int noOfSheets=workbook.getNumberOfSheets();
					int i=0;
					List<TrainingTestEntity> listOfExistingEntities =new ArrayList<TrainingTestEntity>();
					while(i<noOfSheets) {
					 sheet = workbook.getSheetAt(i);
					
					 
					
					 for(int j=0;j<sheet.getPhysicalNumberOfRows() ;j++) {
					       TrainingTestEntity testEntity=new TrainingTestEntity();
					        countEntities++;
					        XSSFRow row = sheet.getRow(j);
				
						   System.out.println("start of try block ");
					        String aid=row.getCell(1,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					        System.out.println("start of try block 2");
					        String status=row.getCell(2,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					        
					        testEntity.setName(row.getCell(0,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());		
					        
					        
					        testEntity.setAid(row.getCell(1,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					        testEntity.setStatus(row.getCell(2,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					        testEntity.setCareer_level((int)row.getCell(3,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					   
					 System.out.println("Before if");
					        if(row.getCell(0).getStringCellValue().equals("") || row.getCell(1).getStringCellValue().equals("") || row.getCell(2).getStringCellValue().equals(""))
					        {
					        	
					        	System.out.println("Inside null handler");
					        	TrainingTestController controller =new TrainingTestController();
					       
					        	controller.containsNull(true);
					        	continue;
					        }
					       
					      
					        else  if(!trainingTestDaoWrapper.existsEntityLikeCustomQuery(aid,status)) {
					    	   trainingTestDaoWrapper.save(testEntity);
					    	  
					       
					       }else {
					       
					    	   System.out.println("Data Already Exists!!"+testEntity);
					    	   
					    	   listOfExistingEntities.add(testEntity);
					    	   continue;
					        }
					 
					 }					
					 							 
					i++;
				}
					TrainingTestImpl tImpl=new TrainingTestImpl();
					tImpl.setTotalNoOfEntities(countEntities);
					
					
					return listOfExistingEntities;
					
			}
			
			
			
			public void setTotalNoOfEntities(int countEntities) {
				this.countEntities=countEntities;
			
			}
			public int getTotalNoOfEntities() { 
				
				return countEntities;}
					
			// Method for Handling spreadsheets with extension xls
				public List<TrainingTestEntity> saveTrainingDataXLS(String filePath) throws IOException {
					
					countEntities=0;
					
					
					FileInputStream file = new FileInputStream(new File(filePath));
				
					//Get the workbook instance for XLS file 
					@SuppressWarnings("resource")
					HSSFWorkbook workbook = new HSSFWorkbook(file);

					//Get first sheet from the workbook
					HSSFSheet sheet;
					int noOfSheets=workbook.getNumberOfSheets();
					int i=0;
					List<TrainingTestEntity> listOfExistingEntities =new ArrayList<TrainingTestEntity>();
					while(i<noOfSheets) {
					 sheet = workbook.getSheetAt(i);

					
					 for(int j=0;j<sheet.getPhysicalNumberOfRows()-1 ;j++) {
					       TrainingTestEntity testEntity=new TrainingTestEntity();
					       countEntities++;
					       HSSFRow row=sheet.getRow(j);

					       String aid=row.getCell(1).getStringCellValue();
					        String status=row.getCell(2).getStringCellValue();
					        testEntity.setName(row.getCell(0).getStringCellValue());				        
					        testEntity.setAid(row.getCell(1).getStringCellValue());
					        testEntity.setStatus(row.getCell(2).getStringCellValue());
					        testEntity.setCareer_level((int)row.getCell(3).getNumericCellValue());
					        if(!trainingTestDaoWrapper.existsEntityLikeCustomQuery(aid,status)) {
						    	   trainingTestDaoWrapper.save(testEntity);
						    	  
						       
						       }else {
						       
						    	   System.out.println("Data Already Exists!!"+testEntity);
						    	   
						    	   listOfExistingEntities.add(testEntity);
						    	   continue;
						        }
						    }
					i++;
					}
					TrainingTestImpl tImpl=new TrainingTestImpl();
					tImpl.setTotalNoOfEntities(countEntities);
					
					
					return listOfExistingEntities;
					
					}
				
				// Method for Handling spreadsheets with extension csv
				public List<TrainingTestEntity> saveTrainingDataCSV(String filePath) throws IOException {
					String line="";
					countEntities=0;
					List<TrainingTestEntity> listOfExistingEntities =new ArrayList<TrainingTestEntity>();
					
					  try {
					  
					  BufferedReader br = new BufferedReader(new FileReader(filePath));
					
					  while((line=br.readLine())!=null) {
						  countEntities++;
					  
					  String[] data=line.split(",");
					  TrainingTestEntity test=new TrainingTestEntity(); 
					  String aid=data[1];
					  String status=data[2];
					  
					  test.setName(data[0]); 
					  test.setAid(data[1]);
					  test.setStatus(data[2]); 
					  test.setCareer_level(Integer.parseInt(data[3]));
					  if(!trainingTestDaoWrapper.existsEntityLikeCustomQuery(aid,status)) {
				    	   trainingTestDaoWrapper.save(test);
				    	  
				       
				       }else {
				       
				    	   System.out.println("Data Already Exists!!"+test);
				    	   
				    	   listOfExistingEntities.add(test);
				    	   continue;
				        }
					  }
					  br.close();					  
					  }
					  catch (FileNotFoundException e) { // TODO Auto-generated catch block
					  
						  e.printStackTrace(); }
						TrainingTestImpl tImpl=new TrainingTestImpl();
						tImpl.setTotalNoOfEntities(countEntities);
						
						
						return listOfExistingEntities;				
				}
				
			
			public List	getAllTraining() {
			List training = new ArrayList<>();
			trainingTestDaoWrapper.findAll().forEach(training::add);
				return training;
			}	
			public Object getTraining(int id) {
				return trainingTestDaoWrapper.findById(id);
			}
			
			public void updateTraining(int id, TrainingTestEntity tentity) {
				
				
				TrainingTestEntity tentity2 = trainingTestDaoWrapper.findById(id).get();
			
				tentity2.setName(tentity.getName());
				tentity2.setAid(tentity.getAid());
				tentity2.setCareer_level(tentity.getCareer_level());
				tentity2.setStatus(tentity.getStatus());
				
				
				trainingTestDaoWrapper.save(tentity2);
				
			}
			
			
}
