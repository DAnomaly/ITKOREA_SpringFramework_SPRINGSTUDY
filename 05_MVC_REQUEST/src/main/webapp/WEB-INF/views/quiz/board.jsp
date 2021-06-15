<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<c:if test="${not empty board}">
		<li>제목 : ${board.title}</li>
		<li>조회수 : ${board.hit}</li>
		<li>작성일 : <fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"/></li>
	</c:if>
	<c:if test="${empty board}">
		<li>제목 : ${title}</li>
		<li>조회수 : ${hit}</li>
		<li>작성일 : <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/></li>
	</c:if>
	</ul>
</body>
</html>