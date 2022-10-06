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

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/commons.css">
<link rel="stylesheet" type="text/css" href="/css/layout.css">

<!-- <link rel="stylesheet" type="text/css" href="/css/test.css"> -->

<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"/>


</head>

<body>
<div class="row">
	<h1><a class="logo left" href="/">쇼핑몰명</a></h1>
</div>

<nav class="float-container">
	<form action="#" method="#">
	<ul class="dropdown-menu">
		<li class="float-left"><a href="/item/list">BEST</a></li>
		<li class="float-left"><a href="#">NEW 5%</a></li>
		<li class="float-left">
			<a href="#">outer</a>
			<ul>
				<li><a href="#">자켓</a></li>
				<li><a href="#">코트</a></li>
				<li><a href="#">가디건</a></li>
				<li><a href="#">패딩</a></li>
			</ul>
		</li>
		<li class="float-left">
			<a href="#">top</a>
			<ul>
				<li><a href="#">민소매</a></li>
				<li><a href="#">티셔츠</a></li>
				<li><a href="#">맨투맨</a></li>
				<li><a href="#">니트</a></li>
				<li><a href="#">블라우스</a></li>
			</ul>
		</li>
		<li class="float-left">
			<a href="#">pants</a>
			<ul>
				<li><a href="#">청바지</a></li>
				<li><a href="#">면바지</a></li>
				<li><a href="#">슬랙스</a></li>
			</ul>
		</li>
		<li class="float-left">
			<a href="#">skirt</a>
			<ul>
				<li><a href="#">숏치마</a></li>
				<li><a href="#">롱치마</a></li>
			</ul>
		</li>
		<li class="float-left">
			<a href="#">dress</a>
			<ul>
				<li><a href="#">원피스</a></li>
			</ul>
		</li>
		<li class="float-left">
			<a href="#">acc</a>
			<ul>
				<li><a href="#">쥬얼리</a></li>
				<li><a href="#">모자</a></li>
				<li><a href="#">가방</a></li>
				<li><a href="#">신발</a></li>
				<li><a href="#">양말</a></li>
			</ul>
		</li>
			<li  class="float-right"><a href="#">
				<i class="fa-solid fa-cart-shopping"></i>
			</a></li>
			<button class="float-right">search</button>
			<input class="float-right">
			<li class="float-right"><a href="/member/mypage">MYPAGE</a></li>
		<c:if test="${loginCg == '관리자'}">
			<li class="float-right"><a href="/admin/">ADMINPAGE</a></li>
		</c:if>
		<c:choose>
			<c:when test="${loginId == null}">
				<li class="float-right"><a href="/member/login">LOGIN</a></li>
				<li class="float-right"><a href="/member/join">JOIN US</a></li>
			</c:when>
			<c:otherwise>
				<li class="float-right"><a href="/member/logout">LOGOUT</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
	</form>
	
</nav>
