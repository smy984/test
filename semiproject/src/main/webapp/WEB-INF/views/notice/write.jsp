<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="공지사항" name="title"/>
</jsp:include>

<h1>NOTICE</h1>

<form action="write" method="post">
<table border="1" width="600">
	<tbody>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="noticeTitle" required>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td width="40%">
				<input type="text" name="adimId" value="${loginId}" readonly>
			</td>	
		</tr>
		<tr>
			<th>글머리</th>
			<td>
				<select name="noticeHead">
					<option>긴급</option>
					<option>이벤트</option>
				</select>
			</td>
		<tr>
			<th height="300">내용</th>
			<td valign="top">
				<textarea rows="20" cols="55"></textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2" align="right">
				<a href="list">이전</a>
				<button type="submit">등록</button>
			</td>
		</tr>
	</tfoot>
</table>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>