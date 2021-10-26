<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h2>구매되었습니다.</h2>
	<div class="bg">
	<ul class="align">
		<li><b>작품명</b> : <c:out value="${auctionedItem.itemName}" /> </li>
		<li><b>작품사진</b> : <img src="<c:url value="${auctionedItem.picture}" />"  width="200" height="150" /></li>
		<li><b>가격</b> : <c:out value="${auctionedItem.auctionedPrice}" />원</li>
		<li><b>결제시각</b> : <c:out value="${auctionedItem.sellDate}" /></li>
		<li><b>구매자ID</b> : <c:out value="${userSession.account.userId}" /></li>
		<li><b>판매자ID</b> : <c:out value="${auctionedItem.userId}" /></li>
		<li><b>배달주소</b> : <c:out value="${auctionedItem.destination1}" /> 
		<c:out value="${auctionedItem.destination2}" /></li>
	</ul>
	<p>
	</div>
	<p><a href="<c:url value='/auction/list' />"><input type="button" value="확인"/></a></p>	
</div>