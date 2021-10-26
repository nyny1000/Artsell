package com.example.artsell.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;

@Mapper
public interface ItemMapper {
	Item getItem(String itemId) throws DataAccessException;
	
	List<Item> searchItemList(String keywords, String artist, String categoryId) throws DataAccessException;
	
	List<Item> getItemListByCategory(String categoryId) throws DataAccessException;
	
	List<Item> getItemListByUserId(String userId) throws DataAccessException;
	
	List<Item> getMyItemList(String userId) throws DataAccessException;
	
	List<String> getArtistList() throws DataAccessException;
	
	void deleteItem(String itemId) throws DataAccessException;
	
	void insertItem(ItemForm item) throws DataAccessException;
	
	void updateItemPrice(String itemId, String price) throws DataAccessException;
	
	void updateReload(String itemId, int minPrice, Date deadline, String userId) throws DataAccessException;
	
	int isAuctioning(String itemId) throws DataAccessException;
	
	int getItemPrice(String itemId) throws DataAccessException;
	
	int isCloseBid(String itemId, Date curTime) throws DataAccessException;
	
	void changeDeadline(Date deadline, String itemId) throws DataAccessException;
	
	int isItemExist(String itemId) throws DataAccessException;

	List<Item> getNotEndedAuctionItem(Date curTime);

	List<Item> getEndedAuctionItem(Date curTime);
}
