<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="bp1">
	<nav class="menu-desktop">
		<ul class="main-menu justify-content-center">
			<li class="mega-menu-item">
				<a href='<c:url value="/shop/viewCategory?categoryId=landscape"/>'>ǳ��ȭ</a>
			</li>
			<li class="mega-menu-item">
				<a href='<c:url value="/shop/viewCategory?categoryId=figure-painting"/>'>�ι�ȭ</a></li>
			<li class="mega-menu-item">
				<a href='<c:url value="/shop/viewCategory?categoryId=ink-and-wash"/>'>����ȭ </a></li>
			<li class="mega-menu-item"><a
		href='<c:url value="/shop/viewCategory?categoryId=abstract"/>'>�߻�ȭ</a></li>
			<li class="mega-menu-item"><a
		href='<c:url value="/shop/viewCategory?categoryId=stillLife"/>'>����ȭ</a></li>
			<li class="mega-menu-item"><a
		href='<c:url value="/shop/viewCategory?categoryId=animalization"/>'>����ȭ</a></li>
		</ul>
	</nav>
</div>
<!-- 
<div align="center">
	<a href='<c:url value="/shop/viewCategory?categoryId=landscape"/>'>ǳ��ȭ</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=figure-painting"/>'>�ι�ȭ</a>
	<img border="0" src="../images/separator.gif" alt="" /> 
		<a href='<c:url value="/shop/viewCategory?categoryId=ink-and-wash"/>'>����ȭ</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=abstract"/>'>�߻�ȭ</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=stillLife"/>'>����ȭ</a>
	<img border="0" src="../images/separator.gif" alt="" /> <a
		href='<c:url value="/shop/viewCategory?categoryId=animalization"/>'>����ȭ</a>
</div>
 -->
<form action='<c:url value="/search/item"/>' method="post">
<div class="ac">
	<table>
		<tr >
			<td>
 				<div class="d1">
					<select name="job" class = "s1">
						<option value="��ǰ��" selected="selected">��ǰ��</option>
						<option value="ȭ����">ȭ����</option>
					</select>
				</div>
			</td>
			<td>
				<div class="pos-relative size-a-2  of-hidden bocl11 m-tb-6 d1">
					<input class="f1-s-1 cl6 plh9 s-full2 p-l-25 p-r-45" type="text"
						name="keyword" placeholder="Search">
					<button
						class="flex-c-c size-a-1 ab-t-r fs-20 cl2 hov-cl10 trans-03"
						type="submit"><h6>�˻�</h6></button>
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
						<option value="��ǰ��" selected="selected">��ǰ��</option>
						<option value="ȭ����">ȭ����</option>
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

