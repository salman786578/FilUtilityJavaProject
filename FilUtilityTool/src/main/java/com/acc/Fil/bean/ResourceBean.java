package com.acc.Fil.bean;

import java.util.Date;

public class ResourceBean {
    
	private int resourceId;
	private int filId;
	private int accentureId;
	private Date filJoiningDate;
	private Date accentureJoiningDate;
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
	@Override
	public String toString() {
		return "ResourceBean [resourceId=" + resourceId + ", filId=" + filId + ", accentureId=" + accentureId
				+ ", filJoiningDate=" + filJoiningDate + ", accentureJoiningDate=" + accentureJoiningDate + "]";
	}
	

}
