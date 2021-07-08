package com.acc.Fil.bean;

public class ResourceCertificationBean {

	private int resourceId;
	private int certificationId;
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}
	@Override
	public String toString() {
		return "ResourceCertificationBean [resourceId=" + resourceId + ", certificationId=" + certificationId + "]";
	}
	
}
