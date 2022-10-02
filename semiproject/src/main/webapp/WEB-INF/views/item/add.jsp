<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="상품추가" name="title"/>
</jsp:include>

<h1>상품 추가</h1>

<form action="add" method="post">
	상품명
	<input type="text" name="itemName" required><br>
	정보
	<input type="text" name="itemMemo" required><br>
	가격
	<input type="number" name="itemPrice" required><br>
	색상
	<input type="text" name="itemColor" required><br>
	사이즈
	<select name="itemSize">
		<option>XS</option>
		<option>S</option>
		<option>M</option>
		<option>L</option>
		<option>XL</option>
		<option>XXL</option>
	</select><br>
	분류
	<select name="cateCode">
		<optgroup label="아우터">
			<option value="101">자켓</option>
			<option value="102">코트</option>
			<option value="103">가디건</option>
			<option value="104">패딩</option>
		</optgroup>
		<optgroup label="상의">
			<option value="201">민소매</option>
			<option value="202">티셔츠</option>
			<option value="203">맨투맨</option>
			<option value="204">니트</option>
			<option value="205">블라우스</option>
		</optgroup>
		<optgroup label="하의">
			<option value="301">청바지</option>
			<option value="302">면바지</option>
			<option value="303">슬랙스</option>
		</optgroup>
		<optgroup label="치마">
			<option value="401">숏기장</option>
			<option value="402">롱기장</option>
		</optgroup>
		<optgroup label="드레스">
			<option value="501">원피스</option>
		</optgroup>
		<optgroup label="기타">
			<option value="601">쥬얼리</option>
			<option value="602">모자</option>
			<option value="603">가방</option>
			<option value="604">신발</option>
			<option value="605">양말</option>
		</optgroup>
	</select><br>
	상세정보
	<textarea name="itemContent" rows="15" cols="80"></textarea><br>
	<button type="submit">등록</button>	
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>