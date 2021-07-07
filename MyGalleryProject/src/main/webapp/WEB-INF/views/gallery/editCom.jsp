<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글 수정</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/gallery/editCom.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
	<link rel="stylesheet" href="/mygallery/resources/asset/css/gallery/editCom.css">
</head>
<body>
	<div class="container">
		<form id="f">
			<p>댓글 수정</p>
			<input type="hidden" name="galleryComNo" value="${galleryCom.galleryComNo}"/>
			<textarea id="content" name="content">${galleryCom.content}</textarea>
			<div class="bottom">
				<input type="button" value="수정" onclick="f_submit();"/>
			</div>
		</form>
	</div>
</body>
</html>