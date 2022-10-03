<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원찾기" name="title"/>
</jsp:include>

<h1>비밀번호 초기화 완료!</h1>
초기 비밀번호 : customer1234<br>

<a href="login">로그인 →</a>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>