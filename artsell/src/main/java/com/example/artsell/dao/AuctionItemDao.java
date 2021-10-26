package com.example.artsell.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;

public interface AuctionItemDao {
	AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId) throws DataAccessException;


	List<AuctionItem> getBuyersByItemId(String itemId) throws DataAccessException;
	
	List<AuctionItem> getBuyers(String itemId) throws DataAccessException;

	List<AuctionItem> getAllAuctionItemByUserId(String userId) throws DataAccessException;

	List<AuctionItem> getAuctionItem(String userId) throws DataAccessException;

	int calcBestPrice(String itemId) throws DataAccessException;

	void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException;

	void updatePrice(String userId, String itemId, int price) throws DataAccessException;
	
	void addPrice(String userId, String itemId, int price) throws DataAccessException;
	
	void updateItemBestPrice(String itemId, int price) throws DataAccessException;

	void deleteAuctionItem(String userId, String itemId) throws DataAccessException;
	
	void deleteAutionItemById(String itemId) throws DataAccessException;

	List<AuctionItem> getAuctionedItem(String userId) throws DataAccessException;

	List<AuctionItem> getOrderedItem(String userId) throws DataAccessException;

	List<AuctionItem> countAuctionJoinList(String userId) throws DataAccessException;

	void changeState(String userId, String itemId, int state) throws DataAccessException;

	int isNewUserPrice(String userId, String itemId) throws DataAccessException;
	
	List<AuctionItem> getItemListByAuctionItem(String userId) throws DataAccessException;
	
	List<AuctionedItem> getItemListByAuctionedItem(String userId) throws DataAccessException;

	void bid(int bestPrice, String itemId) throws DataAccessException;
	
	List<AuctionItem> isAuctioning(String itemId) throws DataAccessException;
	
	List<Integer> getItemState(String itemId) throws DataAccessException;
	
	AuctionedItem getAuctionedItemByItemId_SellerId(String itemId) throws DataAccessException;

	AuctionedItem getAuctionedItemByItemId_BuyerId(String itemId) throws DataAccessException;

	void deleteUser(String userId) throws DataAccessException;
	
	boolean isAuctioningQuit(String userId) throws DataAccessException;

	int checkBid(String itemId) throws DataAccessException;
	
	int isAuctionItemByItemIdUserId(String itemId, String userId) throws DataAccessException;
}
