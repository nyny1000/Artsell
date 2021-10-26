package com.example.artsell.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AuctionedItem implements Serializable {
	private String userId;
	private String itemName;
	private String itemId;
	private int auctionedPrice;
	private String destination1;
	private String destination2;
	private Date deadline;
	private String picture;
	private Date sellDate;
	
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
	public int getAuctionedPrice() {
		return auctionedPrice;
	}
	public void setAuctionedPrice(int auctionedPrice) {
		this.auctionedPrice = auctionedPrice;
	}
	
	
	public String getDestination1() {
		return destination1;
	}
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}
	public String getDestination2() {
		return destination2;
	}
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
}
