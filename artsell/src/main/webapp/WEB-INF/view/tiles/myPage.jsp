<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="mypage" border="0" align="center">
	<tr height="100px">
		<td><a href="<c:url value="/auction/list"/>"><button>����������</button></a></td>
		<td><a href="<c:url value="/user/editForm"/>"><button>ȸ������
					����</button></a></td>
	</tr>

	<tr height="100px">
		<td><a href="<c:url value="/myitem/list"/>"><button>��
					��ǰ ����</button></a></td>
		<td><a href="<c:url value="/user/delete"/>"><button>ȸ��Ż��</button></a></td>

	</tr>

	<tr height="100px">
		<td><a href="<c:url value="/interesting/list"/>"><button>��
					���</button></a></td>
	</tr>
</table>

			