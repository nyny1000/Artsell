package com.example.artsell.dao.mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.artsell.dao.ItemDao;
import com.example.artsell.dao.mybatis.mapper.AuctionItemMapper;
import com.example.artsell.dao.mybatis.mapper.InterestingItemMapper;
import com.example.artsell.dao.mybatis.mapper.ItemMapper;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;

@Repository
public class MybatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private InterestingItemMapper interestingItemMapper;
	@Autowired
	private AuctionItemMapper auctionItemMapper;
	
	public Item getItem(String itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}

	public List<Item> searchItemList(String keywords, String artist, String categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		if ("".equals(keywords)) {
			keywords = null;
		} else if (keywords != null) {
			keywords = "%" + keywords.toLowerCase() + "%";
		}
		if (artist.equals("all")) {
			artist = null;
		} else if (artist != null) {
			artist = "%" + artist.toLowerCase() + "%";
		}
		if ("".equals(categoryId)) {
			categoryId = null;
		}
		System.out.println("keywords: " + keywords + " artist: " + artist + " categoryId " + categoryId);
		return itemMapper.searchItemList(keywords, artist, categoryId);
	}

	public List<Item> getItemListByCategory(String categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getItemListByCategory(categoryId);
	}

	public List<Item> getItemListByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getItemListByUserId(userId);
	}

	public List<Item> getMyItemList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getMyItemList(userId);
	}
	
	//경매참여자가 한명도 없을때만 취소 가능
	public void deleteItem(String userId, String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.deleteAutionItemById(itemId);
		interestingItemMapper.deleteAllInterestingItem(itemId);
		itemMapper.deleteItem(itemId);
	}

	public void insertItem(ItemForm item) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.insertItem(item);
	}

	public void updateItem(String itemId, String price) throws DataAccessException {
		// TODO Auto-generated method stub
		itemMapper.updateItemPrice(itemId, price);
	}

	//유찰때
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateReload(String itemId, int minPrice, Date deadline, String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("itemId: " + itemId);
		auctionItemMapper.changeState(userId, itemId, 4);
		itemMapper.updateReload(itemId, minPrice, deadline, userId);
	}
	
	public void changeDeadline(Date deadline, String itemId) {
		itemMapper.changeDeadline(deadline, itemId);
	}
	
	/* Inner Classes */
	public static class ItemSearch {

		private List<String> keywordList = new ArrayList<String>();

		public ItemSearch(String keywords) {
			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
			while (splitter.hasMoreTokens()) {
				this.keywordList.add("%" + splitter.nextToken() + "%");
			}
		}
		public List<String> getKeywordList() {
			return keywordList;
		}
	}

	@Override
	public List<String> getArtistList() throws DataAccessException {
		// TODO Auto-generated method stub
		return itemMapper.getArtistList();
	}
	
	public int isAuctioning(String itemId) throws DataAccessException {
		return itemMapper.isAuctioning(itemId);
	}
	
	public int getItemPrice(String itemId) throws DataAccessException {
		return itemMapper.getItemPrice(itemId);
	}
	
	public boolean isCloseBid(String itemId, Date curTime) throws DataAccessException {
		System.out.println("isCloseBid: " + itemMapper.isCloseBid(itemId, curTime));
		if (itemMapper.isCloseBid(itemId, curTime) == 0) {
			return false;
		} else {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			return true;
		}
	}
	
	public int isItemExist(String itemId) throws DataAccessException {
		return itemMapper.isItemExist(itemId);
	}

	@Override
	public List<Item> getNotEndedAuctionItem(Date curTime) {
		// TODO Auto-generated method stub
		return itemMapper.getNotEndedAuctionItem(curTime);
	}

	@Override
	public List<Item> getEndedAuctionItem(Date curTime) {
		// TODO Auto-generated method stub
		return itemMapper.getEndedAuctionItem(curTime);
	}
}
