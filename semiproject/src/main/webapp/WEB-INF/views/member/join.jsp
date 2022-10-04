<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="회원가입" name="title"/>
</jsp:include>

<div class="container-800 mt-40">

<div class="row center">
	<h1>JOIN US</h1>
</div>

<form action="join" method="post">
<div class="row left">
	<h3>기본정보</h3>
</div>
<div class="row right">
	* 필수 입력 사항
</div>
<div class="row mb-50">
<table class="table table-slit">
	<tbody>
		<tr>
			<th align="left" width="20%">아이디 *</th>
			<td>
				<input class="input input-underline w-100" name="customerId" type="text" required 
							autocomplete="off" pattern="^[a-z][a-z0-9_-]{4,19}$"></td>
			<td width="35%">(영문 소문자/숫자, 5~20자)</td>
		</tr>
		<tr>
			<th align="left">비밀번호 *</th>
			<td>
				<input class="input input-underline w-100" name="customerPw" type="password" required 
							autocomplete="off" pattern="^[a-zA-Z0-9!@#$]{8,16}$"></td>
			<td>(영문 대소문자/숫자/특수[!@#$], 8~26)</td>
		</tr>
		<tr>
			<th align="left">비밀번호 확인 *</th>
			<td>
				<input class="input input-underline w-100" name="customerPwcheck" type="password" required 
							autocomplete="off" pattern="^[a-zA-Z0-9!@#$]{8,16}$"></td>
			<td></td>
		</tr>
		<tr>
			<th align="left">비밀번호 찾기 질문</th>
			<td>나의 보물 1호는?</td>
		</tr>
		<tr>
			<th align="left">비밀번호 찾기 답변 *</th>
			<td>
				<input class="input input-underline w-100" name="customerPwsearch" type="text" 
							required autocomplete="off">
			</td>
			<td></td>
		</tr>
		<tr>
			<th align="left">닉네임 *</th>
			<td>		
				<input class="input input-underline w-100" name="customerNick" type="text" required 
							autocomplete="off" pattern="^[가-힣][가-힣0-9]{0,9}$">
			</td>
			<td></td>
		</tr>
		<tr>
			<th align="left">이름 *</th>
			<td>
				<input class="input input-underline w-100" name="customerName" type="text" 
							required autocomplete="off">
			</td>
			<td></td>
		</tr>
		<tr>
			<th valign="top" align="left">주소 *</th>
			<td>
				<input class="input input-underline" name="customerPost" type="text" 
							maxlength="6" size="7" placeholder="우편번호" required><br>
				<input class="input input-underline w-100" name="customerHost" type="text" 
							placeholder="기본주소" required><br>
				<input class="input input-underline w-100" name="customerDetailHost" 
							type="text" placeholder="상세주소">
			</td>
		</tr>
		<tr>
			<th align="left">휴대전화 *</th>
			<td>
				<input class="input input-underline w-100" name="customerPhone" type="text" 
							required autocomplete="off">
			</td>
		</tr>
		<tr>
			<th align="left">생년월일 *</th>
			<td>
				<input class="input input-underline w-100" name="customerBirth" type="date" 
							required autocomplete="off">
			</td>
		</tr>	
	</tbody>
</table>
</div>

<div class="row left mt-50 mb-40">
	<h3>추가정보</h3>
</div class="row">
<table class="table table-slit">
	<tbody>
		<tr>
			<th align="left" width="20%">이메일</th>
			<td width="45%">
				<input class="input input-underline w-100" name="customerEmail" 
							type="text" autocomplete="off">
			</td>
			<td></td>
		</tr>
		<tr>
			<th align="left">일반전화</th>
			<td>
				<input class="input input-underline w-100" name="customerTel" 
							type="text" autocomplete="off">
			</td>
		</tr>
	</tbody>
</table>	

<br><br>
<button class="btn btn-neutral" type="submit">JOIN</button>
</form>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>