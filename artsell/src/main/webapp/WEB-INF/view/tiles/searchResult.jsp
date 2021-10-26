<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h2>작품 검색</h2>
	<p>
	
	<!-- 
	<form action="<c:url value="/search/item" />" method="post">
		<c:out value="전체 검색:" />
		<select name="categoryId">
			<option value="" selected>카테고리</option>
			<c:forEach var="category" items="${categoryList}">
				<option value="${category.categoryId}"><c:out
						value="${category.name}" /></option>
			</c:forEach>
		</select> <select name="job">
			<option value="작품명" selected="selected">작품명</option>
			<option value="화가명">화가명</option>
		</select> <input type="hidden" name="search" value="true" /> <input
			type="search" name="keyword" />&nbsp; <input
			src="/images/search.png" type="image" />
	</form>
</div>
 -->

<form action='<c:url value="/search/item"/>' method="post">
<div class="ac2">
	<table>
		<tr >
			<td>
				<c:out value="전체 검색:" />
			</td>
			<td>
				<select name="categoryId" class="s1">
					<option value="" selected>카테고리</option>
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.categoryId}">
							<c:out value="${category.name}" />
						</option>
					</c:forEach>
				</select>
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


<div align="center">

	<c:if test="${!empty categoryName}">
		<b><c:out value="${categoryName}" /></b>&nbsp;카테고리 내 검색 결과</c:if>
	<%-- <c:if test="${categoryId}"><c:out value="${categoryId }</c:if> --%>
	<p>
		총 <strong><c:out value="${total}" /></strong> 개의 작품이 검색되었습니다.
	</p>
	<!-- 고치기 -->
	<table class="table1">
		<th>카테고리</th>
		<th>작품명</th>
		<th>작품사진</th>
		<th>화가</th>
		<c:forEach var="item" items="${itemList.pageList}">
			<tr align="center">
				<td><a
					href="<c:url value="/shop/viewCategory"><c:param name="categoryId" value="${item.categoryId}" /></c:url> ">
						<c:if test="${item.categoryId == 'animalization'}"><c:out value="동물화" />
						</c:if>
						<c:if test="${item.categoryId == 'landscape'}"><c:out value="풍경화" />
						</c:if>
						<c:if test="${item.categoryId == 'figure-painting'}"><c:out value="인물화" />
						</c:if>
						<c:if test="${item.categoryId == 'ink-and-wash'}"><c:out value="수묵화" />
						</c:if>
						<c:if test="${item.categoryId == 'abstract'}"><c:out value="추상화" />
						</c:if>
						<c:if test="${item.categoryId == 'stillLife'}"><c:out value="정물화" />
						</c:if>
						</a>
					
						
				</td>
				<!-- 카테고리 이름으로 바꾸기 -->
				<td><a
					href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>">
						<c:out value="${item.itemName}" />
				</a></td>
				<td><a
					href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>">
						<img src="<c:url value="${item.picture}"/>" width="300"
						height="200" />
				</a></td>
				<td><a
					href="<c:url value="/search/item">
					<c:param name="artist" value="${item.artist}" /></c:url>">
						<c:out value="${item.artist}" />
				</a></td>
			</tr>
		</c:forEach>

	</table>
	<c:if test="${!itemList.firstPage}">
		<a
			href="<c:url value="/search/item">
						<c:param name="page" value="previous" /></c:url>">
			<B>&lt;&lt; Prev</B>
		</a>
	</c:if>
	<c:if test="${!itemList.lastPage}">
		<a
			href="<c:url value="/search/item">
						<c:param name="page" value="next" /></c:url>">
			<B>Next &gt;&gt;</B>
		</a>
	</c:if>
</div>

<!-- 추가하면 좋을 것들: 정렬기능, 인기검색어 기능 -->