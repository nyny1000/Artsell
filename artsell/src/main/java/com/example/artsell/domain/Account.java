package com.example.artsell.domain;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

//나영 수정1
@SuppressWarnings("serial")
public class Account implements Serializable {

	/* Private Fields */

	private String userId;
	private String password;
	private String address1;
	private String address2;
	@Email(message ="올바른 형식의 이메일을 입력해 주십시오.")
	private String email;
	@Pattern(regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$" ,message="format:(01x-xxx(x)-xxxx) 올바른 형식의 핸드폰 번호를 입력해 주십시오.") 
	private String phone;
	private String name;
	@PositiveOrZero(message="카드번호의 숫자만 입력해 주십시오.")
	private String credit;
	private int quit;

	/* JavaBeans Properties */

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public int getQuit() {
		return quit;
	}

	public void setQuit(int quit) {
		this.quit = quit;
	}

}
