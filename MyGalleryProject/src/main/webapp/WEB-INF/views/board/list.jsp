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
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div id="box_board">
			<a href="board/writePage.do">새글 쓰기</a>
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
			<div class="paging" id="board_paging">
			
			</div>
		</div>
	</section>
</body>
</html>