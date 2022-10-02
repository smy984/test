package com.example.semiproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.semiproject.entity.ItemDto;

@Repository
public class ItemDaoImpl implements ItemDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void isert(ItemDto itemDto) {
		String sql = "insert into item("
				+ "item_no, cate_code, item_name, item_memo, "
				+ "item_content, item_price, itme_color, item_size, "
				+ "item_total_cnt) values()";
		
	}
}
