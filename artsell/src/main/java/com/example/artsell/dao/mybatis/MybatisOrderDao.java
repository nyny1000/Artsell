package com.example.artsell.dao.mybatis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.artsell.dao.OrderDao;
import com.example.artsell.dao.mybatis.mapper.AuctionItemMapper;
import com.example.artsell.dao.mybatis.mapper.OrderMapper;
import com.example.artsell.domain.Order;

@Repository
public class MybatisOrderDao implements OrderDao {
	@Autowired
	protected OrderMapper orderMapper;

	@Autowired
	protected AuctionItemMapper auctionItemMapper;

	@Transactional
	public Order getOrder(String itemId, String userId) throws DataAccessException {
		//AuctionItem auctionItem = orderMapper.getAuctionItem(itemId, userId);
		Order order = orderMapper.getOrder(itemId, userId);
	    return order;
	}
//	@Transactional
//	public void editDestination(Order order, String des) throws DataAccessException {
//		//order.setDestination(des);
//		orderMapper.editDestination(order, des);
//	}
	@Transactional
	public void SaveAuctionedItem (String itemId, int myPrice, String userId, String address1, String address2, Date sellDate) throws DataAccessException {
		orderMapper.SaveAuctionedItem(itemId, myPrice, userId, address1, address2, sellDate);
	}
	@Transactional
	public void updateAuctionedState(String itemId, String userId) throws DataAccessException {
		 
			orderMapper.updateAuctionedState(itemId, userId);
	}
}
