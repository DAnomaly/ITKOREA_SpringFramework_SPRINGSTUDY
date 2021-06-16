<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/view.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="resources/js/view.js"></script>
</head>
<body>
	<h1>${board.no}번 게시글</h1>
	<table class="width-800">
		<tbody>
			<tr>
				<td>작성자</td>
				<td>
					<span>${board.writer}</span>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<span>${board.title}</span>
					<span class="post_date"><fmt:formatDate value="${board.postdate}" pattern="yy.MM.dd(HH:mm)"/></span>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="width-800">
		<p>내용</p>
		<pre id="content">${board.content}</pre>
	</div>
	<div class="width-800" class="footer">
		<input type="hidden" name="no" value="${board.no}" id="no"/>
		<input type="button" value="뒤로가기" id="back_btn"/>
		<input type="button" value="수정" id="edit_btn"/>
	</div>
</body>
</html>