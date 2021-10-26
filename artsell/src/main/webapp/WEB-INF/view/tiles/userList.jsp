<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<h1>회원 목록</h1>
	<table class="table2">
		<tr align="center" bgcolor="#D5D5D5">
			<th>ID</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>번호</th>
			<th>카드번호</th>
			<th>주소</th>
		</tr>
		<c:forEach var="user" items="${userList.pageList}">
			<tr align="center">
				<td><c:out value="${user.userId}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.password}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.phone}" /></td>
				<td><c:out value="${user.credit}" /></td>
				<td><c:out value="${user.address1} ${user.address2}" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${!userList.firstPage}">
		<a href='<c:url value="/admin/page">
		    <c:param name="page" value="previous"/></c:url>'>
				<B>&lt;&lt; Prev</B>
		</a>
	</c:if>
	<c:if test="${!userList.lastPage}">
		<a href='<c:url value="/admin/page">
	        <c:param name="page" value="next"/></c:url>'>
				<B>Next &gt;&gt;</B>
		</a>
	</c:if>
</div>