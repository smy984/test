<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="공지사항" name="title"/>
</jsp:include>

<h1>NOTICE</h1>

<table border="1" width="800">
	<tbody>
		<tr>
			<th>제목</th>
			<td colspan="5">${noticeDto.noticeTitle}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td width="40%">${noticeDto.adminId}</td>
			<th>작성일</th>
			<td width="15%">${noticeDto.noticeDate}</td>
			<th>조회수</th>
			<td width="15%">${noticeDto.noticeRead}</td>
		</tr>
		<tr>
			<th height="300">내용</th>
			<td valign="top" colspan="5">${noticeDto.noticeContent}</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6" align="right">
				<a href="list">목록</a>
				<a href="edit?noticeNo=${noticeDto.noticeNo}">수정</a>
				<a href="delete?noticeNo=${noticeDto.noticeNo}">삭제</a>
			</td>
		</tr>
	</tfoot>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>