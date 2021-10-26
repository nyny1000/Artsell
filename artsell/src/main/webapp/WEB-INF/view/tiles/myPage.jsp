<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="mypage" border="0" align="center">
	<tr height="100px">
		<td><a href="<c:url value="/auction/list"/>"><button>경매참여목록</button></a></td>
		<td><a href="<c:url value="/user/editForm"/>"><button>회원정보
					수정</button></a></td>
	</tr>

	<tr height="100px">
		<td><a href="<c:url value="/myitem/list"/>"><button>내
					작품 관리</button></a></td>
		<td><a href="<c:url value="/user/delete"/>"><button>회원탈퇴</button></a></td>

	</tr>

	<tr height="100px">
		<td><a href="<c:url value="/interesting/list"/>"><button>찜
					목록</button></a></td>
	</tr>
</table>

			