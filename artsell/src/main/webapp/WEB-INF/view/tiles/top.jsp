<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <script type="text/javascript">
$(document).ready(function() {
	var userSession = '<%=session.getAttribute("userSession")%>'
	if (userSession == null) {
		var reLogin = confirm('세션이 만료되었습니다. 확인 시 로그인창으로 이동합니다.');
		document.write("세션만료");
		if (reLogin) {
			location.href = '/user/login';
		}
	}
});
</script> --%>
<div class="content-topbar">
	<a href="<c:url value="/home"/>" class="left-topbar-item"><img border="0"
				src='<c:url value="../images/artsell_logo_white.jpg" />'/></a>
	<div class="left-topbar">
		<c:if test="${!empty userSession.account}">
			<a href="javascript:void(0);" class="left-topbar-item"><c:out value="${userSession.account.userId}"/>님.</a>
			<a href="<c:url value="/user/logout"/>" class="left-topbar-item">로그아웃</a>
			<c:if test="${userSession.account.userId eq 'admin'}">
				<a href="<c:url value="/admin/manage"/>" class="left-topbar-item">회원관리</a>
				<a href="<c:url value="/interesting/list"/>" class="left-topbar-item">찜목록</a>
			</c:if>
			<c:if test="${userSession.account.userId ne 'admin'}">
				<a href="<c:url value="/user/mypage"/>" class="left-topbar-item">마이페이지</a>
			</c:if>
			<a href="<c:url value="/auction/list"/>" class="left-topbar-item">경매참여목록</a>
			<a href="<c:url value="/myitem/add"/>" class="left-topbar-item">작품등록</a>
			<a href="<c:url value="/myitem/list"/>" class="left-topbar-item">내작품관리</a>
		</c:if>
	</div>
</div>

<%--<table class="top">
	<tr>
		<td><a href="<c:url value="/home"/>"> <img border="0"
				src="../images/artsell_logo_white.jpg" /></a></td>
		<td style="text-align: right">
			<!-- <c:out value="${userSession.account.userId}" /> cnrk -->
			<c:if test="${!empty userSession.account}">
				<a href="<c:url value="/user/logout"/>">
					<button>로그아웃</button>
				</a>
				<c:if test="${userSession.account.userId eq 'admin'}">
					<img border="0" src="../images/separator.gif" />&nbsp; <a
						href="<c:url value="/admin/manage"/>">
						<button>회원관리</button>
					</a>
					<img border="0" src="../images/separator.gif" />&nbsp; 
						<a href="<c:url value="/interesting/list"/>">
						<button>찜목록</button>
					</a>
				</c:if>
				<c:if test="${userSession.account.userId ne 'admin'}">
					<img border="0" src="../images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/mypage"/>">
						<button>마이페이지</button>
					</a>
				</c:if>
				<img border="0" src="../images/separator.gif" />&nbsp; <a
					href="<c:url value="/auction/list"/>">
					<button>경매현황</button>
				</a>
			</c:if>
		</td>
	</tr>
	<tr>
		<td></td>
		<c:if test="${!empty userSession.account}">
			<td style="text-align: right"><a
				href="<c:url value="/myitem/add"/>">
					<button>그림 등록</button>
			</a> <img border="0" src="../images/separator.gif" />&nbsp; <a
				href="<c:url value="/myitem/list"/>">
					<button>내 그림 관리</button>
			</a></td>
		</c:if>
	</tr>
</table>
--%>
