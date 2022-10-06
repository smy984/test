package com.example.semiproject.repository;

import com.example.semiproject.entity.CustomerLikeDto;

public interface CustomerLikeDao {
	void insert(CustomerLikeDto likeDto);
	
	boolean delete(CustomerLikeDto likeDto);
	
	boolean check(CustomerLikeDto likeDto);
	
	void update(int itemNo);
}
