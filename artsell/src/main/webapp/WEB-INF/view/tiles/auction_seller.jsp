<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h2>작품명 : <c:out value="${item.itemName}" /> </h2>
	<p>
	<img src="<c:url value="${item.picture}" />" width="300" /><br>

	<table class="border">
		<tr bgcolor="#FFD700">
			<th>회원ID</th>
			<th>경매가격</th>
		</tr>
		<c:forEach var="buyer" items="${buyers}">
		<tr>
			<td>
				<c:out value="${buyer.userId}" />
			</td>
			<td>
				<c:out value="${buyer.myPrice}" />
			</td>
		</c:forEach>
	</table>
	<p>
	<a href="<c:url value='/auction/success'><c:param name="itemId" value="${item.itemId}" /></c:url>"><input type="button" value="낙찰하기"/></a>
</div>
