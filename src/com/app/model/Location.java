package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LocTab")
public class Location {
	@Id
	@Column(name="LId")
	private int locId;
	
	@Column(name="LName")
	private String locName;
	
	@Column(name="LType")
	private String locType;
	
	@Column(name="LCode")
	private String locCode;
	
	@Column(name="LDesc")
	private String locDesc;
	
	
	
	public Location() {
		super();		
	}	
	
	public Location(int locId) {
		this.locId = locId;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getLocDesc() {
		return locDesc;
	}

	public void setLocDesc(String locDesc) {
		this.locDesc = locDesc;
	}

	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName
				+ ", locType=" + locType + ", locCode=" + locCode
				+ ", locDesc=" + locDesc + "]";
	}
	
	
	
}
