package com.acc.Fil.bean;

import java.util.Date;

public class TrainingBean {

	private int trainingId;
	private String trainingName;
	private String trainingDesc;
	private Date startDate;
	private Date completedDate;
	private String trainingStatus;
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTrainingDesc() {
		return trainingDesc;
	}
	public void setTrainingDesc(String trainingDesc) {
		this.trainingDesc = trainingDesc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	public String getTrainingStatus() {
		return trainingStatus;
	}
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}
	@Override
	public String toString() {
		return "TrainingBean [trainingId=" + trainingId + ", trainingName=" + trainingName + ", trainingDesc="
				+ trainingDesc + ", startDate=" + startDate + ", completedDate=" + completedDate + ", trainingStatus="
				+ trainingStatus + "]";
	}
	
	
}
