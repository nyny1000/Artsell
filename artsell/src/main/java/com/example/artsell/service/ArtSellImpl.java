package com.example.artsell.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.artsell.dao.AccountDao;
import com.example.artsell.dao.AuctionItemDao;
import com.example.artsell.dao.CategoryDao;
import com.example.artsell.dao.InterestingItemDao;
import com.example.artsell.dao.ItemDao;
import com.example.artsell.dao.OrderDao;
import com.example.artsell.domain.Account;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;
import com.example.artsell.domain.Order;

@Service
@Transactional
public class ArtSellImpl implements ArtSellFacade {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private InterestingItemDao interestingItemDao;
	@Autowired
	private AuctionItemDao auctionItemDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ThreadPoolTaskScheduler scheduler;

	//ny수정
	@Override
	public Account getAccount(String userId, String password) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(userId, password);
	}
	
	@Override
	public Account getAccount(String userId) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(userId);
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.insertAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.updateAccount(account);
	}

	@Override
	public List<String> getUsernameList() {
		// TODO Auto-generated method stub
		return accountDao.getUsernameList();
	}
	
	@Override
	@Transactional
	public void deleteAccount(String userId) {
		interestingItemDao.deleteAll(userId);
		//auctionItemDao.deleteUser(userId);
		accountDao.deleteAccount(userId);
	}
	
	@Override
	public List<Account> viewAccountList() {
		return accountDao.viewAccountList();
	} 
	//-- ny수정.

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryList();
	}

	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(categoryId);
	}

	@Override
	public List<Item> getItemListByProduct(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(String itemId) {
		// TODO Auto-generated method stub
		return itemDao.getItem(itemId);
	}
	
	@Override
	public void insertItem(ItemForm item) {
		itemDao.insertItem(item);
	}
	
	@Override
	public void deleteItem(String userId, String itemId) {
		itemDao.deleteItem(userId, itemId);
	}
	
	@Override
	public List<Item> getMyItemList(String userId) {
		List<Item> itemList = itemDao.getMyItemList(userId);
		for (int i = 0; i < itemList.size(); i++) {
			String itemId = itemList.get(i).getItemId();
			List<Integer> state = auctionItemDao.getItemState(itemId);
			if (state.contains(5)) {
				itemList.get(i).setState(5);
			} else if (state.contains(1)) {
				itemList.get(i).setState(1);
			} else if (state.contains(2)) {
				itemList.get(i).setState(2);
			} else {
				itemList.get(i).setState(0);
			}
		}
		
		return itemList;
	}

	@Override
	public boolean isItemInStock(String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOrder(String itemId, String userId) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(itemId, userId);
	}
	
	@Override
	public void SaveAuctionedItem(String itemId, int myPrice, String userId, String address1, String address2, Date sellDate) {
		orderDao.SaveAuctionedItem(itemId, myPrice, userId, address1, address2, sellDate);
	}
	
	@Override
	public void updateAuctionedState(String itemId, String userId) {
		orderDao.updateAuctionedState(itemId, userId);
	}

	@Override
	public List<Order> getOrdersByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemListByCategory(String categoryId) {
		// TODO Auto-generated method stub
		return itemDao.getItemListByCategory(categoryId);
	}

	@Override
	public List<String> getArtistList() {
		// TODO Auto-generated method stub
		return itemDao.getArtistList();
	}
	
	@Override
	public List<Item> getInterestingItemList(String userId) {
		return interestingItemDao.getInterestingItemList(userId);
	}
	
	@Override
	public List<Item> getPastInterestingItemList(String userId) {
		return interestingItemDao.getPastInterestingItemList(userId);
	}
	
	@Override
	public void insertInterestingItem(String userId, String itemId) {
		interestingItemDao.insertInterestingItem(userId, itemId);
	}
	
	@Override
	public void deleteInterestingItem(String userId, String itemId) {
		interestingItemDao.deleteInterestingItem(userId, itemId);
	}
	
	@Override
	public int containsInterestingItem(String userId, String itemId) {
		return interestingItemDao.containsInterestingItem(userId, itemId);
	}

	@Override
	public List<Item> searchItemList(String keywords, String artist, String categoryId) {
		// TODO Auto-generated method stub
		return itemDao.searchItemList(keywords, artist, categoryId);
	}
	
	@Override
	public List<AuctionItem> isAuctioning(String itemId) {
		return auctionItemDao.isAuctioning(itemId);
	}

	@Override
	public List<AuctionItem> getBuyersByItemId(String itemId) {
		// TODO Auto-generated method stub
		return auctionItemDao.getBuyersByItemId(itemId);
	}
	
	@Override
	public List<AuctionItem> getBuyers(String itemId) {
		// TODO Auto-generated method stub
		return auctionItemDao.getBuyers(itemId);
	}

	@Override
	public int getItemPrice(String itemId) {
		return itemDao.getItemPrice(itemId);
	}
	
	@Override
	public void updateReload(String itemId, int minPrice, Date deadline, String userId) {
		itemDao.updateReload(itemId, minPrice, deadline, userId);
	}


	public void updatePrice(String userId, String itemId, int price) {
		auctionItemDao.updatePrice(userId, itemId, price);
	}

	@Override
	public void addPrice(String userId, String itemId, int price) {
		auctionItemDao.addPrice(userId, itemId, price);
	}
	
	@Override
	public int calcBestPrice(String itemId) {
		return auctionItemDao.calcBestPrice(itemId);
	}
	
	@Override
	public void updateItemBestPrice(String itemId, int price) {
		auctionItemDao.updateItemBestPrice(itemId, price);
	}
	
	@Override
	public int isNewUserPrice(String userId, String itemId) {
		return auctionItemDao.isNewUserPrice(userId, itemId);
	}
	
	@Override
	public List<AuctionItem> countAuctionJoinList(String itemId) {
		return auctionItemDao.countAuctionJoinList(itemId);
	}
	
	@Override
	public void deleteAuctionItem(String userId, String itemId) {
		auctionItemDao.deleteAuctionItem(userId, itemId);;
	}
	
	@Override
	public void deleteAutionItemById(String itemId) {
		auctionItemDao.deleteAutionItemById(itemId);
	}
	@Override
	public void changeState(String userId, String itemId, int state) {
		auctionItemDao.changeState(userId, itemId, state);
	}
	
	@Override
	public List<AuctionItem> getItemListByAuctionItem(String userId) {
		return auctionItemDao.getItemListByAuctionItem(userId);
	}
	
	@Override
	public List<AuctionedItem> getItemListByAuctionedItem(String userId) {
		return auctionItemDao.getItemListByAuctionedItem(userId);
	}
	
	@Override
	public void changeDeadline(Date deadline, String itemId) {
		itemDao.changeDeadline(deadline, itemId);
	}
	
	public void auctionScheduler(Date closingTime, String itemId) {
		// TODO Auto-generated method stub
		Runnable updateTableRunner = new Runnable() {
			@Override
			public void run() {
				bidSuccess(itemId);
			}
		};
		
		System.out.println("scheduler");
		scheduler.schedule(updateTableRunner, closingTime);
		System.out.println("updateTableRunner has been scheduled to execute at " + closingTime);
	}

	@Override
	public void insertAuctionItem(AuctionItem auctionItem) {
		// TODO Auto-generated method stub
		auctionItemDao.insertAuctionItem(auctionItem);
	}
	
	@Override
	public void bidSuccess(String itemId) {
		Date curTime = new Date();
		
		if(itemDao.isItemExist(itemId) > 0) {
			if (itemDao.isCloseBid(itemId, curTime)) {
				if (auctionItemDao.getBuyersByItemId(itemId).isEmpty()) {
					//유찰
					String sellerId = itemDao.getItem(itemId).getUserId();
					auctionItemDao.changeState(sellerId, itemId, 5);
				} else if (auctionItemDao.checkBid(itemId) > 0) {				//해당 옥션 아이템에 낙찰 상태를 바꾸는 것.
					int bestPrice = auctionItemDao.calcBestPrice(itemId);
					auctionItemDao.bid(bestPrice, itemId);
				}
			}
		}
	}
	
	@Override
	public AuctionedItem getAuctionedItemByItemId_SellerId(String itemId) {
		
		return auctionItemDao.getAuctionedItemByItemId_SellerId(itemId);
	}
	
	@Override
	public AuctionedItem getAuctionedItemByItemId_BuyerId(String itemId) {
		
		return auctionItemDao.getAuctionedItemByItemId_BuyerId(itemId);
	}
	@Override
	public int getItemState(String itemId) {
		List<Integer> state = auctionItemDao.getItemState(itemId);
		if (state.contains(5)) {
			return 5;
		} else if (state.contains(1)) {
			return 1;
		} else if (state.contains(2)) {
			return 2;
		} else {
			return 0;
		}
	}
	
	@Override
	public List<Account> getUserList() {
		return accountDao.getUserList();
	}

	
	@Override
	public boolean isAuctioningQuit(String userId) {
		return auctionItemDao.isAuctioningQuit(userId);
	}


	@Override
	public void initScheduler() {
		// TODO Auto-generated method stub
		Date curTime = new Date();
		List<Item> notEndedAuctionItem = itemDao.getNotEndedAuctionItem(curTime);

		for (Item item : notEndedAuctionItem) {
			Date deadline = item.getDeadline();
			String itemId = item.getItemId();
			auctionScheduler(deadline, itemId);
		}
		
		List<Item> EndedAuctionItem = itemDao.getEndedAuctionItem(curTime);
		
		for (Item item : EndedAuctionItem) {
			bidSuccess(item.getItemId());
		}
	}
	
	@Override
	public int isAuctionItemByItemIdUserId(String itemId, String userId) {
		return auctionItemDao.isAuctionItemByItemIdUserId(itemId, userId);
	}
}
