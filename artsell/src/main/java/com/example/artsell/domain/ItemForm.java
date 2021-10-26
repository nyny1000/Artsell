package com.example.artsell.domain;

import java.util.Date;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;;

public class ItemForm {
	private String itemId;
	
	@NotBlank
	private String itemName;
	
	//@NotBlank
	@Min(0)
	private int minPrice;
	private int bestPrice;
	
	//@NotBlank
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deadline;
	
	@NotBlank
	private String description;
	
	private MultipartFile picturefile;
	//@NotNull
	private String picture;
//	@NotNull
//	private MultipartFile picture;
	
	@NotBlank
	private String artist;
	@NotBlank
	private String categoryId;
	private String userId;
	
	
	
//	public String getDd() {
//		return dd;
//	}
//	public void setDd(String dd) {
//		this.dd = dd;
//	}
	public MultipartFile getPicturefile() {
		return picturefile;
	}
	public void setPicturefile(MultipartFile picturefile) {
		this.picturefile = picturefile;
	}
	
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

//	public MultipartFile getPicture() {
//		return picture;
//	}
//	
//	public void setPicture(MultipartFile picture) {
//		this.picture = picture;
//	}
	public String getPicture() {
		return picture;
	}//연제 테스트
	public void setPicture(String filePath) {
		this.picture = filePath;
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
	
	
  
}
