<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 회원탈퇴</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<div>
		<h3>정말로 탈퇴하실 건가요?</h3>
		<p>작성하신 갤러리 수 : ${g_count}</p>
		<p>작성하신 게시글 수 : ${b_count}</p>
		<p>작성하신 게시글과 갤러리, 댓글은 사라지지 않습니다.</p>
		<div>
			<input type="button" id="yes" value="네" onclick="location.href='remove.do'"/>
			<input type="button" id="no" value="아니요" onclick="history.back()"/>
		</div>
	</div>
	
</body>
</html>