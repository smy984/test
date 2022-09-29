package com.example.semiproject.vo;

import lombok.Data;

@Data
public class NoticeListVO {
	//공지사항 검색용
	private String type, keyword;
	
	public boolean isSearch() {
		return type != null && keyword != null;
	}
	
	//공지사항 페이징용
	private int p = 1;//게시물 번호(없을 시 1로 설정)
	
	private int pSize = 10;//한 화면에 출력될 게시물 수(없을 시 10으로 설정)
	
	private int count;//총 게시물 수
	
	private int blockSize = 5;//한 화면에 출력될 페이징 수
	
}
