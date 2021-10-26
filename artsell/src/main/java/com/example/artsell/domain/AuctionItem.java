package com.example.artsell.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AuctionItem implements Serializable {
	private String userId;
	private String itemId;
	private int myPrice;
	private int state;
	private Date deadline;
	private String picture;
	private int bestPrice;
	private String itemName;
	
	//니영 생성자 추가
	public AuctionItem() {}

	public AuctionItem(String userId, String itemId, int myPrice, int state, Date deadline, String picture,
			int bestPrice,  String itemName) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.myPrice = myPrice;
		this.state = state;
		this.deadline = deadline;
		this.picture = picture;
		this.bestPrice = bestPrice;
		this.itemName = itemName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getMyPrice() {
		return myPrice;
	}

	public void setMyPrice(int myPrice) {
		this.myPrice = myPrice;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(int bestPrice) {
		this.bestPrice = bestPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
}
