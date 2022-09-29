package com.example.semiproject.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class NoticeDto {
	private String adminId, noticeTitle, noticeContent, noticeHead;
	private int noticeNo, noticeRead;
	private Date noticeDate, noticeUpdate;
}
