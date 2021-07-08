package com.acc.Fil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "training_csv_test")
public class TrainingTestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="training_csv_id")
	private int training_csv_Id;
	
	@Column(name="Name")
	private String Name;
	@Column(name="AID")
	private String aid;
	@Column(name="Status")
	private String status;
	@Column(name="Career_level")
	private Integer career_level;
	
	
	
	public TrainingTestEntity() {
		super();
	}
	public TrainingTestEntity(int training_csv_Id, String name, String aid, String status, Integer career_level) {
		super();
		this.training_csv_Id = training_csv_Id;
		Name = name;
		this.aid = aid;
		this.status = status;
		this.career_level = career_level;
	}
	@Override
	public String toString() {
		return "Training_csvEntity [training_csv_Id=" + training_csv_Id + ", Name=" + Name + ", aid=" + aid
				+ ", status=" + status + ", career_level=" + career_level + "]";
	}
	public int getTraining_csv_Id() {
		return training_csv_Id;
	}
	public void setTraining_csv_Id(int training_csv_Id) {
		this.training_csv_Id = training_csv_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCareer_level() {
		return career_level;
	}
	public void setCareer_level(int d) {
		this.career_level = d;
	}
	
		
	
}
