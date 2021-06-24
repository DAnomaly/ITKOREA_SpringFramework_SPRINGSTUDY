<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(function() {
			$('#list_btn').click(fn_list);
			$('#update_btn').click(fn_update);
			$('#delete_btn').click(fn_delete);
		});
		
		function fn_update() {
			$('#f').attr('action','updateBoard.do');
			$('#f').submit();
		}
		
		function fn_delete() {
			if(confirm('정말로 삭제하시겠습니까?')){
				$('#f').attr('action','deleteBoard.do');
				$('#f').submit();
			}
		}
		
		function fn_list() {
			location.href='selectListBoard.do';
		}
	</script>
</head>
<body>
	<h1>게시글 보기</h1>
	<form id="f" method="post" enctype="multipart/form-data">
		<input type="button" value="목록으로" id="list_btn"/>
		<input type="button" value="수정하기" id="update_btn"/>
		<input type="button" value="삭제하기" id="delete_btn"/>
		
		<input type="hidden" name="no" value="${board.no}"/>
		<input type="hidden" name="filename1" value="${board.filename}"/> <!-- 서버에 첨부된 첨부파일명 -->
		<br/><br/>
		작성자<br/>
		${board.writer}<input type="hidden" name="writer" value="${board.writer}"/><br/>
		<br/>
		제목<br/>
		<input type="text" name="title" value="${board.title}"/><br/>
		<br/>
		내용<br/>
		<input type="text" name="content" value="${board.content}"/><br/>
		<br/>
		
		첨부 변경<br>
		<input type="file" name="filename2"/><br><br>
		
		첨부 이미지<br/>
		<c:if test="${not empty board.filename}">
		<img alt="${board.filename}" src="resources/archive/${board.filename}" style="width: 300px;"/>
		</c:if>
	</form>
</body>
</html>