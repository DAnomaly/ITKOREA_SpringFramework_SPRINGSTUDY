<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 갤러리 수정</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/gallery/edit.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form id="f" action="update.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="galleryNo" value="${gallery.galleryNo}"/>
			<label>
				<span>제목</span><br>
				<input type="text" name="title" id="title" value="${gallery.title}"/><br>
			</label>
			<label>
				<span>내용</span><br>
				<textarea name="content" id="content">${gallery.content}</textarea><br>
			</label>
			<span>
				<span>이미지</span><br>
				<input type="hidden" name="image1" value="${gallery.image}"/>
				<input type="file" name="image2" id="image"/><br>
			</span>
			<input type="button" value="작성" id="f_btn"/>
		</form>
	</section>
</body>
</html>