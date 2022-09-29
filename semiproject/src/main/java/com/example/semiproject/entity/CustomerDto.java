package com.example.semiproject.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CustomerDto {
	private String customerId, customerPw, customerPwcheck, 
			customerNick, customerName, customerPost, 
			customerHost, customerDetailHost, customerTel, 
			customerPhone, customerEmail, customerGrade;
	private Date customerBirth, customerJoin, customerLogin;
	private int customerPoint, customerMoney;
}
