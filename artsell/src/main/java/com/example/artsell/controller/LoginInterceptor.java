package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.util.WebUtils;

import com.example.artsell.domain.Account;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@ModelAttribute("loginAccount")
	public Account formBackingObject(HttpServletRequest request) throws Exception {
		return new Account();
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession == null) {
			String url = request.getRequestURL().toString(); 
			String query = request.getQueryString();
			//ModelAndView modelAndView = new ModelAndView("tiles/loginForm"); 	// use Tiles
			ModelAndView modelAndView = new ModelAndView("thyme/login");
			modelAndView.addObject("loginAccount", formBackingObject(request));
			if (query != null) {
				modelAndView.addObject("loginForwardAction", url+"?"+query);
			}
			else {
				modelAndView.addObject("loginForwardAction", url);
			}
			System.out.println("interceptor");
			throw new ModelAndViewDefiningException(modelAndView);
		}
		else {
			return true;
		}
	}
}
