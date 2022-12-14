<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="관리자페이지" name="title"/>
</jsp:include>

<aside>
	<div class="sidebar-menu row">
		<a href="/item/add">상품 관리</a>
	</div>
	<div class="sidebar-menu row">
		<a href="/member/list">회원 정보</a>
	</div>
</aside>

<section>
<div class="float-container">
<div class="float-left w-50">
	<table class="table table-slit">
		<thead>
			<tr>
				<th colspan="3">신상품 리스트(최신순)</th>
			</tr>
			<tr>
				<th>No.</th>
				<th>상품명</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="itemDto" items="${itemList}">
				<tr align="center">
					<td>${itemDto.itemNo}</td>
					<td align="left" width="80%">${itemDto.itemName}</td>
					<td width="10%">
						<a href="../item/detail?itemNo=${itemDto.itemNo}">→</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="float-left w-50">
</div>
</div>
</section>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>