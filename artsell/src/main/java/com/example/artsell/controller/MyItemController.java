package com.example.artsell.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;
import com.example.artsell.service.ArtSellFacade;
import com.example.artsell.service.PaintRegiValidator;


@Controller
@SessionAttributes({"userSession", "myPaintList", "key"})
public class MyItemController {
	
	@Autowired
	private ArtSellFacade artSell;
	
	@ModelAttribute("cateList")
	public List<Category> kinds() {
		List<Category> cateList = artSell.getCategoryList();
//		List<String> cateNameList = new ArrayList<String>();
//		for(Category c : cateList)
//			cateNameList.add(c.getName());
		return cateList;
	}
	
	@ModelAttribute("item")
	public ItemForm create() {
		return new ItemForm();
	}
	
	@RequestMapping("/stateTypeSelect_mypaintingList")
	public String selectStateType(@ModelAttribute("userSession") UserSession userSession,
			HttpServletRequest request, ModelMap model) {
		System.out.println("들어왔다");
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(
				this.artSell.getMyItemList(userSession.getAccount().getUserId()));
		
		int key = Integer.parseInt(request.getParameter("stateT2"));
		List<Item> list = new ArrayList<Item>();
		
		System.out.println(key);
		
		if (key != 3) {
			for (Item item : itemList.getSource()) {
				System.out.println(item.getState() + item.getItemId());
				if (item.getState() == key) {
					list.add(item);
				}
			}
			itemList.setSource(list);
			System.out.println("_______");
			for (Item item : itemList.getSource()) {
				System.out.println("앙"+item.getState() + item.getItemId());
			}
		}
		
		itemList.setPageSize(5);
		model.put("myPaintList", itemList);
		model.put("key", key);

		return "myPaintingList";
	}
	
	@RequestMapping("/myitem/list")
	public String ViewMyItemList(
			@ModelAttribute("userSession") UserSession userSession, ModelMap model) throws Exception {

		PagedListHolder<Item> itemList = new PagedListHolder<Item>(
				this.artSell.getMyItemList(userSession.getAccount().getUserId()));
		itemList.setPageSize(5);
		model.put("myPaintList", itemList);
		//handleRequest(page, itemList);
		model.put("key", 3);
		return "myPaintingList";
	}
	
	@PostMapping("/myitem/add")
	public String addMyItem(@Valid @ModelAttribute("item") ItemForm item, Errors result,
			@ModelAttribute("userSession") UserSession userSession, HttpServletRequest request,
			RedirectAttributes redirect) {
//		System.out.println(item.getBestPrice());
		
		System.out.println(item.getDeadline());
		  new PaintRegiValidator().validate(item, result); 
		  if (result.hasErrors()) { 
		  System.out.println("a"); return "paintingRegister"; }
		 
		
		try {
			String fileName = item.getPicturefile().getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String newFileName = uuid.toString() + "_" + fileName;
			String savePath = request.getSession().getServletContext().getRealPath("/files/");
			item.getPicturefile().transferTo(new File(savePath + newFileName));
			
			item.setPicture("/files/" + newFileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * new PaintRegiValidator().validate(item, result); if (result.hasErrors()) { //
		 * System.out.println("a"); return "paintingRegister"; }
		 */
		//연제테스트
		
//		System.out.println("b");
		item.setUserId(userSession.getAccount().getUserId());
		
		//해당 날짜의 11시 59분59초로 바꿔줌
		Date date = item.getDeadline();
		//System.out.println(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59); 
		calendar.set(Calendar.SECOND, 59);
		
		Date deadline = new Date(calendar.getTimeInMillis());
		item.setDeadline(deadline);
		
		artSell.insertItem(item);
		
		//request.getSession().setAttribute("itemSession", this.artSell.getItem(item.getItemId()));

		System.out.println("redirection attribute 전");
		//redirect.addAttribute("AuctionItem", this.artSell.getItem(item.getItemId()));
		redirect.addAttribute("itemId", item.getItemId());
		System.out.println("redirection 전");
		return "redirect:/auction/scheduler";
		//return "redirect:/myitem/list";
	}
	
	@GetMapping("/myitem/add")
	public String goEnterPaintPage() {
		
		return "paintingRegister";
	}
	
	@RequestMapping("/myitem/delete")
	public String deleteMyItem(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("itemId") String itemId, ModelMap model, HttpServletResponse response) throws Exception {
		String userId = userSession.getAccount().getUserId();
		
		List<AuctionItem> list = artSell.isAuctioning(itemId);
		if(list.size() == 1 && list.get(0).getState() == 4)
			artSell.deleteItem(userId, itemId);
		else {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('경매 참여자가 있으므로 삭제할 수 없습니다.'); history.go(-1);</script>");
            out.flush();
		}
			//model.put("alertmsg", "true");
		System.out.println("여기 오니???");

		return "redirect:/myitem/list";
	}
	
	@RequestMapping("/myitem/list2")
	public String handleRequest2(
		@RequestParam("page") String page, 
		@ModelAttribute("myPaintList") PagedListHolder<Item> itemList,
		BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 
		return "myPaintingList";
	}
}
