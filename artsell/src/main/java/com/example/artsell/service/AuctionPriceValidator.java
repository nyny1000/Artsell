package com.example.artsell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Component
public class AuctionPriceValidator implements Validator {

	@Autowired
	private ArtSellFacade artSell;

	public boolean supports(Class<?> clazz) {
		return AuctionItem.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		AuctionItem bidder = (AuctionItem) obj;

		System.out.println("밸리데이션옥션비더출력" + bidder);
		System.out.println("밸리데이션옥션비더가격출력" + bidder.getMyPrice());


		Item auctionItem = artSell.getItem(bidder.getItemId());

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "myPrice", "BID_PRICE_REQUIRED", "Please enter your bid.");

		String itemId = bidder.getItemId();
		int bidderPrice = bidder.getMyPrice();

		// 첫 입찰자
		if (artSell.getBuyersByItemId(itemId).size() == 0) {
			if (bidderPrice <= auctionItem.getMinPrice()) { // 최소가 보다 낮은 금액을 입력했을 경우
				System.out.println("사이즈는?" + artSell.getBuyersByItemId(itemId).size());
				System.out.println("validation 최소가보다 낮음");
				errors.rejectValue("myPrice", "LOWER_BID_THAN_MINPRICE");
			}
			/*
			 * else if (bidderPrice > 2000000000) { errors.rejectValue("myPrice",
			 * "HIGHER_BID_THAN_MAXIMUMPRICE"); }
			 * 
			 */
		}
		// 이후 입찰자들
		else {
			if (bidderPrice <= auctionItem.getBestPrice()) { // 현재 최고가 보다 낮은 금액을 입력했을 경우
				System.out.println("validation 현재 최고가보다 낮음");
				errors.rejectValue("myPrice", "LOWER_BID_THAN_BESTPRICE");
			}
			/*
			 * else if (bidderPrice > 2000000000) { errors.rejectValue("myPrice",
			 * "HIGHER_BID_THAN_MAXIMUMPRICE"); }
			 */
			
		}

	}
}