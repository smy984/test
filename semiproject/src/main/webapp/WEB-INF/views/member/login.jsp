<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="로그인" name="title"/>
</jsp:include>

<div class="container-300 mt-40">

<div class="row center">
	<h1>LOGIN</h1>
</div>

<form action="login" method="post">
<div class="row left">
	<label>ID</label>
	<input class="input w-100" name="customerId" type="text" required autocomplete="off">
</div>
<div class="row left">
	<label>PASSWORD</label>
	<input class="input w-100" name="customerPw" type="password" required autocomplete="off">
</div>

<div class="row center mt-50 mb-30">
	<button class="btn btn-neutral" type="submit">LOGIN</button>
</div>
</form>

<div class="row center mb-30">
	<a href="find">아이디/비밀번호 찾기 →</a>
</div>
<div class="row center mb-50">
	<a href="join">회원가입 →</a>
</div>

<div class="row center">
	<c:if test="${param.error != null}">
		<h3 style=color:darkred>잘못된 입력입니다.</h3>
	</c:if>
</div>
	
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>