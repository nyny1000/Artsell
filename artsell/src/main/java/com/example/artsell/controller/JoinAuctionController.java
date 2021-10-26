package com.example.artsell.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.AuctionedItem;
import com.example.artsell.domain.Item;

import com.example.artsell.domain.Order;

import com.example.artsell.service.AccountFormValidator;
import com.example.artsell.service.AuctionPriceValidator;

import com.example.artsell.service.ArtSellFacade;

import java.util.Date;

@Controller
@SessionAttributes({ "userSession", "itemId" })
public class JoinAuctionController {

	@Autowired
	private ArtSellFacade artSell;

	@ModelAttribute("order")
	public Order returnOrder() {
		return new Order();
	}

	@Autowired
	private AuctionPriceValidator validator;

	public void setValidator(AuctionPriceValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("auctionItem")
	public AuctionItem formBackingObject(HttpServletRequest request, HttpSession session, SessionStatus sessionStatus)
			throws Exception {
		System.out.println("폼백킹입니다");
		return new AuctionItem();

	}

	// 입찰, 재입찰
	@RequestMapping("/auction/bid")
	public String addAuctionItem(@ModelAttribute("userSession") UserSession userSession, HttpServletRequest request,
			@ModelAttribute("auctionItem") AuctionItem bidder, BindingResult result, ModelMap model) throws Exception {
		String itemId = bidder.getItemId();
		int myPrice = bidder.getMyPrice();

		System.out.println("넘어옴. 아이템아이디는" + itemId);

		System.out.println("넘어옴. 가격은" + myPrice);

		// 확인차
		String userId = userSession.getAccount().getUserId();
		Item auctionItem = artSell.getItem(itemId);
		System.out.println(auctionItem);
		System.out.println("넘어옴. 해당 아이템의 bestPrice는 " + auctionItem.getBestPrice());

		System.out.println("옥션비더출력" + bidder);

		boolean bidTry = false;

		List<AuctionItem> buyers = artSell.getBuyersByItemId(itemId);
		System.out.println("바이어스 출력" + buyers);

		validator.validate(bidder, result);

		if (result.hasErrors()) {
			model.put("item", auctionItem);
			model.put("buyers", buyers);
			System.out.println("입찰가 validation 에러");
			System.out.println(result.getGlobalError());
			return "auction_buyer";
		}

		// validation 검사 후이기때문에 정상 입찰가만 db에 저장.
		// 첫 입찰자
		if (artSell.getBuyersByItemId(itemId).size() == 0) { // minPrice보다 커야함.
			System.out.println("첫입찰자로 왔음");
			if (myPrice > auctionItem.getMinPrice()) {
				artSell.addPrice(userId, itemId, myPrice);
				System.out.println("add 됐음");
				artSell.updateItemBestPrice(itemId, myPrice);
				System.out.println("업데이트 됐음");
				artSell.deleteInterestingItem(userId, itemId);
				bidTry = true;
				model.put("bidTry", bidTry);

			}
		} else {
			// 그 다음 입찰자는 maxPrice보다 크게 입찰해야 함.
			if (myPrice > auctionItem.getBestPrice()) {
				// 새로운 입찰자인지 체크
				if (artSell.isNewUserPrice(userId, itemId) > 0) { // 헌값 수정!
					System.out.println("새로운 입찰자가 아님 헌값 수정");
					artSell.updatePrice(userId, itemId, myPrice);
					artSell.updateItemBestPrice(itemId, myPrice);
					artSell.deleteInterestingItem(userId, itemId);
					bidTry = true;
					model.put("bidTry", bidTry);


				} else { // 새로운 값
					System.out.println("새로운 입찰자");
					artSell.addPrice(userId, itemId, myPrice);
					artSell.updateItemBestPrice(itemId, myPrice);
					artSell.deleteInterestingItem(userId, itemId);
					bidTry = true;
					model.put("bidTry", bidTry); 

				}
			}
		}
		buyers = artSell.getBuyersByItemId(itemId);
		auctionItem = artSell.getItem(itemId);
		System.out.println("바이어스 출력" + buyers);
		model.put("buyers", buyers);
		model.put("item", auctionItem);

		return "auction_buyer";
	}

	// 낙찰포기 //if 후순위자있을경우->후순위자상태바꿈 else
	@RequestMapping("/auction/success/cancel")
	public String giveup(@ModelAttribute("userSession") UserSession userSession, @RequestParam("itemId") String itemId,
			ModelMap model) {

		String userId = userSession.getAccount().getUserId();

		// auctionitem table에서 해당 아이디 / 아이템아이디의 행 삭제
		artSell.deleteAuctionItem(userId, itemId);

		List<AuctionItem> auctionBuyerList = artSell.getBuyers(itemId);

		if (auctionBuyerList.size() != 0) // 후순위자가 있다면
		{// 후순위자에게 낙찰
			AuctionItem secondAuctionitem = auctionBuyerList.get(0); // 후순위자
			String secondUser = secondAuctionitem.getUserId();
			int secondPrice = secondAuctionitem.getMyPrice();

			// 해당 아이템 최고가 변경.
			artSell.updateItemBestPrice(itemId, secondPrice);

			changeState(secondUser, itemId, 1);

			return "redirect:/auction/list";

		} else {
			// 사는 사람은 포기하고 경매목록 리다이렉트
			// 판매자아이디 5로 바꿔주기
			String sellerId = artSell.getItem(itemId).getUserId();
			changeState(sellerId, itemId, 5);
			artSell.updateItemBestPrice(itemId, 0);
			return "redirect:/auction/list";
		}
	}

	// 해당 아이템의 state 바꿔주기
	public void changeState(String userId, String itemId, int state) {
		artSell.changeState(userId, itemId, state);
	}

	// 아이템아이디에 해당하는 경매참여자들
	public List<AuctionItem> AuctionJoinerList(String itemId) {
		return this.artSell.getBuyersByItemId(itemId);
	}

	// 아이템아이디에 해당하는 경매참여자들 buyer
	@RequestMapping("/auction/info")
	public String viewAutionJoinerList(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam(value = "itemId") String itemId, HttpSession session,
			ModelMap model, RedirectAttributes redirectAttributes) {
		
		Item item = artSell.getItem(itemId);
		System.out.print("참여자들 출력 아이템 아이디는" + itemId);
		if (item.getUserId().equals(userSession.getAccount().getUserId())) {
			redirectAttributes.addAttribute("itemId", itemId);
			return "redirect:/auction/info_seller";
		}
		List<AuctionItem> buyers = this.artSell.getBuyersByItemId(item.getItemId());
		model.put("buyers", buyers);
		model.put("item", item); // 나영추가
		return "auction_buyer";
	}

	// 판매자용 페이지로
	@RequestMapping("/auction/info_seller")
	public String viewAutionJoinerList2(@RequestParam("itemId") String itemId, @ModelAttribute("item") Item item,
			ModelMap model) {
		System.out.println(item.getItemId());
		List<AuctionItem> buyers = null;
		if (item == null) {
			item = artSell.getItem(itemId);
			buyers = this.artSell.getBuyersByItemId(itemId);
		}
		else {
			item = artSell.getItem(itemId);
			buyers = this.artSell.getBuyersByItemId(item.getItemId());
		}
		System.out.println(item.getItemName());
		model.put("buyers", buyers);
		model.put("item", item);

		return "auction_seller";
	}

	@RequestMapping("/auction/success")
	public String success(@RequestParam("itemId") String itemId,
			@ModelAttribute("userSession") UserSession userSession) {
		Date now = new Date(System.currentTimeMillis());
//		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date = "2021-05-28 01:06";
//		Date deadline = null;
//		try {
//			deadline = d.parse(now);
		System.out.println("아이디" + itemId);
		artSell.changeDeadline(now, itemId);
		artSell.bidSuccess(itemId);

		return "redirect:/myitem/list";
	}

	// 유찰 //기간은 현재 날짜에서 7일후
	@RequestMapping("/auction/fail")
	public ModelAndView miscarry(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("itemId") String itemId) {
		String userId = userSession.getAccount().getUserId();
		int minPrice = artSell.getItemPrice(itemId);
		int newPrice = (int) (minPrice * 0.7);
		newPrice = (int) (minPrice * 0.7);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		cal.add(Calendar.DATE, 7);
		Date deadline = null;
		try {
			deadline = df.parse(df.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView("myPainting_bidding");
		model.addObject("minPrice", minPrice);
		model.addObject("newPrice", newPrice);
		model.addObject("deadline", deadline);
		model.addObject("itemId", itemId);
		return model;

	}

	@RequestMapping("/auction/fail/ok")
	public String Reupload(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("itemId") String itemId, @RequestParam("minPrice") int minPrice,
			@RequestParam("deadline") String deadline, RedirectAttributes redirectAttributes) {
		System.out.println(deadline);

		String userId = userSession.getAccount().getUserId();
		DateFormat parser2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		DateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

		Date dl = null;
		try {
			dl = parser.parse(parser.format(parser2.parse(deadline)));
			// dl = parser.parse(deadline);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		artSell.auctionScheduler(dl, itemId);

		System.out.println("itemId1: " + itemId);
		artSell.updateReload(itemId, minPrice, dl, userId);

		return "redirect:/myitem/list";
	}

	// 유찰 안하겠다고 했을때
	@RequestMapping("/auction/fail/no")
	public String Reupload(@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("itemId") String itemId) {
		String userId = userSession.getAccount().getUserId();
		artSell.deleteItem(userId, itemId);
		return "redirect:/home";
	}

	@RequestMapping("/auction/scheduler")
	public String handleRequest(@RequestParam("itemId") String itemId,
			@ModelAttribute("userSession") UserSession userSession) {
		System.out.println(itemId);
		Item item = this.artSell.getItem(itemId);
		Date deadline = item.getDeadline();

		// 테스트
		/*
		 * SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm"); String date =
		 * "2021-05-28 01:06"; Date deadline = null; try { deadline = d.parse(date); }
		 * catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		System.out.println(deadline);

		AuctionItem auctionItem = new AuctionItem();
		auctionItem.setItemId(itemId);
		auctionItem.setState(4);
		auctionItem.setUserId(userSession.getAccount().getUserId());
		artSell.insertAuctionItem(auctionItem);

		artSell.auctionScheduler(deadline, item.getItemId());
		System.out.println("부르기전");
		return "redirect:/myitem/list";
		// return "main";
	}

	@RequestMapping("/auction/seller")
	public String viewSellerOk(@RequestParam("itemId") String itemId, ModelMap model) {
		AuctionedItem auctionedItem = artSell.getAuctionedItemByItemId_BuyerId(itemId);
		model.put("auctionedItem", auctionedItem);
		
		return "auctioned_seller";
	}
	
	@RequestMapping("/auction/sell_buyer")
	public String viewBuyerOk(@RequestParam("itemId") String itemId, ModelMap model) {
		AuctionedItem auctionedItem = artSell.getAuctionedItemByItemId_SellerId(itemId);
		model.put("auctionedItem", auctionedItem);
		
		return "auctioned_sell_buyer";
	}
}
