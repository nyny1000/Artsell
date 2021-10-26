
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div align="center">
   

      <h1>내 작품 관리</h1>
      <table class="table1">
         <tr align="center" bgcolor="#D5D5D5">
            <th>작품명</th>
            <th width="200px">작품사진</th>
            <th>
               <form action='<c:url value="/stateTypeSelect_mypaintingList"/>'>
                  <select name="stateT2"> 
                     <option value="3" <c:if test="${key == 3}">selected</c:if> >state</option>
                     <option value="0" <c:if test="${key == 0}">selected</c:if> >경매중</option>
                     <option value="1" <c:if test="${key == 1}">selected</c:if> >낙찰대기중</option>
                     <option value="2" <c:if test="${key == 2}">selected</c:if> >결제완료</option>
                     <option value="5" <c:if test="${key == 5}">selected</c:if> >유찰</option>
                  </select>
                  <input type="submit" value="선택"/>
               </form>   
            </th>
            <th>&nbsp;</th>
         </tr>
         
         <c:if test="${myPaintList.pageList.size() == 0}">
            <tr align="center"><td colspan="4"><c:out value="목록이 없습니다." /></td></tr>
         </c:if>
         <c:if test="${myPaintList.pageList.size() != 0}">
         <form>
         <c:forEach var="myItem" items="${myPaintList.pageList}">
            <tr align="center">
               <td><a
                  href="<c:url value="/shop/viewItem">
                  <c:param name="itemId" value="${myItem.itemId}" /></c:url>">
                     <c:out value="${myItem.itemName}" />
               </a></td>
               <td><a
                  href="<c:url value="/shop/viewItem">
                  <c:param name="itemId" value="${myItem.itemId}" /></c:url>">
                     <img src="<c:url value="${myItem.picture}" />" width="200" height="150" />
               </a></td>
               
               <td>
                  <c:if test="${myItem.state == 0}">
                     <a href="<c:url value="/auction/info_seller">
                        <c:param name="itemId" value="${myItem.itemId}" /></c:url>">
                        경매중</a>
                  </c:if>
                  <c:if test="${myItem.state == 1}">낙찰대기중</c:if>
                  <c:if test="${myItem.state == 2}">
                     <a href="<c:url value="/auction/seller"> <!-- 수정 -->
                        <c:param name="itemId" value="${myItem.itemId}" /></c:url>">
                        결제완료</a>
                  </c:if>
                  <c:if test="${myItem.state == 5}">
                     <a href="<c:url value="/auction/fail">
                        <c:param name="itemId" value="${myItem.itemId}" /></c:url>">
                        유찰</a>
                  </c:if>
               </td>
               
               <td><a
                  href='<c:url value="/myitem/delete">
                     <c:param name="itemId" value="${myItem.itemId}"/></c:url>'>
                     <input type="button" value="그림삭제" />
               </a></td>
            </tr>
         </c:forEach>
         </form>
         </c:if>
      </table>
      <c:if test="${!myPaintList.firstPage}">
         <a
            href='<c:url value="/myitem/list2">
         <c:param name="page" value="previous"/></c:url>'>
            <B>&lt;&lt; Prev</B>
         </a>
      </c:if>
      <c:if test="${!myPaintList.lastPage}">
         <a
            href='<c:url value="/myitem/list2">
          <c:param name="page" value="next"/></c:url>'>
            <B>Next &gt;&gt;</B>
         </a>
      </c:if>
   
</div>