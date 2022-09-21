package com.example.semiproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.semiproject.entity.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(CustomerDto customerDto) {
		String sql = "insert into customer("
						+ "customer_id, customer_pw, "
						+ "customer_nick, customer_name, "
						+ "customer_post, customer_host, "
						+ "customer_detail_host, customer_tel, "
						+ "customer_phone, customer_birth, "
						+ "customer_email) values("
						+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] param = {customerDto.getCustomerId(), customerDto.getCustomerPw(), 
							customerDto.getCustomerNick(), customerDto.getCustomerName(), 
							customerDto.getCustomerPost(), customerDto.getCustomerHost(), 
							customerDto.getCustomerDetailHost(), customerDto.getCustomerTel(), 
							customerDto.getCustomerPhone(), customerDto.getCustomerBirth(), 
							customerDto.getCustomerEmail()};
		
		jdbcTemplate.update(sql, param);
	}
}
