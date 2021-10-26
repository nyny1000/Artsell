package com.example.artsell.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.Category;

public interface CategoryDao {
	List<Category> getCategoryList() throws DataAccessException;
	
	Category getCategory(String categoryId) throws DataAccessException;
}
