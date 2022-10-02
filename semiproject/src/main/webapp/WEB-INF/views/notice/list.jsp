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
							<fmt:formatDate value="${noticeDto.noticeDate}" pattern="HH:mm"/>
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
	
<!-- 페이징 -->
<c:choose>
	<c:when test="${!vo.isFirst()}">
		<a href="list?p=${vo.firstBlock()}">&laquo;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&laquo;</a>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${vo.hasPrev()}">	
		<a href="list?p=${vo.preBlock()}">&lt;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&lt;</a>
	</c:otherwise>
</c:choose>
 
<c:forEach var="i" begin="${vo.startBlock()}" end="${vo.endBlock()}" step="1">
	<a href="list?p=${i}">${i}</a> 
</c:forEach>

<c:choose>
	<c:when test="${vo.hasNext()}">
		<a href="list?p=${vo.nextBlock()}">&gt;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&gt;</A>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${!vo.isLast()}">
		<a href="list?p=${vo.lastBlock()}">&raquo;</a>
	</c:when>
	<c:otherwise>
		<a href="#">&raquo;</A>
	</c:otherwise>
</c:choose>

<form action="list" method="get">
	<select name="type">
		<option value="notice_title">제목</option>
		<option value="notice_content">내용</option>
	</select>
	<input type="search" name="keyword">
	<button type="submit">찾기</button>
</form>

</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>