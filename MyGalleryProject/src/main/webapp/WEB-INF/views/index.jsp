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
		
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<input type="hidden" name="viewType" id="view_type" value="${param.v}"/>
	<input type="hidden" name="viewPage" id="view_page" value=""/>
	<section>
		<div id="box_gallery">
			<ul id="gallery_ul"></ul>
		</div>
		<div id="box_board">
			<ul id="board_ul"></ul>
		</div>
	</section>
</body>
</html>