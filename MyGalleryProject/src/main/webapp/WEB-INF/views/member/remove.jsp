<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 회원탈퇴</title>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
	<link rel="stylesheet" href="/mygallery/resources/asset/css/member/remove.css">
</head>
<body>
	<section>
		<h1>회원 탈퇴</h1>
		<div>
			<h3>정말로 <strong>탈퇴</strong>하실 건가요?</h3>
			<p>작성하신 갤러리 수 : <strong>${g_count}</strong></p>
			<p>작성하신 게시글 수 : <strong>${b_count}</strong></p>
			<p>작성하신 <strong>게시글</strong>과 <strong>갤러리</strong>, <strong>댓글</strong>은 사라지지 않습니다.</p>
			<div>
				<input type="button" id="yes" value="네" onclick="location.href='remove.do'"/>
				<input type="button" id="no" value="아니요" onclick="history.back()"/>
			</div>
		</div>
	</section>
</body>
</html>