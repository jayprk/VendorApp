package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_tab")
public class Customer {

	@Id
	@Column(name = "cid")
	private int custId;

	@Column(name = "cname")
	private String custName;

	@Column(name = "cmail")
	private String custEmail;

	@Column(name = "ctype")
	private String custType;

	@Column(name = "cpwd")
	private String cPassword;

	@Column(name = "ctkn")
	private String custToken;

	@Column(name = "caddrs")
	private String custAddrs;

	public Customer() {
		// no code
	}

	public Customer(int custId) {
		this.custId = custId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public String getCustToken() {
		return custToken;
	}

	public void setCustToken(String custToken) {
		this.custToken = custToken;
	}

	public String getCustAddrs() {
		return custAddrs;
	}

	public void setCustAddrs(String custAddrs) {
		this.custAddrs = custAddrs;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custType=" + custType
				+ ", cPassword=" + cPassword + ", custToken=" + custToken
				+ ", custAddrs=" + custAddrs + "]";
	}

}
