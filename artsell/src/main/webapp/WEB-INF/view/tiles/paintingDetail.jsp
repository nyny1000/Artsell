<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div align="center">
   <h2>작품 정보</h2>
   <table class="table1" width = "70%">
      <tr align="center">
         <td>작품명</td>
         <td><c:out value="${item.itemName}" /></td>
      </tr>
      <tr align="center">
         <td>카테고리</td>
         <td><c:out value="${cateName}" /></td> <!-- 카테고리 이름으로 바꾸기 -->
      </tr>
      <tr align="center">
         <td>경매 시작가</td>
         <td><c:out value="${item.minPrice}" /></td>
      </tr>
      <tr align="center">
         <td>현재 최고가</td>
         <td><c:out value="${item.bestPrice}" /></td>
      </tr>
      <tr align="center">
         <td>화가</td>
         <td><c:out value="${item.artist}" /></td>
      </tr>
      <tr align="center">
         <td>판매자</td>
         <td><c:out value="${item.userId}" /></td>
      </tr>
      <tr align="center">
         <td>마감 기한</td>
         <td><fmt:formatDate value="${item.deadline}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
      </tr>
      <tr align="center">
         <td colspan="2"><img src='<c:url value="${item.picture}" />' width="50%"  /></td>
      </tr>
      <tr align="center">
         <td colspan="2" width="40" height="8"><b>작품설명: </b><c:out value=" ${item.description}" /></td>
      </tr>
   </table>
   <a href="<c:url value="/auction/info">
   		<c:param name="itemId" value="${item.itemId}" /></c:url>">경매 참여</a>

   <c:if test="${isInterested == 0}">
      <a href="<c:url value="/interesting/add">
         <c:param name="itemId" value="${item.itemId}" /></c:url>"> <!-- 고치기 -->
         <img src='<c:url value="/images/iconmonstr-heart-thin-32.png" />' />
      </a>
   </c:if>

   <c:if test="${isInterested == 1}">
      <a href="<c:url value="/interesting/delete2">
         <c:param name="itemId" value="${item.itemId}" /></c:url>"> <!-- 고치기 -->
         <img src='<c:url value="/images/iconmonstr-favorite-3-32.png" />' />
      </a>
   </c:if>
</div>
