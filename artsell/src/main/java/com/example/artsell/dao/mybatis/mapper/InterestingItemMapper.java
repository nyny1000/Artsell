package com.example.artsell.dao.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.artsell.domain.Item;

@Mapper
public interface InterestingItemMapper {
	List<Item> getInterestingItemList(String userId);
	
	List<Item> getPastInterestingItemList(String userId);
	
	void insertInterestingItem(String userId, String itemId);
	
	void deleteInterestingItem(String userId, String itemId); 
	
	int containsInterestingItem(String userId, String itemId);

	void deleteAll(String userId);

	void deleteAllInterestingItem(String itemId); 
	
}
