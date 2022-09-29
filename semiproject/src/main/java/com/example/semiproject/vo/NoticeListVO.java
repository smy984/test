package com.example.semiproject.vo;

import lombok.Data;

@Data
public class NoticeListVO {
	private String type, keyword;
	
	public boolean isSearch() {
		return type != null && keyword != null;
	}
}
