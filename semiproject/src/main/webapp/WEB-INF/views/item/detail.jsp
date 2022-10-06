<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="상품상세정보" name="title"/>
</jsp:include>

<div class="container-700 mt-40">

	<div class="float-container">
	
		<div class="float-left w-50">
			<div class="row center">
				<img class="w-100" src="download?itemNo=${itemDto.itemNo}">
			</div>
			<div class="row right">
				<a href="like?itemNo=${itemDto.itemNo}">
					<c:choose>
						<c:when test="${isLike == null}">
							<i class="fa-regular fa-heart"></i>
						</c:when>
						<c:when test="${isLike == true}">
							<i class="fa-solid fa-heart"></i>
						</c:when>
						<c:otherwise>
							<i class="fa-regular fa-heart"></i>
						</c:otherwise>
					</c:choose> 
						
				</a>
			</div>			
		</div>
		
		<div class="float-left w-50">
			<div class="row left">
				<h1>${itemDto.itemName}</h1>
			</div>
			<hr>
			<div class="row left">
				price <fmt:formatNumber value="${itemDto.itemPrice}" pattern="#,##0원"/>
			</div>
			<div class="row left">
				배송비 : 3,000 (70,000원 이상 구매 시 무료)
			</div>
			<hr>
			<div class="row left">
				필수 옵션
			</div>
			<form action="buy">
			<div class="row left">
				<input type="hidden" name="itemNo">
			</div>
			<div class="row left">
				색상 <select name="itemColor">
					<option>black</option>
					<option>white</option>
					<option>red</option>
				</select>
			</div>
			<div class="row left">
				사이즈 <select name="itemSize">
					<option>S</option>
					<option>M</option>
					<option>L</option>
				</select><br>
			</div>
			<div class="row left">
				수량 <input type="number" name="itemCnt" placeholder="1" required><br>
			</div>
			<div class="row left">
				총 결제 금액<br>
			</div>
			<div class="row center">
				얼마
			</div>
			<div class="row right">
				<button class="btn btn-neutral" type="submit">buy</button>
			</div>
			</form>
		</div>
		
	</div>

<div class="row center">
	${itemDto.itemContent}
</div>

<hr>

<div class="row left">
	리뷰
</div>

</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>