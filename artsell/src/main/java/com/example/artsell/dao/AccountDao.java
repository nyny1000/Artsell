package com.example.artsell.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Account;

public interface AccountDao {
//나영수정.
	Account getAccount(String userId) throws DataAccessException;

	Account getAccount(String userId, String password) throws DataAccessException;

	void insertAccount(Account account) throws DataAccessException;

	void updateAccount(Account account) throws DataAccessException;
	
	void deleteAccount(String userId) throws DataAccessException;

	List<String> getUsernameList() throws DataAccessException;
	
	List<Account> viewAccountList() throws DataAccessException;
	
	List<Account> getUserList() throws DataAccessException;
}
