package com.example.semiproject.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ItemDto {
	private int itemNo, itemPrice, itemTotalCnt, itemLikeCnt, itemBaskectCnt;
	private String cateCode, itemName, itemMemo, itemContent, itemColor, itemSize;
	private Date itemDate;
}
