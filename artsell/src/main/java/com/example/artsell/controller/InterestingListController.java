package com.example.artsell.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes({"userSession", "interestList","pastInterestingList"})
public class InterestingListController {

	@Autowired
	//private PetStoreFacade artSell;
	private ArtSellFacade artSell;

	@RequestMapping("/interesting/list") 
	public String viewInterestingList(
			@ModelAttribute("userSession") UserSession userSession, ModelMap model, HttpSession session, SessionStatus sessionStatus) throws Exception {
		
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(
				this.artSell.getInterestingItemList(userSession.getAccount().getUserId()));
		itemList.setPageSize(3);
		
		PagedListHolder<Item> itemList2 = new PagedListHolder<Item>(
				this.artSell.getPastInterestingItemList(userSession.getAccount().getUserId()));
		itemList2.setPageSize(3);
		model.put("interestList", itemList);	//handleRequest(page, itemList);
		model.put("pastInterestingList", itemList2);
		
		//System.out.println(date1);
		return "myInterestingList";
//		System.out.println(userSession.getAccount().getUserId());
//		List<Item> itemList = artSell.getInterestingItemList(userSession.getAccount().getUserId());
//		//itemList.setPageSize(5);
//		//handleRequest(page, itemList);
//		System.out.println(itemList.get(0).getItemId());
		//return new ModelAndView("myInterestingList", "interestList", itemList.);
	}
	
	@RequestMapping("/interesting/add")
	public String addItemToInterestingList(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("itemId") String itemId, RedirectAttributes redirect) {
		String userId =userSession.getAccount().getUserId();
		
		int key = artSell.isAuctionItemByItemIdUserId(itemId, userId);
		if (key == 0) {
			artSell.insertInterestingItem(userId, itemId);
		}
		redirect.addAttribute("itemId", itemId);
		return "redirect:/shop/viewItem";
	}
	
	@RequestMapping("/interesting/delete2")
	public String deleteItemFromInterestingList2(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("itemId") String itemId, RedirectAttributes redirect) {
		String userId = userSession.getAccount().getUserId();
		artSell.deleteInterestingItem(userId, itemId);
		redirect.addAttribute("itemId", itemId); 
		return "redirect:/shop/viewItem";
	}
	
	@RequestMapping("/interesting/delete")
	public String deleteItemFromInterestingList(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("interItemId") String itemId) {
		String userId = userSession.getAccount().getUserId();
		artSell.deleteInterestingItem(userId, itemId);

		return "redirect:/interesting/list";
	}

//	
//	private void handleRequest(String page, PagedListHolder<Item> itemList) throws Exception {
//
//		if ("next".equals(page)) {
//			itemList.nextPage();
//		} else if ("previous".equals(page)) {
//			itemList.previousPage();
//		}
//	} 
//	
	@RequestMapping("/interesting/list2")
	public String handleRequest2(
			@RequestParam("page") String page, 
			@ModelAttribute("interestList") PagedListHolder<Item> itemList,
			BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		
		return "myInterestingList";
	} 
	
	@RequestMapping("/interesting/list3")
	public String handleRequest3(
			@RequestParam("page") String page, 
			@ModelAttribute("pastInterestingList") PagedListHolder<Item> itemList,
			BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		
		return "myInterestingList";
	} 
}
