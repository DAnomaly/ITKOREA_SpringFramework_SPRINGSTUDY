<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 갤러리 수정</title>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form action="insert.do" method="post" enctype="multipart/form-data">
			<label>
				<span>제목</span><br>
				<input type="text" name="title" id="title" value="${gallery.title}"/>
			</label>
			<label>
				<span>내용</span><br>
				<textarea name="content" id="content">${gallery.content}</textarea>
			</label>
			<label>
				<span>이미지</span><br>
				<input type="file" name="image" id="image" value="${gallery.image}"/>
			</label>
			<input type="button" value="수정"/>
		</form>
	</section>
</body>
</html>