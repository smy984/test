<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원가입" name="title"/>
</jsp:include>

<h1>&lt;JOIN US&gt;</h1>

<form action="join" method="post">
<h3>기본정보</h3>
* 필수 입력 사항
<table border="1" width="600">
	<tbody>
		<tr>
			<th align="left">아이디 *</th>
			<td>
				<input name="customerId" type="text" required>(영문 소문자/숫자, 5~20자)
			</td>
		</tr>
		<tr>
			<th align="left">비밀번호 *</th>
			<td>
				<input name="customerPw" type="password" required>(영문 대소문자/숫자/특수[!@#$], 8~26)
			</td>
		</tr>
		<tr>
			<th align="left">비밀번호 확인 *</th>
			<td>
				<input name="customerPwcheck" type="password" required>
			</td>
		</tr>
		<tr>
			<th align="left">닉네임 *</th>
			<td>		
				<input name="customerNick" type="text" required>
			</td>
		</tr>
		<tr>
			<th align="left">이름 *</th>
			<td>
				<input name="customerName" type="text" required>
			</td>
		</tr>
		<tr>
			<th align="left">주소 *</th>
			<td>
				<input name="customerPost" type="text" maxlength="6" size="6" placeholder="우편번호" required><br>
				<input name="customerHost" type="text" placeholder="기본주소" required><br>
				<input name="customerDetailHost" placeholder="상세주소" type="text">
			</td>
		</tr>
		<tr>
			<th align="left">일반전화</th>
			<td>
				<input name="customerTel" type="text">
			</td>
		</tr>
		<tr>
			<th align="left">휴대전화 *</th>
			<td>
				<input name="customerPhone" type="text" required>
			</td>
		</tr>
		<tr>
			<th align="left">생년월일 *</th>
			<td>
				<input name="customerBirth" type="date" required>
			</td>
		<tr>	
	</tbody>
</table>
<br>
<br>
<h3>추가정보</h3>
<table border="1" width="600">
	<tbody>
		<tr>
			<th align="left">이메일</th>
			<td>
				<input name="customerEmail" type="text">
			</td>
		</tr>
	</tbody>
</table>	

<br><br>
<button type="submit">JOIN</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>