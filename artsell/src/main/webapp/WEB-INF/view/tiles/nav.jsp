<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="bp1">
	<nav class="menu-desktop">
		<ul class="main-menu justify-content-center">
			<li class="mega-menu-item">
				<a href='<c:url value="/shop/viewCategory?categoryId=landscape"/>'>풍경화</a>
			</li>
			<li class="mega-menu-item">
				<a href='<c:url value="/shop/viewCategory?categoryId=figure-painting"/>'>인물화</a></li>
			<li class="mega-menu-item">
				<a href='<c:url value="/shop/viewCategory?categoryId=ink-and-wash"/>'>수묵화 </a></li>
			<li class="mega-menu-item"><a
		href='<c:url value="/shop/viewCategory?categoryId=abstract"/>'>추상화</a></li>
			<li class="mega-menu-item"><a
		href='<c:url value="/shop/viewCategory?categoryId=stillLife"/>'>정물화</a></li>
			<li class="mega-menu-item"><a
		href='<c:url value="/shop/viewCategory?categoryId=animalization"/>'>동물화</a></li>
		</ul>
	</nav>
</div>
<!-- 
<div align="center">
	<a href='<c:url value="/shop/viewCategory?categoryId=landscape"/>'>풍경화</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=figure-painting"/>'>인물화</a>
	<img border="0" src="../images/separator.gif" alt="" /> 
		<a href='<c:url value="/shop/viewCategory?categoryId=ink-and-wash"/>'>수묵화</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=abstract"/>'>추상화</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=stillLife"/>'>정물화</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=animalization"/>'>동물화</a>
</div>
 -->
<form action='<c:url value="/search/item"/>' method="post">
<div class="ac">
	<table>
		<tr >
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
		<!-- 
<table class="search">
	<tr>
		<td valign="top" width="100%" style="text-align: center">
			<form action='<c:url value="/search/item"/>' method="post">
				<div class="d1">
					<select name="job">
						<option value="작품명" selected="selected">작품명</option>
						<option value="화가명">화가명</option>
					</select>
				</div>
				<div class="pos-relative size-a-2  of-hidden bocl11 m-tb-6 d1">
					<input class="f1-s-1 cl6 plh9 s-full2 p-l-25 p-r-45" type="text"
						name="keyword" placeholder="Search">
					<button
						class="flex-c-c size-a-1 ab-t-r fs-20 cl2 hov-cl10 trans-03"
						type="submit"></button>
				</div>
			</form>
		</td>
	</tr>
</table>
 -->

