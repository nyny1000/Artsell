package com.example.artsell.service;

import java.util.Date;
import java.util.List;

import com.example.artsell.domain.Account;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;
import com.example.artsell.domain.Order;



public interface ArtSellFacade {
	
	//--ny id로 수정.
	Account getAccount(String userId);

	Account getAccount(String userId, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);
	
	void deleteAccount(String userId);

	List<String> getUsernameList();
	
	List<Account> viewAccountList();
	//--ny


	List<Category> getCategoryList();

	Category getCategory(String categoryId);

	List<Item> searchItemList(String keywords, String artist, String categoryId);
	
	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);
	
	void insertItem(ItemForm item);
	
	void deleteItem(String userId, String itemId);
	
	List<Item> getMyItemList(String userId);

	boolean isItemInStock(String itemId);


	void insertOrder(Order order);

	Order getOrder(String itemId, String userId);
	
	void SaveAuctionedItem(String itemId, int myPrice, String userId, String address1, String address2, Date sellDate);
	
	void updateAuctionedState(String itemId, String userId);

	List<Order> getOrdersByUsername(String username);
	
	List<Item> getItemListByCategory(String categoryId);
	
	List<String> getArtistList();
	
	List<Item> getInterestingItemList(String userId);
	
	List<Item> getPastInterestingItemList(String userId);
	
	void insertInterestingItem(String userId, String itemId);
	
	void deleteInterestingItem(String userId, String itemId);
	
	int containsInterestingItem(String userId, String itemId);
	
	public List<AuctionItem> isAuctioning(String itemId);
	
	List<AuctionItem> getBuyersByItemId(String itemId);
	
	List<AuctionItem> getBuyers(String itemId);
	
	int getItemPrice(String itemId);
	
	void updateReload(String itemId, int minPrice, Date deadline, String userId);
	
	void changeDeadline(Date deadline, String itemId);

	void updatePrice(String userId, String itemId, int price);

	void updateItemBestPrice(String itemId, int price);
	
	int isNewUserPrice(String userId, String itemId);
	
	void auctionScheduler(Date closingTime, String itemId);
	
	void addPrice(String userId, String itemId, int price);
	
	int calcBestPrice(String itemId);
	
	void deleteAuctionItem(String userId, String itemId);
	
	void deleteAutionItemById(String itemId);
	
	List<AuctionItem> countAuctionJoinList(String itemId);
	
	void changeState(String userId, String itemId, int state);
	
	List<AuctionItem> getItemListByAuctionItem(String userId);
	
	List<AuctionedItem> getItemListByAuctionedItem(String userId);
	
	void insertAuctionItem(AuctionItem auctionItem);
	
	void bidSuccess(String itemId);

	int getItemState(String itemId);
	
	AuctionedItem getAuctionedItemByItemId_SellerId(String itemId);
	
	AuctionedItem getAuctionedItemByItemId_BuyerId (String itemId);
	
	List<Account> getUserList();
	
	boolean isAuctioningQuit(String userId);

	void initScheduler();
	
	int isAuctionItemByItemIdUserId(String itemId, String userId);
}
