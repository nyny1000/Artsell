package com.example.artsell.controller;

import org.springframework.beans.support.PagedListHolder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes({"category", "itemList"})
public class ViewCategoryController { 
	private ArtSellFacade artSell;

	@Autowired
	public void setArtSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}
	
	@ModelAttribute("category")
	public Category setSessionInit() {
		return new Category();
	}
	
	@RequestMapping("/shop/viewCategory")
	public String handleRequest(@RequestParam("categoryId") String categoryId, ModelMap model) throws Exception
	{
		Category category = this.artSell.getCategory(categoryId);
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.artSell.getItemListByCategory(categoryId));
		itemList.setPageSize(5);
		//itemList.setPageSize(1);
		model.put("category", category);
		model.put("itemList", itemList);
		List<String> artistList = new ArrayList<String>(this.artSell.getArtistList());
		model.put("artistList", artistList);
		//return "tiles/itemList";
		return "itemList";
	}
	
	@RequestMapping("/shop/viewCategory2")
	public String handleRequest2(@RequestParam("page") String page, @ModelAttribute("category") Category category,
			@ModelAttribute("itemList") PagedListHolder<Item> itemList, BindingResult result, ModelMap model) throws Exception
	{
		if (category == null || itemList == null) {
			throw new IllegalStateException("cannot find pre-loaded category and item list");
		}
		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		}
		List<String> artistList = new ArrayList<String>(this.artSell.getArtistList());
		model.put("artistList", artistList);
		//return "tiles/itemList";
		return "itemList";
	}
}
