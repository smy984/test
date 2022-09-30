package com.example.semiproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.semiproject.entity.NoticeDto;
import com.example.semiproject.repository.NoticeDao;

@SpringBootTest
class SemiprojectApplicationTests {

	@Autowired
	private NoticeDao noticeDao;
	
	@BeforeEach
	void before() {
		for(int i=1; i<=99; i++) {
			int noticeNo = noticeDao.sequence();
			noticeDao.insert(NoticeDto.builder()
										.adminId("admin")
										.noticeNo(noticeNo)
										.noticeTitle("공지테스트"+i)
										.noticeContent("공지글테스트"+i)
										.noticeHead("긴급")
										.build());
		}
		
	}
	
	@Test
	void contextLoads() {
		System.out.println("입력끝");
	}

}
