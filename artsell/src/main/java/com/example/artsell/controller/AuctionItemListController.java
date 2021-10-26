package com.example.artsell.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes({"userSession","itemList1","itemList2", "key"})
public class AuctionItemListController {
	@Autowired
	private ArtSellFacade artSell;
	
	@RequestMapping("/stateTypeSelect")
	public String selectStateType(@ModelAttribute("userSession") UserSession userSession,
			HttpServletRequest request, ModelMap model) {
		
		PagedListHolder<AuctionItem> itemList = new PagedListHolder<AuctionItem>(
				this.artSell.getItemListByAuctionItem(userSession.getAccount().getUserId()));
		
		int key = Integer.parseInt(request.getParameter("stateT"));
		List<AuctionItem> list = new ArrayList<AuctionItem>();
		
		System.out.println(key);
		
		if (key != 2) {
			for (AuctionItem item : itemList.getSource()) {
				System.out.println(item.getState() + item.getItemId());
				if (item.getState() == key) {
					list.add(item);
				}
			}
			itemList.setSource(list);
			System.out.println("_______");
			for (AuctionItem item : itemList.getSource()) {
				System.out.println("앙"+item.getState() + item.getItemId());
			}
		}
		
		itemList.setPageSize(3);
		model.put("itemList1", itemList);
		model.put("key", key);

		return "myAuctionList";
	}
	
	@RequestMapping("/auction/list")
	public String viewAuctionItemList(@ModelAttribute("userSession") UserSession userSession, ModelMap model, 
			HttpServletRequest request) {
		int key = 2;
		PagedListHolder<AuctionItem> itemList1 = new PagedListHolder<AuctionItem>(
				this.artSell.getItemListByAuctionItem(userSession.getAccount().getUserId()));
		
		itemList1.setPageSize(3);

		model.put("itemList1", itemList1);
		
		//낙찰된(결제까지 다 한) 목록
		PagedListHolder<AuctionedItem> itemList2 = new PagedListHolder<AuctionedItem>(
				this.artSell.getItemListByAuctionedItem(userSession.getAccount().getUserId()));
		itemList2.setPageSize(3);
		model.put("itemList2", itemList2);
		model.put("key", key);
		return "myAuctionList";
	
	}
	
	@RequestMapping("/auction/listauction")
	public String viewAuctionItemList2(
			@RequestParam("page") String page, 
			@ModelAttribute("itemList1") PagedListHolder<Item> itemList,
			BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		
		return "myAuctionList";
	} 
	
	@RequestMapping("/auction/listauctioned")  
	public String viewAuctionItemList3(
			@RequestParam("page") String page, 
			@ModelAttribute("itemList2") PagedListHolder<Item> itemList,
			BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		
		return "myAuctionList";
	}

}
