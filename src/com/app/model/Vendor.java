package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VenTab")
public class Vendor {

	@Id
	@Column(name = "Vid")
	private int venId;

	@Column(name = "vName", length = 20)
	private String venName;

	@Column(name = "vCode", length = 20)
	private String venCode;

	@Column(name = "vType", length = 20)
	private String venType;

	@Column(name = "vAddrs", length = 25)
	private String venAddrs;

	@Column(name = "vIdType", length = 20)
	private String venIdType;

	@Column(name = "vIdNum", length = 20)
	private String venIdNum;

	@Column(name = "vDsc", length = 30)
	private String venDsc;

	@ManyToOne
	@JoinColumn(name = "locIdFk")
	private Location loc; // HAS-A

	public Vendor() {
		// default
	}

	public Vendor(int venId) {
		this.venId = venId;
	}

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenCode() {
		return venCode;
	}

	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}

	public String getVenType() {
		return venType;
	}

	public void setVenType(String venType) {
		this.venType = venType;
	}

	public String getVenAddrs() {
		return venAddrs;
	}

	public void setVenAddrs(String venAddrs) {
		this.venAddrs = venAddrs;
	}

	public String getVenIdType() {
		return venIdType;
	}

	public void setVenIdType(String venIdType) {
		this.venIdType = venIdType;
	}

	public String getVenIdNum() {
		return venIdNum;
	}

	public void setVenIdNum(String venIdNum) {
		this.venIdNum = venIdNum;
	}

	public String getVenDsc() {
		return venDsc;
	}

	public void setVenDsc(String venDsc) {
		this.venDsc = venDsc;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venCode="
				+ venCode + ", venType=" + venType + ", venAddrs=" + venAddrs
				+ ", venIdType=" + venIdType + ", venIdNum=" + venIdNum
				+ ", venDsc=" + venDsc + ", loc=" + loc + "]";
	}

}
