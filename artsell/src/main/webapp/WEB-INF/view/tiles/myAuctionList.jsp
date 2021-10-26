<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div align="center">

		<h1>내 경매 참여 목록</h1>
		<table class="table1">
			<tr align="center" bgcolor="#D5D5D5">
				<th>작품ID</th>
				<th>작품사진</th>
				<th>경매 마감일</th>
				<th>최고가</th>
				<th>내 금액</th>
				<th>
					<form action='<c:url value="/stateTypeSelect"/>'>
						<select name="stateT" id="stateSelect"> 
							<option value="2" <c:if test="${key == 2}">selected</c:if> >state</option>
							<option value="0" <c:if test="${key == 0}">selected</c:if> >경매참여중</option>
							<option value="1" <c:if test="${key == 1}">selected</c:if> >결제대기중</option>
							<option value="3" <c:if test="${key == 3}">selected</c:if> >경매실패</option>
						</select>
						<input type="submit" value="선택"/>
					</form>
				</th>
			</tr>
			
			<c:if test="${itemList1.pageList.size() == 0}">
				<tr align="center"><td colspan="6"><c:out value="목록이 없습니다." /></td></tr>
			</c:if>
			<c:if test="${itemList1.pageList.size() != 0}">
				<c:forEach var="itemList1" items="${itemList1.pageList}">
					<tr align="center">
						<td>
						<c:if test="${itemList1.state == 0}">
						<a href="<c:url value="/shop/viewItem">
						<c:param name="itemId" value="${itemList1.itemId}" /></c:url>">
						<c:out value="${itemList1.itemId}" /></a>
						</c:if>
						<c:if test="${itemList1.state != 0}">
						<c:out value="${itemList1.itemId}" />
						</c:if>
						
						</td>
						<td>
						<c:if test="${itemList1.state == 0}">
						<a href="<c:url value="/shop/viewItem">
						<c:param name="itemId" value="${itemList1.itemId}" /></c:url>">
						<img src="<c:url value="${itemList1.picture}" />"  width="200" height="150" /></a>
						</c:if>
						
						<c:if test="${itemList1.state != 0}">
						<img src="<c:url value="${itemList1.picture}" />"  width="200" height="150" />
						</c:if>
						</td>
						
						<td><fmt:formatDate value="${itemList1.deadline}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><c:out value="${itemList1.bestPrice}" /></td>
						<td><c:out value="${itemList1.myPrice}" /></td>
						<td><c:if test="${itemList1.state == 0}">
						<a href="<c:url value="/auction/info">
							<c:param name="itemId" value="${itemList1.itemId}" /></c:url>">
							경매참여중</a></c:if>
						<c:if test="${itemList1.state == 1}">
						<a href="<c:url value="/auction/auctioned_buyer">
							<c:param name="itemId" value="${itemList1.itemId}" /></c:url>">
							결제대기중</a></c:if>
						<c:if test="${itemList1.state == 3}">경매실패</c:if></td>	
					</tr>
				</c:forEach>
			</c:if>
				
		</table>
		<c:if test="${!itemList1.firstPage}">
					<a href="<c:url value="/auction/listauction">
						<c:param name="page" value="previous" /></c:url>">
				   			<B>&lt;&lt; Prev</B></a>
		</c:if>
		<c:if test="${!itemList1.lastPage}">
			<a href="<c:url value="/auction/listauction">
					<c:param name="page" value="next" /></c:url>">
				   			<B>Next &gt;&gt;</B></a>
		</c:if>

	<form>
		
		<h1>내 경매 낙찰 목록</h1>
		<table class="table1">
			<tr align="center" bgcolor="#D5D5D5">
				<th>작품ID</th>
				<th>작품사진</th>
				<th>경매 마감일</th>
				<th>낙찰가격</th>
				<th>&nbsp;</th>
			</tr>
			
			<c:if test="${itemList2.pageList.size() == 0}">
				<tr align="center"><td colspan="5"><c:out value="목록이 없습니다." /></td></tr>
			</c:if>
			<c:if test="${itemList2.pageList.size() != 0}">
				<c:forEach var="itemList2" items="${itemList2.pageList}">
					<tr align="center">
						<td><c:out value="${itemList2.itemId}" /></td>
						<td><img src="<c:url value="${itemList2.picture}" />"  width="200" height="150" /></td>
						<td><fmt:formatDate value="${itemList2.deadline}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><c:out value="${itemList2.auctionedPrice}" /></td>
						<td><a href="<c:url value="/auction/sell_buyer">
							<c:param name="itemId" value="${itemList2.itemId}" /></c:url>">
							결제완료</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${!itemList2.firstPage}">
			<a href="<c:url value="/auction/listauctioned">
				<c:param name="page" value="previous" /></c:url>">
				   			<B>&lt;&lt; Prev</B></a>
		</c:if>
		<c:if test="${!itemList2.lastPage}">
			<a href="<c:url value="/auction/listauctioned">
				<c:param name="page" value="next" /></c:url>">
				   	<B>Next &gt;&gt;</B></a>
		</c:if>
	</form>
</div>