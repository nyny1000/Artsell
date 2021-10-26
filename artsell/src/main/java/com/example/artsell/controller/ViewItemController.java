package com.example.artsell.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class ViewItemController { 

	private ArtSellFacade artSell;

	@Autowired
	public void setartSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}

	@RequestMapping("/shop/viewItem")
	public String handleRequest(@RequestParam("itemId") String itemId, 
			@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {

		Item item = this.artSell.getItem(itemId);
		model.put("item", item);
		Category cate = this.artSell.getCategory(item.getCategoryId());
		
		model.put("cateName", cate.getName());
		model.put("isInterested", artSell.containsInterestingItem(userSession.getAccount().getUserId(), itemId));
		
		return "paintingDetail";
	}
}
