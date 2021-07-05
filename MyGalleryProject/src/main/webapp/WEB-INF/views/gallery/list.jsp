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
		function move(i){
			location.href='viewPage.do?no=' + i;
		}
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div id="box_gallery">
			<a href="writePage.do">새 갤러리 작성</a>
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
			<div class="paging" id="gallery_paging">
				<ul>
					<c:if test="${empty list}">
					<li>
						<ul>
							<li>등록된 갤러리가 없습니다.</li>
						</ul>
					</li>
					</c:if>
					<c:forEach items="${list}" var="gallery">
					<li>
						<ul onclick="move(${gallery.galleryNo})">
							<li><a href="viewPage.do?no=${gallery.galleryNo}"><img alt="${gallery.image}" src="/mygallery/resources/archive/${gallery.image}"/></a></li>
							<li>${gallery.title}</li>
							<li>${gallery.id}</li>
							<li>${gallery.hit}</li>
						</ul>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</section>
</body>
</html>