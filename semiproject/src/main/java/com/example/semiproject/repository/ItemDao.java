package com.example.semiproject.repository;

import java.util.List;

import com.example.semiproject.entity.ItemDto;

public interface ItemDao {
	int sequence();
	void insert(ItemDto itemDto);
	
	ItemDto selectone(int itemNo);
	
	List<ItemDto> recentList();
}
