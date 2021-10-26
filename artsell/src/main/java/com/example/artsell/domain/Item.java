package com.example.artsell.domain;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private String itemId;
	
	@NotBlank
	private String itemName;
	
	//@NotBlank
	@Min(0)
	private int minPrice;
	private int bestPrice;
	
	@NotBlank
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deadline;
	
	//@NotBlank
	private String description;
	
	@NotBlank
	private String picture;
	
	@NotBlank
	private String artist;
	@NotBlank
	private String categoryId;
	private String userId;
	
	private int state;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getBestPrice() {
		return bestPrice;
	}
	public void setBestPrice(int bestPrice) {
		this.bestPrice = bestPrice;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
  
}
