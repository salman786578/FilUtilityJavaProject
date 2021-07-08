package com.acc.Fil.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "training")
public class TrainingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="training_id")
	private int trainingId;
	@Column(name="training_name")
	private String trainingName;
	@Column(name="training_desc")
	private String trainingDesc;
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name="completed_date")
	@Temporal(TemporalType.DATE)
	private Date completedDate;
	@Column(name="traning_status")
	private String trainingStatus;
	
	@OneToMany(mappedBy = "training_id",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResourceTrainingDetailsEntity> resources_trainings;


	
	
	public TrainingEntity(int trainingId, String trainingName, String trainingDesc, Date startDate, Date completedDate,
			String trainingStatus) {
		super();
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.trainingDesc = trainingDesc;
		this.startDate = startDate;
		this.completedDate = completedDate;
		this.trainingStatus = trainingStatus;
		resources_trainings=new HashSet<>();
		
	}
	
	
	public TrainingEntity(int trainingId) {
		super();
		this.trainingId = trainingId;
	}

	public Set<ResourceTrainingDetailsEntity> getResources_trainings() {
		return resources_trainings;
	}

	public void setResources_trainings(Set<ResourceTrainingDetailsEntity> resources_trainings) {
		this.resources_trainings = resources_trainings;
	}

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

	
	public TrainingEntity() {
		super();
	}
	@Override
	public String toString() {
		return "TrainingEntity [trainingId=" + trainingId + ", trainingName=" + trainingName + ", trainingDesc="
				+ trainingDesc + ", startDate=" + startDate + ", completedDate=" + completedDate + ", trainingStatus="
				+ trainingStatus + "]";
	}
    
}
