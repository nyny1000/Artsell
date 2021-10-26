<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<h2>낙찰되었습니다.</h2>
	<div class="bg">
		<ul class="align">
			<li><b>작품명</b> : <c:out value="${order.itemName}" /></li>
			<li><b>가격</b> :<c:out value="${order.myPrice}" />원</li>
		</ul>
	</div>
	<p>
	<form action='<c:url value="/auction/destination" />'>
		<table class="border">
			<tr id="c1">
				<td colspan="2" ><a href="<c:url value="/auction/auctioned_buyer_addressCheck" />">회원정보와 동일</a></td>
			</tr>
				
			<tr bgcolor="#FFD700">
				<th colspan="2">배송정보</th>
			</tr>
			<tr>
				<td class="bold">아이디</td>
				<td><c:out value="${order.userId}" /></td>
			</tr>
			<tr>
				<td class="bold">전화번호</td>
				<td><c:out value="${order.phone}" /></td>
			</tr>
			<tr>
				<td class="bold">주소</td>
				<td><input type="text" value="${order.address1}" name="address1" id="member_addr" onclick="findAddr()" readonly/>
				<form:errors path="order.address1" cssClass="error" /><br>
				<input type="text" value="${order.address2}" name="address2"/>
				<form:errors path="order.address2" cssClass="error" /><br>
				</td>
				
			</tr>
			<tr>
				<td class="bold">카드번호</td>
				<td><c:out value="${order.credit}" /></td>
			</tr>	
		</table>
		<p />
		<input type="submit" value="다음"/>
		<a href="<c:url value="/auction/success/cancel"><c:param name="itemId" value="${order.itemId}"/></c:url>">
			<input type="button" value="낙찰포기"/></a>
	</form>
</div>