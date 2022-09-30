package com.example.semiproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.semiproject.entity.NoticeDto;
import com.example.semiproject.vo.NoticeListVO;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int sequence() {
		String sql = "select notice_seq.nextval from dual";
		
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public void insert(NoticeDto noticeDto) {
		String sql = "insert into notice("
						+ "admin_id, notice_no, notice_title, "
						+ "notice_content, notice_head) values("
						+ "?,?,?,?,?)";
		Object[] param = {noticeDto.getAdminId(), noticeDto.getNoticeNo(), 
		noticeDto.getNoticeTitle(), noticeDto.getNoticeContent(), noticeDto.getNoticeHead()};
		
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
	public List<NoticeDto> noticeBoard(NoticeListVO noticeListVO) {
		if(noticeListVO.isSearch()) {
			return search(noticeListVO);
		}
		else {
			return list(noticeListVO);
		}
	}
	
	@Override
	public List<NoticeDto> list(NoticeListVO noticeListVO) {
		String sql = "select * from ("
						+ "select tmp.*, rownum rn from ("
							+ "select * from notice order by notice_no desc"
						+ ") tmp"
					+ ") where rn between ? and ?";
		Object[] param = {noticeListVO.startBlock(), noticeListVO.endBlock()};
		return jdbcTemplate.query(sql, noticeMapper, param);
	}
	
	@Override
	public List<NoticeDto> search(NoticeListVO noticeListVO) {
		String sql = "select * from notice where instr(#1, ?) > 0 "
				+ "order by notice_no desc";
		sql = sql.replace("#1", noticeListVO.getType());
		Object[] param = {noticeListVO.getKeyword()};
		
		return jdbcTemplate.query(sql, noticeMapper, param);
	}
	
	@Override
	public int count(NoticeListVO noticeListVO) {
		if(noticeListVO.isSearch()) {
			return searchCount(noticeListVO);
		}
		else {
			return listCount(noticeListVO);
		}
	}
	
	@Override
	public int listCount(NoticeListVO noticeListVO) {
		String sql = "select count(*) from notice";
		
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public int searchCount(NoticeListVO noticeListVO) {
		String sql = "select count(*) from notice "
				+ "where instr(#1, ?) > 0";
		sql = sql.replace("#1", noticeListVO.getType());
		Object[] param = {noticeListVO.getKeyword()};
		
		return jdbcTemplate.queryForObject(sql, int.class, param);
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
	
	@Override
	public boolean edit(NoticeDto noticeDto) {
		String sql = "update notice set "
						+ "notice_title=?, "
						+ "notice_content=?, "
						+ "notice_update=sysdate, "
						+ "notice_head=?, "
					+ "where notice_no=?";
		Object[] param = {noticeDto.getNoticeTitle(), noticeDto.getNoticeContent(), 
							noticeDto.getNoticeHead(), noticeDto.getNoticeNo()};
		
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	@Override
	public boolean delete(int noticeNo) {
		String sql = "delete notice where notice_no=?";
		Object[] param = {noticeNo};
		
		return jdbcTemplate.update(sql, param) > 0;
	}
}
