<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="관리자페이지" name="title"/>
</jsp:include>

<table border="1" width="400">
	<thead>
		<tr>
			<th colspan="3">상품등록 리스트</th>
		</tr>
		<tr>
			<th>No.</th>
			<th>상품명</th>
			<th>비고</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="itemDto" items="${itemList}">
			<tr>
				<td>${itemDto.itemNo}</td>
				<td width="80%">${itemDto.itemName}</td>
				<td>
					<a href="../item/detail?itemNo=${itemDto.itemNo}">→</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>