<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 갤러리 작성</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<c:if test="${empty loginMember}">
	<script type="text/javascript" src="/mygallery/resources/asset/js/common/loginCheck.js" charset="utf-8"></script>
	</c:if>
	<script type="text/javascript" src="/mygallery/resources/asset/js/gallery/write.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
	<link rel="stylesheet" href="/mygallery/resources/asset/css/gallery/write.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form id="f" action="insert.do" method="post" enctype="multipart/form-data">
			<label>
				<span>제목</span>
				<input type="text" name="title" id="title"/><br>
			</label>
			<label>
				<span>내용</span><br>
				<textarea name="content" id="content"></textarea><br>
			</label>
			<span>
				<span>이미지</span>
				<input type="file" name="image" id="image"/><br>
			</span>
			<input type="button" value="작성" id="f_btn"/>
		</form>
	</section>
</body>
</html>