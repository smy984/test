package com.example.semiproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.semiproject.entity.ItemDto;

@Repository
public class ItemDaoImpl implements ItemDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int sequence() {
		String sql = "select item_seq.nextval from dual";
		
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public void insert(ItemDto itemDto) {
		String sql = "insert into item("
				+ "item_no, cate_code, item_name, item_memo, "
				+ "item_content, item_price, item_color, item_size) "
				+ "values(?,?,?,?,?,?,?,?)";
		Object[] param = {itemDto.getItemNo(), itemDto.getCateCode(), itemDto.getItemName(), 
						itemDto.getItemMemo(), itemDto.getItemContent(), 
						itemDto.getItemPrice(), itemDto.getItemColor(), itemDto.getItemSize()};
		jdbcTemplate.update(sql, param);
	}
	
	private ResultSetExtractor<ItemDto> itemExtractor = (rs)->{
		if(rs.next()) {
			return ItemDto.builder()
						.itemNo(rs.getInt("item_no"))
						.cateCode(rs.getString("cate_code"))
						.itemName(rs.getString("item_name"))
						.itemMemo(rs.getString("item_memo"))
						.itemContent(rs.getString("item_content"))
						.itemPrice(rs.getInt("item_price"))
						.itemColor(rs.getString("item_color"))
						.itemSize(rs.getString("item_size"))
						.itemTotalCnt(rs.getInt("item_total_cnt"))
						.itemLikeCnt(rs.getInt("item_like_cnt"))
						.itemBaskectCnt(rs.getInt("item_basket_cnt"))
						.itemDate(rs.getDate("item_date"))
					.build();
		}
		else {
			return null;
		}
	};
	
	@Override
	public ItemDto selectone(int itemNo) {
		String sql = "select * from item where item_no=?";
		Object[] param = {itemNo};
		
		return jdbcTemplate.query(sql, itemExtractor, param);
	}
	
	private RowMapper<ItemDto> itemMapper = (rs, idx)->{
		return ItemDto.builder()
				.itemNo(rs.getInt("item_no"))
				.cateCode(rs.getString("cate_code"))
				.itemName(rs.getString("item_name"))
				.itemMemo(rs.getString("item_memo"))
				.itemContent(rs.getString("item_content"))
				.itemPrice(rs.getInt("item_price"))
				.itemColor(rs.getString("item_color"))
				.itemSize(rs.getString("item_size"))
				.itemTotalCnt(rs.getInt("item_total_cnt"))
				.itemLikeCnt(rs.getInt("item_like_cnt"))
				.itemBaskectCnt(rs.getInt("item_basket_cnt"))
				.itemDate(rs.getDate("item_date"))
			.build();
	};
	
	@Override
	public List<ItemDto> recentList() {
		String sql = "select * from ("
						+ "select tmp.*, rownum rn from("
							+ "select * from item order by item_no desc"
						+ ") tmp"
					+ ") where rn between 1 and 5";

		return jdbcTemplate.query(sql, itemMapper);
	}
}
