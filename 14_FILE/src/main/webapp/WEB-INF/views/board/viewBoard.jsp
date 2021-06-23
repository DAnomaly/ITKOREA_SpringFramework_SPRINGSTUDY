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
	<h1>게시글 보기</h1>
	<form  method="post">
		작성자<br/>
		${board.writer}<input type="hidden" name="writer" value="${board.writer}"/><br/>
		<br/>
		제목<br/>
		<input type="text" name="title" value="${board.title}"/><br/>
		<br/>
		내용<br/>
		<input type="text" name="title" value="${board.content}"/><br/>
		<br/>
		첨부 이미지<br/>
		<c:if test="${not empty board.filename}">
			<img alt="${board.filename}" src="resources/archive/${board.filename}" style="width: 300px;"/>
		</c:if>
	</form>
</body>
</html>