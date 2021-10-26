package com.example.artsell.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.artsell.controller.AccountForm;
import com.example.artsell.domain.Account;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park 나영 수정1
 */
@Component
public class AccountFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		AccountForm accountForm = (AccountForm) obj;
		Account account = accountForm.getAccount();

		// 에러 코드 수정완료.

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.name", "USER_NAME_REQUIRED", "이름은 필수항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.email", "EMAIL_REQUIRED", "이메일은 필수항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.phone", "PHONE_REQUIRED", "전화번호는 필수항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address1", "ADDRESS1_REQUIRED", "주소는 필수항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address2", "ADDRESS2_REQUIRED", "세부주소는 필수항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.credit", "CREDIT_REQUIRED", "카드번호는 필수항목입니다.");

		if (accountForm.isNewAccount()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.userId", "USER_ID_REQUIRED",
					"User ID 는 필수항목입니다.");
			if (account.getPassword() == null || account.getPassword().length() < 1
					|| !account.getPassword().equals(accountForm.getRepeatedPassword())) {
				errors.rejectValue("account.password", "PASSWORD_MISMATCH");
			}
		} else if (account.getPassword() != null && account.getPassword().length() > 0) {
			if (!account.getPassword().equals(accountForm.getRepeatedPassword())) {
				errors.rejectValue("account.password", "PASSWORD_MISMATCH");
			}
		}
	}
}