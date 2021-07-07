<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : ${gallery.title}</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/gallery/view.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
	<link rel="stylesheet" href="/mygallery/resources/asset/css/gallery/view.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div>
			<span class="hidden">제목</span>
			<h3>
				${gallery.title}
				<span class="id">
					${gallery.id}
					<span class="postdate">
						${gallery.postdate}
					</span>
					<span class="edit">
					<c:if test="${loginMember.id == gallery.id}">
						<a href="editPage.do?no=${gallery.galleryNo}">수정</a>
						<a href="javascript:fn_del(${gallery.galleryNo});">삭제</a>
					</c:if>
					</span>
				</span>
			</h3>
			<div>
				<span class="hidden">이미지</span><br>
				<img alt="${gallery.image}" src="/mygallery/resources/archive/${gallery.image}"/>
			</div>
			<br>
			<c:if test="${not empty gallery.content}">
			<span class="hidden">내용</span>
			<pre class="content">${gallery.content}</pre>
			</c:if>
		</div>
		<div>
			<%-- 댓글들 --%>
			<c:forEach items="${comments}" var="comment">
			<dl>
				<dt>
					<span class="id">${comment.id}</span>
					<span class="postdate">${comment.postdate}
					<c:if test="${loginMember.id == gallery.id}">
						<a href="javascript:openEditPage(${comment.galleryComNo});">수정</a>
						<a href="javascript:fn_com_del(${comment.galleryComNo});">삭제</a>
					</c:if>
					</span>
				</dt>
				<dd>
					<pre>${comment.content}</pre>
				</dd>
			</dl>
			</c:forEach>
			<%-- 댓글작성 : 로그인 --%>
			<c:if test="${not empty loginMember}">
			<dl>
				<dt>
					<span class="id">${loginMember.id}</span>
				</dt>
				<dd>
					<form id="f" action="writeCom.do" method="post">
						<input type="hidden" name="galleryNo" value="${gallery.galleryNo}"/>
						<textarea id="com_content" name="content" class="comment"></textarea>
						<input type="button" value="작성" id="f_btn"/>
					</form>
				</dd>
			</dl>
			</c:if>
			<%-- 댓글작성 : 로그아웃 --%>
			<c:if test="${empty loginMember}">
			<dl>
				<dt>
					<span class="id">댓글</span>
				</dt>
				<dd>
					<textarea name="content" class="comment disable" readonly>댓글 작성을 위해서는 로그인을 하셔야 합니다.</textarea>
					<input type="button" value="작성" id="f_btn"/>
				</dd>
			</dl>
			</c:if>
		</div>
	</section>
</body>
</html>