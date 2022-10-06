<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="상품페이지" name="title"/>
</jsp:include>

<div class="container-1050 mt-40 mb-40">
	
	<div class="row center mb-40">
		<h1>BEST</h1>
	</div>
	<hr>
	<div class="row flex mt-40">
		<c:forEach var="itemDto" items="${itemList}" varStatus="status">
			<div>
				<div>best${status.count}</div>
				<div class="center">
					<a class="" href="detail?itemNo=${itemDto.itemNo}">
						<img src="download?itemNo=${itemDto.itemNo}" width="320" height="420">
					</a>
				</div>
				<div class="float-container">
					<div class="float-left">${itemDto.itemName}</div>
					<div class="float-right">
						<fmt:formatNumber value="${itemDto.itemPrice}" pattern="#,##0원"/>
					</div>
				</div>
				<div>${itemDto.itemMemo}</div>
			</div>
		</c:forEach>
	</div>

</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>