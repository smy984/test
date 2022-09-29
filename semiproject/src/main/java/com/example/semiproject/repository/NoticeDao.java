package com.example.semiproject.repository;

import java.util.List;

import com.example.semiproject.entity.NoticeDto;

public interface NoticeDao {
	void insert(NoticeDto noticeDto);
	
	List<NoticeDto> list();
	List<NoticeDto> list(String type, String keyword);
	
	NoticeDto selectOne(int noticeNo);
}
