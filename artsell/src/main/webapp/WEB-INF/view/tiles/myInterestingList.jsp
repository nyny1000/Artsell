<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div align="center">
	<form>
		<h1>나의 찜 목록</h1>
		<table class="table1">
			<tr align="center" bgcolor="#D5D5D5">
				<th>작품명</th>
				<th>작품사진</th>
				<th>경매 마감일</th>
				<th>최고가</th>
				<th>&nbsp;</th>
				<th>삭제</th>
			</tr>
			<c:if test="${interestList.pageList.size() == 0}">
				<tr align="center"><td colspan="7"><c:out value="목록이 없습니다." /></td></tr>
			</c:if>
			<c:if test="${interestList.pageList.size() != 0}">
				
				<c:forEach var="interestItem" items="${interestList.pageList}">
					<tr align="center">
						<td><a
							href="<c:url value="/shop/viewItem">
							<c:param name="itemId" value="${interestItem.itemId}" /></c:url>">
								<c:out value="${interestItem.itemName}" />
						</a></td>
						<td><a
							href="<c:url value="/shop/viewItem">
							<c:param name="itemId" value="${interestItem.itemId}" /></c:url>">
								<img src="<c:url value="${interestItem.picture}" />"  width="200" height="150" />
						</a></td>
						<td><fmt:formatDate value="${interestItem.deadline}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><c:out value="${interestItem.bestPrice}" /></td>
						<td><a
							href='<c:url value="/auction/info">
	            		<c:param name="itemId" value="${interestItem.itemId}"/></c:url>'>
								<c:out value="경매참여" />
						</a></td>
	
						<td><a
							href='<c:url value="/interesting/delete">
				  <c:param name="interItemId" value="${interestItem.itemId}"/></c:url>'>
								<c:out value="삭제하기" />
						</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
		<c:if test="${!interestList.firstPage}">
			<a
				href='<c:url value="/interesting/list2">
		    <c:param name="page" value="previous"/></c:url>'>
				<B>&lt;&lt; Prev</B>
			</a>
		</c:if>
		<c:if test="${!interestList.lastPage}">
			<a
				href='<c:url value="/interesting/list2">
	        <c:param name="page" value="next"/></c:url>'>
				<B>Next &gt;&gt;</B>
			</a>
		</c:if>
		
		<p>
		<h1>기간 지난 찜 목록</h1>
		<table class="table1">
			<tr align="center" bgcolor="#D5D5D5">
				<th>상품ID</th>
				<th>상품이름</th>
				<th>그림</th>
				<th>경매 마감일</th>
				<th>삭제</th>
			</tr>
			<c:if test="${pastInterestingList.pageList.size() == 0}">
				<tr align="center"><td colspan="5"><c:out value="목록이 없습니다." /></td></tr>
			</c:if>
			<c:if test="${pastInterestingList.pageList.size() != 0}">
				<c:forEach var="pastItem" items="${pastInterestingList.pageList}">
					<tr align="center">
						<td><c:out value="${pastItem.itemId}" /></td>
						<td><c:out value="${pastItem.itemName}" /></td>
						<td><img src="<c:url value="${pastItem.picture}" />"  width="200" height="150" /></td>
						<td><fmt:formatDate value="${pastItem.deadline}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a
							href='<c:url value="/interesting/delete">
				  <c:param name="interItemId" value="${pastItem.itemId}"/></c:url>'>
								<c:out value="삭제하기" />
						</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
		<c:if test="${!pastInterestingList.firstPage}">
			<a
				href='<c:url value="/interesting/list3">
		    <c:param name="page" value="previous"/></c:url>'>
				<B>&lt;&lt; Prev</B>
			</a>
		</c:if>
		<c:if test="${!pastInterestingList.lastPage}">
			<a
				href='<c:url value="/interesting/list3">
	        <c:param name="page" value="next"/></c:url>'>
				<B>Next &gt;&gt;</B>
			</a>
		</c:if>	
	</form>
</div>