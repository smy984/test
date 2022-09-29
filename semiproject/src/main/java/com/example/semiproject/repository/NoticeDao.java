package com.example.semiproject.repository;

import java.util.List;

import com.example.semiproject.entity.NoticeDto;
import com.example.semiproject.vo.NoticeListVO;

public interface NoticeDao {
	//공지사항 글쓰기
	int sequence();
	void insert(NoticeDto noticeDto);
	
	//공지사항 리스트
	List<NoticeDto> noticeBoard(NoticeListVO noticeListVO);
	List<NoticeDto> list(NoticeListVO noticeListVO);
	List<NoticeDto> search(NoticeListVO noticeListVO);
	
	//공지사항 페이징->검색 유무에 따른 총 게시물 수 파악 위함
	int count(NoticeListVO noticeListVO);
	int listCount(NoticeListVO noticeListVO);
	int searchCount(NoticeListVO noticeListVO);
	
	//공지사항 상세보기
	NoticeDto selectOne(int noticeNo);

	//공지사항 수정하기
	boolean edit(NoticeDto noticeDto);
	
	//공지사항 삭제하기
	boolean delete(int noticeNo);
	
}
