package com.example.artsell.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Item;

public interface InterestingItemDao {
	List<Item> getInterestingItemList(String userId) throws DataAccessException;
	
	List<Item> getPastInterestingItemList(String userId) throws DataAccessException;
	
	void insertInterestingItem(String userId, String itemId) throws DataAccessException;
	
	void deleteInterestingItem(String userId, String itemId) throws DataAccessException;
	
	int containsInterestingItem(String userId, String itemId) throws DataAccessException;

	void deleteAll(String userId);

	void deleteAllInterestingItem(String itemId);
}
