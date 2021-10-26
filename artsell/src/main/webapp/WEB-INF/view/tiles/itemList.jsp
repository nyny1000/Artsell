<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
<div align="center">
	<h2><c:out value="${category.name}" /></h2>
	<form action="<c:url value="/search/item" />" method="post">
		<c:out value="${category.name} 내 검색:" />
		<select name="job">
			<option value="작품명" selected="selected">작품명</option>
			<option value="화가명">화가</option>
		</select>
		<input type="hidden" name="search" value="true"/>
		<input type="hidden" name="categoryId" value="${category.categoryId}" value="true" />
	    <input type="search" name="keyword" />&nbsp;
	    <input src="/images/search.png" type="image" />
	</form>
</div>
 -->
 
<div align="center">
	<h2><c:out value="${category.name}" /></h2>
<form action='<c:url value="/search/item"/>' method="post">
<div class="ac2">
	<table>
		<tr >
			<td>
				<c:out value="${category.name} 내 검색:" />
			</td>
			<td>
 				<div class="d1">
					<select name="job" class = "s1">
						<option value="작품명" selected="selected">작품명</option>
						<option value="화가명">화가명</option>
					</select>
				</div>
			</td>
			<td>
				<div class="pos-relative size-a-2  of-hidden bocl11 m-tb-6 d1">
					<input class="f1-s-1 cl6 plh9 s-full2 p-l-25 p-r-45" type="text"
						name="keyword" placeholder="Search">
					<button
						class="flex-c-c size-a-1 ab-t-r fs-20 cl2 hov-cl10 trans-03"
						type="submit"><h6>검색</h6></button>
				</div>
			</td>
		</tr>
	</table>
</div>
</form>
</div>


<p>
<div align="center">
	<a href="<c:url value="/myitem/add" />">작품 등록</a>
	<a href="<c:url value="/myitem/list" />">내 그림 관리</a>
</div>
<p>

<div align="center">
	<table class="table1">
		<tr>
			<th>작품명</th>
			<th>작품사진</th>
			<th>화가</th>
		</tr>
		<c:if test="${itemList.pageList.size() == 0}">
				<tr align="center"><td colspan="3"><c:out value="목록이 없습니다." /></td></tr>
		</c:if>
		<c:if test="${itemList.pageList.size() != 0}">
			<c:forEach var="item" items="${itemList.pageList}">
			<tr align="center">
				<td>
					<a href="<c:url value="/shop/viewItem">
						<c:param name="itemId" value="${item.itemId}" /></c:url>"><c:out value="${item.itemName}" /></a>
				</td>
				<td align="center">
					<a href="<c:url value="/shop/viewItem">
						<c:param name="itemId" value="${item.itemId}" /></c:url>">
						<img src='<c:url value="${item.picture}" />' width="300" height="200" />
					</a>
				</td>
				<td>
					<a href="<c:url value="/search/item">
						<c:param name="artist" value="${item.artist}" /></c:url>"><c:out value="${item.artist}" /></a>
				</td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
	<p>
	<c:if test="${!itemList.firstPage}">
		<a href="<c:url value="/shop/viewCategory2">
			<c:param name="page" value="previous" /></c:url>">
				   	<B>&lt;&lt; Prev</B></a>
	</c:if>
	<c:if test="${!itemList.lastPage}">
		<a href="<c:url value="/shop/viewCategory2">
			<c:param name="page" value="next" /></c:url>">
				   	<B>Next &gt;&gt;</B></a>
	</c:if>
	
</div>