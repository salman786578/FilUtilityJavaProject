package com.acc.Fil.bean;

import java.util.Date;

public class CertificationBean {

	private int certificationId;
	private String certificationName;
	private String certificationDesc;
	private String certificationType;
	private Date startDate;
	private Date completeDate;
	private String certificationStatus;
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
		return "CertificationBean [certificationId=" + certificationId + ", certificationName=" + certificationName
				+ ", certificationDesc=" + certificationDesc + ", certificationType=" + certificationType
				+ ", startDate=" + startDate + ", completeDate=" + completeDate + ", certificationStatus="
				+ certificationStatus + "]";
	}
	
	
}
