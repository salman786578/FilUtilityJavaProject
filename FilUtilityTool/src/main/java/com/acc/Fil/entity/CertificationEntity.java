package com.acc.Fil.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "certification")
public class CertificationEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="certification_id")
	private int certificationId;
	@Column(name="certification_name")
	private String certificationName;
	@Column(name="certification_desc")
	private String certificationDesc;
	@Column(name="certification_type")
	private String certificationType;
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name="complete_date")
	@Temporal(TemporalType.DATE)
	private Date completeDate;
	@Column(name="certification_status")
	private String certificationStatus;
	
	
	
	  @ManyToMany(mappedBy = "certifications")
	    private Set<ResourceEntity> resources = new HashSet<>();
	
	public int getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}
	public String getCertificationName() {
		return certificationName;
	}
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	public Set<ResourceEntity> getResources() {
		return resources;
	}
	public void setResources(Set<ResourceEntity> resources) {
		this.resources = resources;
	}
	public String getCertificationDesc() {
		return certificationDesc;
	}
	public void setCertificationDesc(String certificationDesc) {
		this.certificationDesc = certificationDesc;
	}
	public String getCertificationType() {
		return certificationType;
	}
	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	public String getCertificationStatus() {
		return certificationStatus;
	}
	public void setCertificationStatus(String certificationStatus) {
		this.certificationStatus = certificationStatus;
	}
	@Override
	public String toString() {
		return "CertificationEntity [certificationId=" + certificationId + ", certificationName=" + certificationName
				+ ", certificationDesc=" + certificationDesc + ", certificationType=" + certificationType
				+ ", startDate=" + startDate + ", completeDate=" + completeDate + ", certificationStatus="
				+ certificationStatus + "]";
	}
	public CertificationEntity(int certificationId, String certificationName, String certificationDesc,
			String certificationType, Date startDate, Date completeDate, String certificationStatus) {
		//super();
		this.certificationId = certificationId;
		this.certificationName = certificationName;
		this.certificationDesc = certificationDesc;
		this.certificationType = certificationType;
		this.startDate = startDate;
		this.completeDate = completeDate;
		this.certificationStatus = certificationStatus;
	}
	public CertificationEntity() {
		//super();
	}
    
	
}
