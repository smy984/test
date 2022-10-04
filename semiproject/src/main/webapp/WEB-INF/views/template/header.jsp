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
<div>
	<h1><a class="logo left" href="/">쇼핑몰명</a></h1>
</div>

<div>
	<form action="#" method="#">
	<ul class="dropdown-menu">
		<li><a href="#">BEST</a></li>
		<li><a href="#">NEW 5%</a></li>
		<li>
			<a href="#">outer</a>
			<ul>
				<li><a href="#">자켓</a></li>
				<li><a href="#">코트</a></li>
				<li><a href="#">가디건</a></li>
				<li><a href="#">패딩</a></li>
			</ul>
		</li>
		<li>
			<a href="#">top</a>
			<ul>
				<li><a href="#">민소매</a></li>
				<li><a href="#">티셔츠</a></li>
				<li><a href="#">맨투맨</a></li>
				<li><a href="#">니트</a></li>
				<li><a href="#">블라우스</a></li>
			</ul>
		</li>
		<li>
			<a href="#">pants</a>
			<ul>
				<li><a href="#">청바지</a></li>
				<li><a href="#">면바지</a></li>
				<li><a href="#">슬랙스</a></li>
			</ul>
		</li>
		<li>
			<a href="#">skirt</a>
			<ul>
				<li><a href="#">숏치마</a></li>
				<li><a href="#">롱치마</a></li>
			</ul>
		</li>
		<li>
			<a href="#">dress</a>
			<ul>
				<li><a href="#">원피스</a></li>
			</ul>
		</li>
		<li>
			<a href="#">acc</a>
			<ul>
				<li><a href="#">쥬얼리</a></li>
				<li><a href="#">모자</a></li>
				<li><a href="#">가방</a></li>
				<li><a href="#">신발</a></li>
				<li><a href="#">양말</a></li>
			</ul>
		</li>
		<c:choose>
			<c:when test="${loginId == null}">
				<li><a href="/member/join">JOIN US</a></li>
				<li><a href="/member/login">LOGIN</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/member/logout">LOGOUT</a></li>
			</c:otherwise>
		</c:choose>
		<c:if test="${loginCg == '관리자'}">
			<li><a href="/admin/">ADMINPAGE</a></li>
		</c:if>
			<li><a href="/member/mypage">MYPAGE</a></li>
			<input>
			<button>search</button>
			<li class="right-menu"><a href="#">cart</a></li>
		</ul>
	</form>
	
	<c:if test="${loginCg == '관리자'}">
	
	<a href="/item/add">상품 추가</a>
	<hr>
	
	</c:if>
</div>

<div align="center" style="min-height:400px">