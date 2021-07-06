<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 갤러리</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/gallery/list.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
	<link rel="stylesheet" href="/mygallery/resources/asset/css/gallery/list.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div class="search_container">
			<div class="left">
				<form id="f">
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
			</div>
			<div class="right">
				<a href="writePage.do">새 갤러리 작성</a>
			</div>
		</div>
		<div class="list_container">
			<c:if test="${empty list}">
			<div class="no_result">갤러리를 찾지 못하였습니다.</div>
			</c:if>
			<c:forEach items="${list}" var="gallery">
			<div class="outbox" onclick="move(${gallery.galleryNo})">
				<div><a href="viewPage.do?no=${gallery.galleryNo}"><img alt="${gallery.image}" src="/mygallery/resources/archive/${gallery.image}"/></a></div>
				<div class="text">
					<span class="title">${gallery.title}</span>
					<span class="id">${gallery.id}</span>
					<span class="hit">${gallery.hit}</span>
				</div>
			</div>
			</c:forEach>
		</div>
		<div  class="paging" id="gallery_paging">
			${paging}
		</div>
	</section>
</body>
</html>