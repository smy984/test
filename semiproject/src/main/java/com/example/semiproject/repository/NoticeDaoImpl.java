package com.example.semiproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.semiproject.entity.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(NoticeDto noticeDto) {
		String sql = "insert into notice("
						+ "admin_id, notice_no, notice_title, "
						+ "notice_content, notice_head) values("
						+ "?, notice_seq.nextval, ?,?,?)";
		Object[] param = {noticeDto.getAdminId(), noticeDto.getNoticeTitle(), 
							noticeDto.getNoticeContent(), noticeDto.getNoticeHead()};
		
		jdbcTemplate.update(sql, param);
	}
	
	private RowMapper<NoticeDto> noticeMapper = (rs, idx)->{
		return NoticeDto.builder()
						.adminId(rs.getString("admin_id"))
						.noticeNo(rs.getInt("notice_no"))
						.noticeTitle(rs.getString("notice_title"))
						.noticeDate(rs.getDate("notice_date"))
						.noticeUpdate(rs.getDate("notice_update"))
						.noticeRead(rs.getInt("notice_read"))
						.noticeContent(rs.getString("notice_content"))
						.noticeHead(rs.getString("notice_head"))
						.build();
	};
	
	@Override
	public List<NoticeDto> list() {
		String sql = "select * from notice order by notice_no desc";
		
		return jdbcTemplate.query(sql, noticeMapper);
	}
	
	private ResultSetExtractor<NoticeDto> noticeExtractor = (rs)->{
		if(rs.next()) {
			return NoticeDto.builder()
					.adminId(rs.getString("admin_id"))
					.noticeNo(rs.getInt("notice_no"))
					.noticeTitle(rs.getString("notice_title"))
					.noticeDate(rs.getDate("notice_date"))
					.noticeUpdate(rs.getDate("notice_update"))
					.noticeRead(rs.getInt("notice_read"))
					.noticeContent(rs.getString("notice_content"))
					.noticeHead(rs.getString("notice_head"))
					.build();
		}
		else {
			return null;
		}
	};
	
	@Override
	public NoticeDto selectOne(int noticeNo) {
		String sql = "select * from notice where notice_no=?";
		Object[] param = {noticeNo};
		return jdbcTemplate.query(sql, noticeExtractor, param);
	}
}
