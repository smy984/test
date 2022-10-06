package com.example.semiproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.semiproject.entity.CustomerLikeDto;

@Repository
public class CustomerLikeDaoImpl implements CustomerLikeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(CustomerLikeDto likeDto) {
		String sql = "insert into customer_like(customer_id, item_no) values(?,?)";
		Object[] param = {likeDto.getCustomerId(), likeDto.getItemNo()};
		
		jdbcTemplate.update(sql, param);
	}

	@Override
	public boolean delete(CustomerLikeDto likeDto) {
		String sql = "delete customer_like where customer_id=? and item_no=?";
		Object[] param = {likeDto.getCustomerId(), likeDto.getItemNo()};
		
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean check(CustomerLikeDto likeDto) {
		String sql = "select count(*) from customer_like "
				+ "where customer_id=? and item_no=?";
		Object[] param = {likeDto.getCustomerId(), likeDto.getItemNo()};
		
		return jdbcTemplate.queryForObject(sql, int.class, param) == 1;
	}

	@Override
	public void update(int itemNo) {
		String sql = "update item set "
						+ "item_like_cnt=("
						+ "select count(*) from customer_like "
						+ "where item_no=?"
					+ ") where item_no=?";
		Object[] param = {itemNo, itemNo};
		
		jdbcTemplate.update(sql, param);
	}

	
}
