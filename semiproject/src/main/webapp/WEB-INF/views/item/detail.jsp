<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="상품상세정보" name="title"/>
</jsp:include>

<table width="800">
	<tbody>
		<tr>
			<td rowspan="5" width="40%">
				
			</td>
			<td><h1>${itemDto.itemName}</h1></td>
		</tr>
		<tr>
			<td><hr>
				price <fmt:formatNumber value="${itemDto.itemPrice}" pattern="#,##0원"/>
			</td>
		</tr>
		<tr>
			<td>배송비 : 3,000 (70,000원 이상 구매 시 무료)</td>
		</tr>
		<tr>
			<form action="buy">
			<td><hr>
				필수 옵션
				<input type="hidden" name="itemNo">
				색상 <select name="itemColor">
					<option>black</option>
					<option>white</option>
					<option>red</option>
				</select><br>
				사이즈 <select name="itemSize">
					<option>S</option>
					<option>M</option>
					<option>L</option>
				</select><br>
				수량 <input type="number" name="itemCnt" placeholder="1" required><br>
			</td>
		</tr>
			<td>
				총 결제 금액<br>
				얼마
			</td>
		</tr>
		<tr>
			<td>좋아요</td>
			<td>
				<button type="submit">buy</button>
			</td>
			</form>
		</tr>
	</tbody>
</table>

<hr>

${itemDto.itemContent}

<hr>

리뷰


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>