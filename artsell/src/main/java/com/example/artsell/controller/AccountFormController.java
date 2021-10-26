package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;
import com.example.artsell.service.AccountFormValidator;
import com.example.artsell.service.ArtSellFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park 나영 수정2
 */
@Controller
public class AccountFormController {

	@Value("editAccountForm")
	private String formViewName;

	// 회원가입 or 회원정보 수정 성공 시 가게 되는 뷰 (원래는 index)
	@Value("main")
	private String successViewName;

	@Autowired
	private ArtSellFacade artsell;

	public void setArtSell(ArtSellFacade artsell) {
		this.artsell = artsell;
	}

	@Autowired
	private AccountFormValidator validator;

	public void setValidator(AccountFormValidator validator) {
		this.validator = validator;
	}

	@ModelAttribute("userRegisterForm")
	public AccountForm formBackingObject_register(HttpServletRequest request) throws Exception {
		return new AccountForm();
	}

	@RequestMapping("/user/registerForm")
	public String showRegisterForm() {
		return "thyme/userRegister";
	}

	@RequestMapping("/user/register")
	public String onSubmit_register(HttpServletRequest request, HttpSession session,
			@Valid @ModelAttribute("userRegisterForm") AccountForm registerForm, BindingResult result) {
		validator.validate(registerForm, result);

		if (result.hasErrors())
			return "thyme/userRegister";

		try {
			artsell.insertAccount(registerForm.getAccount());

		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.userId", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return "thyme/userRegister";
		}

		UserSession userSession = new UserSession(artsell.getAccount(registerForm.getAccount().getUserId())); // userId로
																												// 수정.
		session.setAttribute("userSession", userSession);
		return "redirect:/user/main";
	}

	@ModelAttribute("accountForm")
	public AccountForm formBackingObject_edit(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) { // edit an existing account
			return new AccountForm(artsell.getAccount(userSession.getAccount().getUserId())); // 아이디를 이용해서 가져오도록 수정.
		}
		return new AccountForm();
		}

	@RequestMapping("/user/editForm")
	public String showForm_edit() {
		return formViewName;
	}

	@RequestMapping("/user/edit")
	public String onSubmit(HttpServletRequest request, @RequestParam(value="address1", required=false) String address1, HttpSession session,
			@Valid @ModelAttribute("accountForm") AccountForm accountForm, BindingResult result) throws Exception {

		validator.validate(accountForm, result);

		if (result.hasErrors())
			return formViewName;

		try {

			artsell.updateAccount(accountForm.getAccount());
		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.userId", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName;
		}

		UserSession userSession = new UserSession(artsell.getAccount(accountForm.getAccount().getUserId())); // userId로
																												// 수정.

		session.setAttribute("userSession", userSession);
		return "redirect:/user/main";
	}
}
