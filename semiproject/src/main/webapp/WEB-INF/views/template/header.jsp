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
<h1 align="left"><a href="/">쇼핑몰명</a></h1>

<h2>
<form action="#" method="#">
<a href="#">BEST</a>
<a href="#">NEW 5%</a>
<a href="#">outer</a>
<a href="#">top</a>
<a href="#">pants</a>
<a href="#">acc</a>
<c:choose>
	<c:when test="${loginId == null}">
		<a href="/member/join">JOIN US</a>
		<a href="/member/login">LOGIN</a>
	</c:when>
	<c:otherwise>
		<a href="/member/logout">LOGOUT</a>
	</c:otherwise>
</c:choose>
<c:if test="${loginCg == '관리자'}">
	<a href="/admin/">ADMINPAGE</a>
</c:if>
<a href="/member/mypage">MYPAGE</a>
	<input>
	<button>search</button>
<a href="#">cart</a>
</form>
</h2>

<hr>

<c:if test="${loginCg == '관리자'}">

<a href="/item/add">상품 추가</a>
<hr>

</c:if>

</div>

<div align="center" style="min-height:400px">