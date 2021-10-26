package com.example.artsell.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.AuctionItemDao;
import com.example.artsell.dao.mybatis.mapper.AuctionItemMapper;
import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;

@Repository
public class MybatisAuctionItemDao implements AuctionItemDao {
	@Autowired
	private AuctionItemMapper auctionItemMapper;

	@Override
	public List<AuctionItem> getBuyersByItemId(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getBuyersByItemId(itemId);
	}
	
	@Override
	public List<AuctionItem> getBuyers(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getBuyers(itemId);
	}

	@Override
	public List<AuctionItem> getAllAuctionItemByUserId(String userId) throws DataAccessException {
		return auctionItemMapper.getAllAuctionItemByUserId(userId);
	}

	@Override
	public AuctionItem getAuctionItemByItemIdAndUserId(String itemId, String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getAuctionItemByItemIdAndUserId(itemId, userId);
	}

	@Override
	public List<AuctionItem> getAuctionItem(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getAuctionItem(userId);
	}

	@Override
	public int calcBestPrice(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.calcBestPrice(itemId);
	}

	@Override
	public void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.insertAuctionItem(auctionItem);

	}

	@Override
	public void updatePrice(String userId, String itemId, int price) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.updatePrice(userId, itemId, price);
	}

	@Override
	public void updateItemBestPrice(String itemId, int price) throws DataAccessException {
		auctionItemMapper.updateItemBestPrice(itemId, price);
	}
	
	@Override
	public void deleteAuctionItem(String userId, String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.deleteAuctionItem(userId, itemId);
	}
	
	@Override
	public void deleteAutionItemById(String itemId) throws DataAccessException {
		auctionItemMapper.deleteAutionItemById(itemId);
	}
	
	@Override
	public void addPrice(String userId, String itemId, int price) throws DataAccessException {
		auctionItemMapper.addPrice(userId, itemId, price);
	}

	@Override
	public int isNewUserPrice(String userId, String itemId) throws DataAccessException {
		return auctionItemMapper.isNewUserPrice(userId, itemId);
	}
	
	@Override
	public List<AuctionItem> getAuctionedItem(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getAuctionItem(userId);
	}

	@Override
	public List<AuctionItem> getOrderedItem(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.getOrderedItem(userId);
	}

	@Override
	public List<AuctionItem> countAuctionJoinList(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.countAuctionJoinList(itemId);
	}

	@Override
	public void changeState(String userId, String itemId, int state) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.changeState(userId, itemId, state);
	}
	
	@Override
	public List<AuctionItem> getItemListByAuctionItem(String userId) throws DataAccessException {
		return auctionItemMapper.getItemListByAuctionItem(userId);
	}
	
	@Override
	public List<AuctionedItem> getItemListByAuctionedItem(String userId) throws DataAccessException {
		return auctionItemMapper.getItemListByAuctionedItem(userId);
	}

	@Override
	public void bid(int bestPrice, String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionItemMapper.bidSuccess(bestPrice, itemId);
		auctionItemMapper.bidFail(bestPrice, itemId);
	}
	
	@Override
	public List<AuctionItem> isAuctioning(String itemId) throws DataAccessException {
		return auctionItemMapper.isAuctioning(itemId);
	}

	@Override
	public List<Integer> getItemState(String itemId) throws DataAccessException {
		return auctionItemMapper.getItemState(itemId);
	}
	
	@Override
	public AuctionedItem getAuctionedItemByItemId_SellerId(String itemId) throws DataAccessException {
		return auctionItemMapper.getAuctionedItemByItemId_SellerId(itemId);
	}
	
	@Override
	public AuctionedItem getAuctionedItemByItemId_BuyerId(String itemId) throws DataAccessException {
		return auctionItemMapper.getAuctionedItemByItemId_BuyerId(itemId);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		auctionItemMapper.deleteAuctionQuit(userId);
		auctionItemMapper.deleteAuctionedQuit(userId);
		auctionItemMapper.deleteItemQuit(userId);
		
	}
	
	@Override
	public boolean isAuctioningQuit(String userId) {
		if(auctionItemMapper.isAuctioningBuyer(userId) > 0) {
			return true;
		}
		if(auctionItemMapper.isAuctioningSeller(userId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int checkBid(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionItemMapper.checkBid(itemId);
	}
	
	@Override
	public int isAuctionItemByItemIdUserId(String itemId, String userId) throws DataAccessException {
		return auctionItemMapper.isAuctionItemByItemIdUserId(itemId, userId);
	}
}
