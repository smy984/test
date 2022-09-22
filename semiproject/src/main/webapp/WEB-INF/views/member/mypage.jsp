<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="마이페이지" name="title"/>
</jsp:include>

<h1>&lt;MY PAGE&gt;</h1>

<h3>쇼핑몰 가입정보</h3>

<table border="1" width="600">
	<thead>
		<tr>
			<th colspan="2">필수정보</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th align="left">아이디</th>
			<td>
				${dto.customerId}
			</td>
		</tr>
		<tr>
			<th align="left">비밀번호</th>
			<td>
				<a href="#">변경하기</a>
			</td>
		</tr>
		<tr>
			<th align="left">닉네임</th>
			<td>		
				${dto.customerNick}
			</td>
		</tr>
		<tr>
			<th align="left">이름</th>
			<td>
				${dto.customerName}
			</td>
		</tr>
		<tr>
			<th align="left">주소</th>
			<td>
				${dto.customerPost}<br>
				${dto.customerHost}<br>
				${dto.customerDetailHost}
			</td>
		</tr>
		<tr>
			<th align="left">일반전화</th>
			<td>
				${dto.customerTel}
			</td>
		</tr>
		<tr>
			<th align="left">휴대전화</th>
			<td>
				${dto.customerPhone}
			</td>
		</tr>
		<tr>
			<th align="left">생년월일</th>
			<td>
				${dto.customerBirth}
			</td>
		<tr>	
	</tbody>
</table>
<br>
<table border="1" width="600">
	<thead>
		<tr>
			<th colspan="2">추가정보</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th align="left">이메일</th>
			<td>
				${dto.customerEmail}
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2" align="right"><a href="#">정보변경</a></td>
		</tr>
	</tfoot>
</table>
<br>
<br>
<a href="#">탈퇴하기</a>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>