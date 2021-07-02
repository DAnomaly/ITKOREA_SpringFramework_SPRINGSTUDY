<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		var page = 1;
		$(document).ready(function(){
			if($('#view_type').val() == 'board'){
				$('#box_gallery').hide();
				$('#box_board').show();
			} else {
				$('#box_gallery').show();
				$('#box_board').hide();
			}
		})
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<input type="hidden" name="viewType" id="view_type" value="${param.v}"/>
	<section>
		<div id="box_gallery">
			<a href="gallery/writePage.do">새 갤러리 작성</a>
			<form>
				<select name="c">
					<option value="ID">아이디</option>
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
					<option value="BOTH">제목+내용</option>
				</select>
				<input type="text" name="q" placeholder="갤러리 검색"/>
				<input type="button" value="검색" id="g_search_btn"/>
				<input type="button" value="초기화" id="g_init_btn"/>
			</form>
			<ul id="gallery_ul">
				
			</ul>
		</div>
		<div id="box_board">
			<a href="board/writeBoard.do">새글 쓰기</a>
			<form>
				<select name="c">
					<option value="ID">아이디</option>
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
					<option value="BOTH">제목+내용</option>
				</select>
				<input type="text" name="q" placeholder="게시글 검색"/>
				<input type="button" value="검색" id="b_search_btn"/>
				<input type="button" value="초기화" id="b_init_btn"/>
			</form>
			<ul id="board_ul">
				
			</ul>
		</div>
	</section>
</body>
</html>