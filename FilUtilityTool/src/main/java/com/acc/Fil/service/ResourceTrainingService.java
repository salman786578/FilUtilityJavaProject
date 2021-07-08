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

import com.acc.Fil.controller.ResourceTrainingController;
import com.acc.Fil.dao.ResourceTrainingDao;
import com.acc.Fil.dao.TrainingDao;
import com.acc.Fil.entity.ResourceTrainingDetailsEntity;
import com.acc.Fil.entity.TrainingEntity;

@Service
public class ResourceTrainingService {
	@Autowired
	private ResourceTrainingDao resourceTrainingDaoWrapper;

	@Autowired
	private TrainingServiceImpl trainingServiceImpl;

	private static int countEntities;

	@SuppressWarnings("resource")
	public List<ResourceTrainingDetailsEntity> saveTrainingData(String filePath) throws IOException

	{

		List<ResourceTrainingDetailsEntity> listOfExistingEntities = null;
		String[] extension = filePath.split("\\.");
		if (extension[1].equalsIgnoreCase("xlsx")) {
			listOfExistingEntities = saveTrainingDataXLSX(filePath);

		}

		else if (extension[1].equalsIgnoreCase("xls")) {
			listOfExistingEntities = saveTrainingDataXLS(filePath);
		}

		return listOfExistingEntities;
	}

	// Method for Handling spreadsheets with extension xlsx

	@SuppressWarnings("unchecked")
	public List<ResourceTrainingDetailsEntity> saveTrainingDataXLSX(String filePath) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));
		countEntities = 0;

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet;

		int noOfSheets = workbook.getNumberOfSheets();
		int i = 0;
		List<ResourceTrainingDetailsEntity> listOfExistingEntities = new ArrayList<ResourceTrainingDetailsEntity>();
		while (i < noOfSheets) {
			sheet = workbook.getSheetAt(i);

			List trainingMasterData = trainingServiceImpl.getAllTraining();
			int noOfTraining = trainingMasterData.size();
			
			int k = 0;

			while (k < noOfTraining) {
				for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
					ResourceTrainingDetailsEntity testEntity = new ResourceTrainingDetailsEntity();
					countEntities++;
					XSSFRow row = sheet.getRow(j);

					String aid = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

					String status = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

					testEntity.setName(row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					testEntity.setAid(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					testEntity
							.setStatus(row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					testEntity.setCareer_level(
							(int) row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());

					TrainingEntity trEntity = (TrainingEntity) trainingMasterData.get(k);//Retrieveing Training Entities From Master Training Table
					
					testEntity.setTraining(trEntity);//Setting TrainingId From master Training Table

					int result = resourceTrainingDaoWrapper.existsEntityLikeCustomQuery(aid, status, trEntity);
					

					if (row.getCell(0).getStringCellValue().equals("") || row.getCell(1).getStringCellValue().equals("")
							|| row.getCell(2).getStringCellValue().equals("")) {

						ResourceTrainingController controller = new ResourceTrainingController();
						controller.containsNull(true);
						continue;
					}

					else if (result == 0) {
						resourceTrainingDaoWrapper.save(testEntity);

					} else {

						System.out.println("Data Already Exists!!" + testEntity);

						listOfExistingEntities.add(testEntity);
						continue;
					}
				}
				k++;
			}
			i++;
		}
		ResourceTrainingService tImpl = new ResourceTrainingService();
		tImpl.setTotalNoOfEntities(countEntities);

		return listOfExistingEntities;

	}

	public void setTotalNoOfEntities(int countEntities) {
		this.countEntities = countEntities;

	}

	public int getTotalNoOfEntities() {

		return countEntities;

	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------/			
	// Method for Handling spreadsheets with extension xls

	public List<ResourceTrainingDetailsEntity> saveTrainingDataXLS(String filePath) throws IOException {

		countEntities = 0;

		FileInputStream file = new FileInputStream(new File(filePath));

		// Get the workbook instance for XLS file

		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first sheet from the workbook
		HSSFSheet sheet; 
		int noOfSheets = workbook.getNumberOfSheets();
		int i = 0;
		List<ResourceTrainingDetailsEntity> listOfExistingEntities = new ArrayList<ResourceTrainingDetailsEntity>();
		while (i < noOfSheets) {
			sheet = workbook.getSheetAt(i);
			List trainingMasterData = trainingServiceImpl.getAllTraining();
			int noOfTraining = trainingMasterData.size();
			
			int k = 0;

			while (k < noOfTraining) {
			for (int j = 0; j < sheet.getPhysicalNumberOfRows() - 1; j++) {
				System.out.println("hello");
				ResourceTrainingDetailsEntity testEntity = new ResourceTrainingDetailsEntity();
				countEntities++;
				HSSFRow row = sheet.getRow(j);

				String aid = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				String status = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				
				testEntity.setName(row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
				testEntity.setAid(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
				testEntity.setStatus(row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
				testEntity.setCareer_level((int) row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
				
				TrainingEntity trEntity = (TrainingEntity) trainingMasterData.get(k);
				
				testEntity.setTraining(trEntity);

				int result = resourceTrainingDaoWrapper.existsEntityLikeCustomQuery(aid, status, trEntity);
				

				if (row.getCell(0).getStringCellValue().equals("") || row.getCell(1).getStringCellValue().equals("")
						|| row.getCell(2).getStringCellValue().equals("")) {

					ResourceTrainingController controller = new ResourceTrainingController();
					controller.containsNull(true);
					continue;
				}

				else if (result == 0) {
					resourceTrainingDaoWrapper.save(testEntity);

				}

				else {

					System.out.println("Data Already Exists!!" + testEntity);

					listOfExistingEntities.add(testEntity);
					continue;
				}
			}
			k++;
			}
			i++;
		}
		ResourceTrainingService tImpl = new ResourceTrainingService();
		tImpl.setTotalNoOfEntities(countEntities);

		return listOfExistingEntities;

	}
	

	public List getAllTraining() {
		List training = new ArrayList<>();
		resourceTrainingDaoWrapper.findAll().forEach(training::add);
		return training;
	}

	public Object getTraining(int id) {
		return resourceTrainingDaoWrapper.findById(id);
	}

	public void updateTraining(int id, ResourceTrainingDetailsEntity tentity) {

		ResourceTrainingDetailsEntity tentity2 = resourceTrainingDaoWrapper.findById(id).get();

		tentity2.setName(tentity.getName());
		tentity2.setAid(tentity.getAid());
		tentity2.setCareer_level(tentity.getCareer_level());
		tentity2.setStatus(tentity.getStatus());

		resourceTrainingDaoWrapper.save(tentity2);

	}

}
