<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 개시글</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/board/list.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<c:if test="${not empty loginMember}">
		<div>
			<form id="insert_f" action="insert.do" method="post">
				<dl>
					<dt>${loginMember.id}</dt>
					<dd>
						<textarea id="insert_content" name="content"></textarea>
						<input type="button" value="작성" id="insert_btn"/>
					</dd>
				</dl>
			</form>
		</div>
		</c:if>
		<div id="box_board">
			<form id="search_f">
				<select id="c" name="c">
					<option value="CONTENT">내용</option>
					<option value="ID">아이디</option>
				</select>
				<input id="q" type="text" name="q" placeholder="게시글 검색"/>
				<input type="submit" value="검색" id="b_search_btn"/>
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
				<li class="depth_${board.depth}">
					<dl>
						<dt>
							<span class="id">${board.id}</span>
							<span class="postdate">${board.postdate}</span>
							<c:if test="${not empty loginMember.id and board.depth == 0}">
							<a href="javascript:show_com('#insertcom_${board.boardNo}');">답글</a>
							</c:if>
							<c:if test="${board.id == loginMember.id}">
							<a href="delete.do?no=${board.boardNo}">삭제</a>
							</c:if>
						</dt>
						<dd>
							<textarea id="content_${board.boardNo}" readonly>${board.content}</textarea>
						</dd>
					</dl>
				</li>
				<c:if test="${board.depth == 0}">
				<li class="depth_1" id="insertcom_${board.boardNo}" style="display:none;">
					<dl>
						<dt>${loginMember.id}</dt>
						<dd>
							<form action="insertComment.do" method="post">
								<input type="hidden" name="groupno" value="${board.boardNo}"/>
								<textarea name="content"></textarea>
								<input type="button" value="작성" onclick="insert_comment(this.form);"/>
							</form>
						</dd>
					</dl>
				</li>
				</c:if>
				</c:if>
				<c:if test="${board.state != 0}">
				<li class="depth_${board.depth}">
					<dl>
						<dt>
							<span>
							</span>
						</dt>
						<dd>
							<textarea readonly>&gt;&gt;삭제된 글입니다.&lt;&lt;</textarea>
						</dd>
					</dl>
				</li>
				</c:if>
				</c:forEach>
			</ul>
			<div class="paging" id="board_paging">
				${paging}
			</div>
		</div>
	</section>
</body>
</html>