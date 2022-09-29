<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="공지사항" name="title"/>
</jsp:include>



<div class="container-1200 mt-40">

	<div class="row center">
		<h1>NOTICE</h1>
	</div>
	<table border="1" width="1200">
		<thead>
			<tr>
				<th width="5%">No.</th>
				<th width="70%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="noticeDto" items="${noticeList}">
				<tr align="center">
					<td>${noticeDto.noticeNo}</td>
					<td align="left">
						<a href="detail?noticeNo=${noticeDto.noticeNo}">${noticeDto.noticeTitle}</a>
					</td>
					<td>${noticeDto.adminId}</td>
					<td>
						<jsp:useBean id="now" class="java.util.Date"/>
						<fmt:formatDate var="today" value="${now}" pattern="yyyy-MM-dd"/>
						<fmt:formatDate var="writeTime" value="${noticeDto.noticeDate}" pattern="yyyy-MM-dd"/>
						<c:choose>
						<c:when test="${today == writeTime}">
							<fmt:formatDate value="${noticeDto.noticeDate}" pattern="hh:mm"/>
						</c:when>
						<c:otherwise>
							${writeTime}
						</c:otherwise>
						</c:choose>
					</td>
					<td>${noticeDto.noticeRead}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" align="right">
					<a href="write">작성하기</a>
				</td>
			</tr>
		</tfoot>
	</table>
	<form action="list" method="get">
		<select name="type">
			<option value="notice_title">제목</option>
			<option value="notice_content">내용</option>
		</select>
		<input type="search" name="keyword">
		<button type="submit">찾기</button>
	</form>
	
&lt; 1 2 3 4 5 &gt;

</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>