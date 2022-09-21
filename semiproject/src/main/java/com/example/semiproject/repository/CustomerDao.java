package com.example.semiproject.repository;

import java.util.List;

import com.example.semiproject.entity.CustomerDto;

public interface CustomerDao {
	void insert(CustomerDto customerDto);
	
//	List<CustomerDto> select();
//	CustomerDto selectOne(String customerId);
//	
//	boolean update(CustomerDto customerDto);
//	boolean delete(String customerId);
}
