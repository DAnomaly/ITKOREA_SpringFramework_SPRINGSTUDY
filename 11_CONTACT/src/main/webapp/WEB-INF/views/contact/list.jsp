<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>연락처 목록</title>
<link rel="stylesheet" href="/contact02/resources/css/list.css">
</head>
<body>
	<h1>연락처 목록</h1>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>전화</td>
				<td>주소</td>
				<td>이메일</td>
			</tr>
		</thead>
		<tbody>
		<c:if test="${empty list}">
			<tr>
				<td colspan="5">등록된 연락처가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items="${list}" var="contact">
			<tr onclick="location.href='view.do?no=${contact.no}'">
				<td>${contact.no}</td>
				<td><a href="view.do?no=${contact.no}">${contact.name}</a></td>
				<td>${contact.tel}</td>
				<td>${contact.addr}</td>
				<td>${contact.email}</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<a href="insertView.do">신규 연락처 등록하기</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>