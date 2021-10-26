package com.example.artsell.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.AccountDao;
import com.example.artsell.dao.mybatis.mapper.AccountMapper;
import com.example.artsell.domain.Account;

@Repository
//ny 2수정.
public class MybatisAccountDao implements AccountDao {
	@Autowired
	private AccountMapper accountMapper;

	public Account getAccount(String userId) throws DataAccessException {
		return accountMapper.getAccountByUserId(userId);
	}

	public Account getAccount(String userId, String password) throws DataAccessException {
		return accountMapper.getAccountByUserIdAndPassword(userId, password);
	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
	}

	public List<String> getUsernameList() throws DataAccessException {
		return accountMapper.getUsernameList();
	}

	@Override
	public void deleteAccount(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		accountMapper.deleteAccount(userId);
	}

	@Override
	public List<Account> viewAccountList() throws DataAccessException {
		// TODO Auto-generated method stub
		return accountMapper.viewAccountList();
	}
	
	@Override
	public List<Account> getUserList() throws DataAccessException {
		return accountMapper.getUserList();
	}
}
