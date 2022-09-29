<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>
	<c:choose>
		<c:when test="${param.title != null}">
			${param.title}
		</c:when>
		<c:otherwise>
			홈페이지
		</c:otherwise>
	</c:choose>
</title>

<link rel="stylesheet" type="text/css" href="/css/commons.css">

</head>
<body>
<div align="center">
<h1 align="left"><a href="/">홈</a></h1>

<h2>
<form action="#" method="#">
<a href="#">BEST</a>
<a href="#">NEW 5%</a>
<a href="#">outer</a>
<a href="#">top</a>
<a href="#">pants</a>
<a href="#">acc</a>
<a href="/member/join">회원가입</a>
<a href="/member/login">로그인</a>
<a href="/member/logout">로그아웃</a>
<a href="/member/mypage">마이페이지</a>
	<input>
	<button>search</button>
<a href="#">장바구니</a>
</form>
	
</h2>
</div>

<hr>
<div align="center" style="min-height:400px">