package com.example.artsell.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Order implements Serializable {

	private String userId;
	private String name;
	private String itemName;
	private String itemId;
	private String phone;
	private String address1;
	private String address2;
	private int myPrice;
	private String credit;
	private String picture;
	private Date deadline;
	//private List<LineItem> lineItems = new ArrayList<LineItem>();
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMyPrice() {
		return myPrice;
	}
	public void setMyPrice(int myPrice) {
		this.myPrice = myPrice;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
}
