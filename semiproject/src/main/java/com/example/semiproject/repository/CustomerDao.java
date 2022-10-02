package com.example.semiproject.repository;

import java.util.List;

import com.example.semiproject.entity.CustomerDto;

public interface CustomerDao {
	void insert(CustomerDto customerDto);
	void updateLogin(String customerId);
	
	CustomerDto selectOne(String customerId);
//	List<CustomerDto> select();

	
//	boolean update(CustomerDto customerDto);
	boolean delete(String customerId);
}
