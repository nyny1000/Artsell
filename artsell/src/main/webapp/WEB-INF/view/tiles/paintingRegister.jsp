<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<h2>그림 등록</h2>
	<form:form modelAttribute="item" method="post" action='<c:url value="/myitem/add" />' enctype="multipart/form-data">
		<form:errors cssClass="error" />
		<br>
		<br>
		<table>
			<tr>
				<td>작품명&nbsp;&nbsp;</td>
				<td><input type="text" name="itemName" value="${item.itemName}"/> 
				<form:errors path="itemName"/></td>
			</tr>
			<tr>
				<td>시작 가격&nbsp;&nbsp;</td>
				<td><input type="text" name="minPrice" value="${item.minPrice}" />
				<form:errors path="minPrice"/></td>
			</tr>
			<tr>
				<td>화가&nbsp;&nbsp;</td>
				<td><input type="text" name="artist" value="${item.artist}" />
				<form:errors path="artist"/></td>
			</tr>
			<tr>
				<td>경매 마감 기한&nbsp;&nbsp;</td>
				<td>
				<input type="text" name = "deadline" id="deadline"><!-- <input type="date" name="deadline"  />-->
				<form:errors path="deadline"/>
				
				</td>
			</tr>
			<tr>
				<td>카테고리&nbsp;&nbsp;</td>
				<td>
					<form:select path="categoryId" >
						<form:options items="${cateList}" itemLabel="name" itemValue="categoryId" />
					</form:select>
					<form:errors path="categoryId"/>
				</td>
			</tr> 
			<tr>
				<td colspan="2">작품 사진 첨부&nbsp;&nbsp;<input type="file" name="picturefile" accept="image/jpeg,image/png">
				<form:errors path="picturefile"/></td>
			</tr>
			<tr><td colspan="2">그림설명</td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="description" cols="45" rows="8">${item.description}</textarea>
				<form:errors path="description"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form:form>
</div>
