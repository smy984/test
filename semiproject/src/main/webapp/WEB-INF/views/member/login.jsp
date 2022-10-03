<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="로그인" name="title"/>
</jsp:include>

<h1>LOGIN</h1>

<br><br>
<form action="login" method="post">
	ID : <input name="customerId" type="text" required><br><br><br>
	PASSWORD : <input name="customerPw" type="password" required><br><br><br>
	<button type="submit">LOGIN</button>
</form>

<c:if test="${param.error != null}">
	<h2 style=color:red>잘못된 입력입니다.</h2>
</c:if>

<a href="find">아이디/비밀번호 찾기 →</a><br><br>
<a href="join">회원가입 →</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>