<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="로그인" name="title"/>
</jsp:include>

<h1>&lt;LOGIN&gt;</h1>

<br><br>
<form action="login" method="post">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : 
	<input name="customerId" type="text" required><br><br><br>
	PASSWORD : <input name="customerPw" type="password" required><br><br><br>
	<button type="submit">LOGIN</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>