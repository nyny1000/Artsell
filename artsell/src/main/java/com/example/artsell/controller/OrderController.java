package com.example.artsell.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.Order;
import com.example.artsell.service.ArtSellFacade;
//123
import com.example.artsell.service.OrderValidator;
@Controller
@SessionAttributes({"sessionCart", "order", "itemId"})
public class OrderController {
	@Autowired
	private ArtSellFacade artsell;
	@Autowired
	private OrderValidator validator;
	
	public void setValidator(OrderValidator validator) {
		this.validator = validator;
	}

	//회원정보와동일
	@RequestMapping("/auction/auctioned_buyer_addressCheck")
	public String addressCheckbox(HttpServletRequest request,
			@ModelAttribute("order") Order order, ModelMap model) {
//		order = (Order) request.getSession().getAttribute("order");
		order = artsell.getOrder(order.getItemId(), order.getUserId());
		
		model.put("order", order);
//		request.getSession().setAttribute("order", order);
		
		return "auctioned_buyer";
	}
	
	
	@RequestMapping("/auction/auctioned_buyer")
	public String viewShippingForm(HttpServletRequest request,
			@RequestParam(name="itemId", required=false) String itemId,
			@ModelAttribute("order") Order order, ModelMap model,
			BindingResult result) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if (itemId == null) {
			itemId = order.getItemId();
		}
		if (itemId != null) {
			// Re-read account from DB at team's request.
			
			order = artsell.getOrder(itemId, userSession.getAccount().getUserId());
			System.out.println(order.getAddress1());
			order.setAddress1(null);
			order.setAddress2(null);
			
			model.put("order", order);
			
//			request.getSession().setAttribute("order", order);
			//Account account = artsell.getAccount(userSession.getAccount().getUserId());
			//Item item = artsell.getItem(itemId);
			//System.out.println(item.getItemName());
			//orderForm.getOrder().initOrder(account, cart);
			//artsell.getOrder(itemId,account.getUserId());
			System.out.println("123123");
			return "auctioned_buyer";
		}
		else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@ModelAttribute("order")
	public Order returnOrder() {
		return new Order();
	}
	
	@RequestMapping("/auction/destination")
	public String viewConfirmOrder(HttpServletRequest request,
			@ModelAttribute("order") Order order, 
			BindingResult result, ModelMap model) {	
		
		//artsell.SaveAuctionedItem(order);
//		order.setAddress(paddress);
//		System.out.println(paddress);
//		order = (Order) request.getSession().getAttribute("order");
		System.out.println(order.getAddress1());
		validator.validate(order, result);
		if (result.hasErrors()) {
			System.out.println("validate 오류");
//			redirectAttributes.addAttribute("itemId", order.getItemId());
			return "auctioned_buyer";
		}
		String itemId = order.getItemId();
		model.put("itemId", itemId);
		model.put("order", order);
		System.out.println(order.getItemId());	
		return "auctioned_destination";
	}
	
	@RequestMapping("/auction/receipt")
	public String viewOrder(HttpServletRequest request, 
			SessionStatus status) {
		//artsell.insertOrder(orderForm.getOrder());
		Date sellDate = new Date();
		Order order = (Order) request.getSession().getAttribute("order");
		
		System.out.println(order.getMyPrice());
		//db에 저장
		artsell.SaveAuctionedItem(order.getItemId(), order.getMyPrice(), order.getUserId(), order.getAddress1(), order.getAddress2(), sellDate);
		//state변경
		artsell.updateAuctionedState(order.getItemId(), order.getUserId());
		
		ModelAndView mav = new ModelAndView("ViewOrder");
		mav.addObject("order", order);
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		return "auctioned_receipt";
	}
	
}
