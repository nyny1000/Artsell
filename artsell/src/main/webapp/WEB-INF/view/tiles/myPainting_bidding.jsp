<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div align="center" class="itembidding">
		<h2>최소가격의 30% 감소하여 다시 올리시겠습니까?</h2>
		<h3>가격: <c:out value="${minPrice } -> ${newPrice }" /></h3>
		<h3>마감기간:<c:out value="${deadline}"/> </h3>
	
		<a href="<c:url value="/auction/fail/ok" >
		 <c:param name="itemId" value="${itemId}" />
		 <c:param name="minPrice" value="${newPrice}" />
		 <c:param name="deadline" value="${deadline}" /> </c:url>"><input type="button" value="네"/>
		</a>
		
		<a href="<c:url value="/auction/fail/no">
		 <c:param name="itemId" value="${itemId}" /> </c:url>"> <input type="button" value="아니오"/>
		</a>
		
	</div>
