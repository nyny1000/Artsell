package com.example.artsell.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.artsell.service.ArtSellFacade;

@Component
public class AuctionInterceptor implements HandlerInterceptor {
	@Autowired
	private ArtSellFacade artSell;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String itemId = request.getParameter("itemId");
		if (artSell.getItem(itemId) == null) {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('경매가 종료된 상품입니다.'); history.go(-2);</script>");
            return false;
		}
		int state = artSell.getItemState(itemId);
		if (state != 0) {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('경매가 종료된 상품입니다.'); history.go(-2);</script>");
            System.out.println("redirect 전");
            //response.sendRedirect("/home");
            return false;
		}
		return true;
	}
}