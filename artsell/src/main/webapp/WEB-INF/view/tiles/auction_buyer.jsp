<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<script type="text/javascript">
	
  function maxLengthCheck(object){
    if (object.value.length > object.maxLength){
      object.value = object.value.slice(0, object.maxLength);
    }    
  }
  
</script>
</head>
<div align="center">
   <h2>
      <p>작품명 :
      <c:out value="${item.itemName}" /></p>
      <img src="<c:url value="${item.picture}" />" width="300" /><br>
      경매 시작가:
      <c:out value="${item.minPrice}" />
      <br>
      현재 최고가:
      <c:out value="${item.bestPrice}" />
      
   </h2>
   <p>
   <table class="border">
      <tr bgcolor="#FFD700">
         <th>회원ID</th>
         <th>경매가격</th>
      </tr>
      <c:forEach var="buyer" items="${buyers}">
         <tr>
            <td><c:out value="${buyer.userId}" /></td>
            <td><c:out value="${buyer.myPrice}" /></td>
      </c:forEach>
   </table>
   <p>
   

         <form:form action='<c:url value="/auction/bid" />'
         modelAttribute="auctionItem" method="POST">
         <form:errors cssClass="error" />
         <form:input type="number" min="0" max="2000000000" path="myPrice" />
         
         <form:hidden path="itemId" value="${item.itemId}" />
         <input type="submit" value="입찰" />
     		<%-- <c:out value="${userSession.account.userId}" /> --%> <!-- cnrk -->
     		<br><form:errors path="myPrice" cssClass="error" />
			<c:if test="${bidTry==true}">
			<p>입찰이 성공적으로 완료되었습니다.</p></c:if>

      </form:form>

</div>