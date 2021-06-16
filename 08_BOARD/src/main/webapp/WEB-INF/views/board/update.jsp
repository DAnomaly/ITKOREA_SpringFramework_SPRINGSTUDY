<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글 수정</title>
	<link rel="stylesheet" href="resources/css/update.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="resources/js/update.js"></script>
</head>
<body>
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="no" id="no" value="${board.no}"/>
		<table class="width-800">
			<tbody>
				<tr>
					<td>작성자</td>
					<td>
						${board.writer}
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="title" id="title" value="${board.title}"/>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="width-800">
			<p>내용</p>
			<textarea name="content" id="content">${board.content}</textarea>
		</div>
		<div class="width-800" class="footer">
			<input type="button" value="뒤로가기" id="back_btn"/>
			<input type="submit" value="작성" id="form_btn"/>
		</div>
	</form>
</body>
</html>