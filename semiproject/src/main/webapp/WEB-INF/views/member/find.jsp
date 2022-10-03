<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원찾기" name="title"/>
</jsp:include>

<form action="find" method="post">
	ID : <input type="text" name="insertId" required><br>
	비밀번호 찾기 질문 : 나의 보물 1호는?<br>
	비밀번호 찾기 답변 : <input type="text" name="answer" required><br>
	<button type="submit">입력</button>
</form>

<c:if test="${param.error != null}">
	잘못된 정보입니다.
</c:if>	



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>