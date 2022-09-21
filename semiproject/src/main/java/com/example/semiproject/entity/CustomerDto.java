package com.example.semiproject.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CustomerDto {
	private String customerId;
	private String customerPw;
	private String customerPwcheck;
	private String customerNick;
	private String customerName;
	private String customerPost;
	private String customerHost;
	private String customerDetailHost;
	private String customerTel;
	private String customerPhone;
	private Date customerBirth;
	private String customerEmail;
	private int customerPoint;
	private int customerMoney;
	private String customerGrade;
	private Date customerJoin;
	private Date customerLogin;
}
