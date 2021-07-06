<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 개시글</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<c:if test="${empty loginMember}">
		<div>
			<form id="insert_f" action="insert.do">
				<dl>
					<dt>${loginMember.id}</dt>
					<dd>
						<textarea name="content"></textarea>
						<input type="button" value="작성" id="insert_btn"/>
					</dd>
				</dl>
			</form>
		</div>
		</c:if>
		<div id="box_board">
			<form id="search_f">
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
				<c:if test="${empty list}">
				<li>
					<dl>
						<dt>검색된 개시글이 없습니다.</dt>
					</dl>
				</li>
				</c:if>
				<c:forEach items="${list}" var="board">
				<c:if test="${board.state == 0}">
				<li class="depth-${board.depth}">
					<dl>
						<dt>
							<span class="id">${board.id}</span>
							<span class="postdate">${board.id}</span>
							<c:if test="${board.id == loginMember.id}">
							<a href="javascript:del(0);">삭제</a>
							</c:if>
						</dt>
						<dd>
							<pre>${board.content}</pre>
						</dd>
					</dl>
				</li>
				</c:if>
				<c:if test="${board.state != 0}">
				<li class="depth-${board.depth}">
					<dl>
						<dt>
							<span>
							</span>
						</dt>
						<dd>
							<pre>&gt;&gt;삭제된 글입니다.&lt;&lt;</pre>
						</dd>
					</dl>
				</li>
				</c:if>
				</c:forEach>
			</ul>
			<div class="paging" id="board_paging">
			
			</div>
		</div>
	</section>
</body>
</html>