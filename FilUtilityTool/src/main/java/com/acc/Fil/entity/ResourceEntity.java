package com.acc.Fil.entity;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "resource")
public class ResourceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="resource_id")
	private int resourceId;
	@Column(name="fil_id")
	private int filId;
	@Column(name="accenture_id")
	private int accentureId;
	@Column(name="fil_joining_date")
	@Temporal(TemporalType.DATE)
	private Date filJoiningDate;
	@Column(name="accenture_joining_date")
	@Temporal(TemporalType.DATE)
	private Date accentureJoiningDate;
	
	
	  @ManyToMany(cascade = CascadeType.ALL)
	  
	  @JoinTable(name = "resource_certification", joinColumns = @JoinColumn(name =
	  "resource_id", referencedColumnName = "resource_id"), inverseJoinColumns
	  = @JoinColumn(name = "certification_id", referencedColumnName =
	  "certification_id")) private Set<CertificationEntity> certifications;
	  
	  
	  
	  @ManyToMany(cascade = CascadeType.ALL)
	  
	  @JoinTable(name = "resource_training", joinColumns = @JoinColumn(name =
	  "resource_id", referencedColumnName = "resource_id"), inverseJoinColumns
	  = @JoinColumn(name = "training_id", referencedColumnName = "training_id"))
	  private Set<TrainingEntity> trainings;
	 

	
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getFilId() {
		return filId;
	}
	public void setFilId(int filId) {
		this.filId = filId;
	}
	public int getAccentureId() {
		return accentureId;
	}
	public void setAccentureId(int accentureId) {
		this.accentureId = accentureId;
	}
	public Date getFilJoiningDate() {
		return filJoiningDate;
	}
	public void setFilJoiningDate(Date filJoiningDate) {
		this.filJoiningDate = filJoiningDate;
	}
	public Date getAccentureJoiningDate() {
		return accentureJoiningDate;
	}
	public void setAccentureJoiningDate(Date accentureJoiningDate) {
		this.accentureJoiningDate = accentureJoiningDate;
	}
	public ResourceEntity(ResourceEntity resource) {
		//super();
		System.out.println("Inside resourse entity constructor");
		this.resourceId = resource.resourceId;
		this.filId = resource.filId;
		this.accentureId = resource.accentureId;
		this.filJoiningDate = resource.filJoiningDate;
		this.accentureJoiningDate = resource.accentureJoiningDate;
		
	}

	
	  public Set<CertificationEntity> getCertifications() { return certifications;
	  } public void setCertifications(Set<CertificationEntity> certifications) {
	  this.certifications = certifications; } public Set<TrainingEntity>
	  getTrainings() { return trainings; } public void
	  setTrainings(Set<TrainingEntity> trainings) { this.trainings = trainings; }
	 
	public ResourceEntity() {
		//super();
	}
    
    
}
