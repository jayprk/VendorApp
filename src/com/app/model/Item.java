package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemTab")
public class Item {

	@Id
	@Column(name = "Iid")
	private int itemId;

	@Column(name = "iName", length = 20)
	private String itemName;

	@Column(name = "iCode", length = 20)
	private String itemCode;

	@Column(name = "iMRP", length = 10, precision = 2)
	private double itemMRP;

	@Column(name = "idiscount", length = 10, precision = 2)
	private double maxDiscount;

	@Column(name = "iMFG", length = 20)
	private String itemMFG;

	@ElementCollection
	@CollectionTable(name = "item_Models", joinColumns = @JoinColumn(name = "itemFK"))
	@Column(name = "iModels", length = 20)
	private List<String> itemModels;

	@ManyToOne
	@JoinColumn(name = "custIdFk")
	private Customer cust;
	
	@Column(name="custId",length=10)
	private int custId;

	public Item() {
		// no code
	}

	public Item(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getItemMRP() {
		return itemMRP;
	}

	public void setItemMRP(double itemMRP) {
		this.itemMRP = itemMRP;
	}

	public double getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public String getItemMFG() {
		return itemMFG;
	}

	public void setItemMFG(String itemMFG) {
		this.itemMFG = itemMFG;
	}

	public List<String> getItemModels() {
		return itemModels;
	}

	public void setItemModels(List<String> itemModels) {
		this.itemModels = itemModels;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemCode=" + itemCode + ", itemMRP=" + itemMRP
				+ ", maxDiscount=" + maxDiscount + ", itemMFG=" + itemMFG
				+ ", itemModels=" + itemModels + ", cust=" + cust + ", custId="
				+ custId + "]";
	}

	

}
