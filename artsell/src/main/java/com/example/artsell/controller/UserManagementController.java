package com.example.artsell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.artsell.domain.*;
import com.example.artsell.service.ArtSellFacade;

public class UserManagementController {
	
	@Autowired
	private ArtSellFacade artsell;

	public void setArtSell(ArtSellFacade artsell) {
		this.artsell = artsell;
	}
	public List<Account> ViewAccountList() {
		List<Account> userAccountList = (List<Account>) artsell.viewAccountList();
		return userAccountList;
	}


}
