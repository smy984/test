package com.example.semiproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.semiproject.entity.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(CustomerDto customerDto) {
		String sql = "insert into customer("
						+ "customer_id, customer_pw, customer_pwcheck, "
						+ "customer_pwsearch, customer_nick, customer_name, "
						+ "customer_post, customer_host, "
						+ "customer_detail_host, customer_tel, "
						+ "customer_phone, customer_birth, "
						+ "customer_email) values("
						+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] param = {customerDto.getCustomerId(), customerDto.getCustomerPw(), 
							customerDto.getCustomerPwcheck(), customerDto.getCustomerPwsearch(), 
							customerDto.getCustomerNick(), customerDto.getCustomerName(), 
							customerDto.getCustomerPost(), customerDto.getCustomerHost(), 
							customerDto.getCustomerDetailHost(), customerDto.getCustomerTel(), 
							customerDto.getCustomerPhone(), customerDto.getCustomerBirth(), 
							customerDto.getCustomerEmail()};
		
		jdbcTemplate.update(sql, param);
	}

	private RowMapper<CustomerDto> customerMapper = (rs, idx)->{
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(rs.getString("customer_id"));
		customerDto.setCustomerPw(rs.getString("customer_pw"));
		customerDto.setCustomerPwcheck(rs.getString("customer_pwcheck"));
		customerDto.setCustomerNick(rs.getString("customer_nick"));
		customerDto.setCustomerName(rs.getString("customer_name"));
		customerDto.setCustomerPost(rs.getString("customer_post"));
		customerDto.setCustomerHost(rs.getString("customer_host"));
		customerDto.setCustomerDetailHost(rs.getString("customer_detail_host"));
		customerDto.setCustomerTel(rs.getString("customer_tel"));
		customerDto.setCustomerPhone(rs.getString("customer_phone"));
		customerDto.setCustomerBirth(rs.getDate("customer_birth"));
		customerDto.setCustomerEmail(rs.getString("customer_email"));
		customerDto.setCustomerPoint(rs.getInt("customer_point"));
		customerDto.setCustomerMoney(rs.getInt("customer_money"));
		customerDto.setCustomerGrade(rs.getString("customer_grade"));
		customerDto.setCustomerJoin(rs.getDate("customer_join"));
		customerDto.setCustomerLogin(rs.getDate("customer_login"));
		return customerDto;
	};
	
	private ResultSetExtractor<CustomerDto> customerExtractor = (rs)->{
		if(rs.next()) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerId(rs.getString("customer_id"));
			customerDto.setCustomerPw(rs.getString("customer_pw"));
			customerDto.setCustomerPwcheck(rs.getString("customer_pwcheck"));
			customerDto.setCustomerNick(rs.getString("customer_nick"));
			customerDto.setCustomerName(rs.getString("customer_name"));
			customerDto.setCustomerPost(rs.getString("customer_post"));
			customerDto.setCustomerHost(rs.getString("customer_host"));
			customerDto.setCustomerDetailHost(rs.getString("customer_detail_host"));
			customerDto.setCustomerTel(rs.getString("customer_tel"));
			customerDto.setCustomerPhone(rs.getString("customer_phone"));
			customerDto.setCustomerBirth(rs.getDate("customer_birth"));
			customerDto.setCustomerEmail(rs.getString("customer_email"));
			customerDto.setCustomerPoint(rs.getInt("customer_point"));
			customerDto.setCustomerMoney(rs.getInt("customer_money"));
			customerDto.setCustomerGrade(rs.getString("customer_grade"));
			customerDto.setCustomerJoin(rs.getDate("customer_join"));
			customerDto.setCustomerLogin(rs.getDate("customer_login"));
			return customerDto;
		}
		else {
			return null;
		}
	};
	
	@Override
	public CustomerDto selectOne(String customerId) {
		String sql = "select * from customer where customer_id=?";
		Object[] param = {customerId};
		return jdbcTemplate.query(sql, customerExtractor, param);
	}
	
	@Override
	public void updateLogin(String customerId) {
		String sql = "update customer set customer_login=sysdate where customer_id=?";
		Object[] param = {customerId};
		jdbcTemplate.update(sql, param);
	}
	
}
