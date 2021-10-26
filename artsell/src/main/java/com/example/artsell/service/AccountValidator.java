package com.example.artsell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.artsell.domain.Account;
import com.example.artsell.service.ArtSellFacade;
/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 * 나영 수정1
 */
@Component
public class AccountValidator implements Validator {

	@Autowired
	private ArtSellFacade artSell;

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		Account account = (Account)obj; 
		
		System.out.println("아이디 벨리데이션 " + account.getUserId());
		System.out.println("패스워드 벨리데이션 " + account.getPassword());


		//에러 코드 수정완료.
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "USER_ID_REQUIRED", "필수항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "USER_PASSWORD_REQUIRED", "필수항목입니다.");

		
		String inputUserId = account.getUserId();
		String inputPassword = account.getPassword();
		
		if (artSell.getAccount(inputUserId) == null || artSell.getAccount(inputUserId).getQuit() == 1) {
			System.out.println("You are an unregistered member. Please register as a member.");
			errors.reject("userId", "등록 되지 않은 회원입니다. 회원가입을 해주세요.");
		}
		else if (!artSell.getAccount(inputUserId).getPassword().equals(inputPassword)) {
			System.out.println("input password" + inputPassword);
			System.out.println("signed password" + artSell.getAccount(inputUserId).getPassword());


			System.out.println("The password is incorrect. Please re-enter.");

			errors.reject("password", "비밀번호가 일치하지 않습니다. 다시 입력해주세요.");

		}
		
	}
}