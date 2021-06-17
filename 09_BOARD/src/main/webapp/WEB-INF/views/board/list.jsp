<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시판</title>
	<link rel="stylesheet" href="resources/css/list.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="resources/js/list.js"></script>
</head>
<body>
	<h1>게시판 목록</h1>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
			<tr>
				<td colspan="4" style="height: 30px;">작성된 게시글이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach items="${list}" var="board">
			<tr onclick="location.href='selectBoardByNo.do?no=${board.no}'">
				<td>${board.no}</td>
				<td><a href="selectBoardByNo.do?no=${board.no}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value="${board.postdate}" pattern="yy.MM.dd(HH:mm)"/> </td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					${paging}
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="button" value="새글작성" id="insert_btn"/>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>