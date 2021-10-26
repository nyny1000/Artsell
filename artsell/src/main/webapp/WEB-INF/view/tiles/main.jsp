<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
<table class="t1">
	<tr>

		<td><p>&lt;풍경화&gt;</p> <a
			href="<c:url value="/shop/viewCategory?categoryId=landscape" />">
				<img width="130px" height="130px" border="0"
				src="../images/landscape.jpg" />
		</a></td>
		<td><p>&lt;인물화&gt;</p> <a
			href="<c:url value="/shop/viewCategory?categoryId=figure-painting" />">
				<img width="130px" height="130px" border="0"
				src="../images/figure-painting.jpg" />
		</a></td>
		<td><p>&lt;수묵화&gt;</p> <a
			href="<c:url value="/shop/viewCategory?categoryId=ink-and-wash" />">
				<img width="130px" height="130px" border="0"
				src="../images/ink-and-wash.jpg" />
		</a></td>
	</tr>

	<!-- 카테고리 2번째 줄 
	<tr>
		<td><p>&lt;추상화&gt;</p> <a 
			href="<c:url value="/shop/viewCategory?categoryId=abstract" />">
				<img width="130px" height="130px" border="0"
				src="../images/abstract.jpg" />
		</a></td>
		<td><p>&lt;정물화&gt;</p> <a
			href="/shop/viewCategory?categoryId=stillLife"> <img
				width="130px" height="130px" border="0"
				src="../images/stillLife.jpg" /></a></td>
		<td><p>&lt;동물화&gt;</p> <a
			href="/shop/viewCategory?categoryId=animalization"> <img
				width="130px" height="130px" border="0"
				src="../images/animalization.png" /></a></td>
	</tr>
</table>
 -->
	<section class="bg0">
		<div class="container d4">
			<div class="row m-rl--1">
				<div class="col-sm-6 col-lg-4 p-rl-1">
				<!-- 
					<div class="bg-img1 size-a-12 pos-relative" style="background-image: url(../images/landscape.jpg);">
					<div class="bg-img1 size-a-12 pos-relative" style="background-image: src='<c:url value="../images/landscape.jpg" />';"> -->
					<div class="bg-img1 size-a-12 pos-relative bgi1"> 
				
				
						<a href='<c:url value="/shop/viewCategory?categoryId=landscape" />' class="dis-block how1-child1 trans-03"></a>
						<div class="flex-col-e-s s-full p-rl-25 p-tb-11">
							<a href='<c:url value="/shop/viewCategory?categoryId=landscape" />' class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
								<h3>풍경화</h3>
							</a>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-4 p-rl-1">
					<div class="bg-img1 size-a-12 pos-relative" style="background-image: url(../images/figure-painting.jpg);">
						<a href='<c:url value="/shop/viewCategory?categoryId=figure-painting" />' class="dis-block how1-child1 trans-03"></a>
						<div class="flex-col-e-s s-full p-rl-25 p-tb-11">
							<a href='<c:url value="/shop/viewCategory?categoryId=figure-painting" />' class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
								<h3>인물화</h3>
							</a>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-4 p-rl-1">
					<div class="bg-img1 size-a-12 pos-relative" style="background-image: url(../images/ink-and-wash.jpg);">
						<a href='<c:url value="/shop/viewCategory?categoryId=ink-and-wash" />' class="dis-block how1-child1 trans-03"></a>
						<div class="flex-col-e-s s-full p-rl-25 p-tb-11">
							<a href='<c:url value="/shop/viewCategory?categoryId=ink-and-wash" />' class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
								<h3>수묵화</h3>
							</a>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-4 p-rl-1">
					<div class="bg-img1 size-a-12 pos-relative" style="background-image: url(../images/abstract.jpg);">
						<a href='<c:url value="/shop/viewCategory?categoryId=abstract" />' class="dis-block how1-child1 trans-03"></a>
						<div class="flex-col-e-s s-full p-rl-25 p-tb-11">
							<a href='<c:url value="/shop/viewCategory?categoryId=abstract" />' class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
								<h3>추상화</h3>
							</a>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-4 p-rl-1">
					<div class="bg-img1 size-a-12 pos-relative" style="background-image: url(../images/stillLife.jpg);">
						<a href='<c:url value="/shop/viewCategory?categoryId=stillLife" />' class="dis-block how1-child1 trans-03"></a>
						<div class="flex-col-e-s s-full p-rl-25 p-tb-11">
							<a href='<c:url value="/shop/viewCategory?categoryId=stillLife" />' class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
								<h3>정물화</h3>
							</a>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-lg-4 p-rl-1">
					<div class="bg-img1 size-a-12 pos-relative" style="background-image: url(../images/animalization.png);">
						<a href='<c:url value="/shop/viewCategory?categoryId=animalization" />' class="dis-block how1-child1 trans-03"></a>
						<div class="flex-col-e-s s-full p-rl-25 p-tb-11">
							<a href='<c:url value="/shop/viewCategory?categoryId=animalization" />' class="dis-block how1-child2 f1-s-2 cl0 bo-all-1 bocl0 hov-btn1 trans-03 p-rl-5 p-t-2">
								<h3>동물화</h3>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>