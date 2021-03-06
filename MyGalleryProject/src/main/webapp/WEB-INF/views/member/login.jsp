<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 로그인</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/member/login.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
	<link rel="stylesheet" href="/mygallery/resources/asset/css/member/login.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form id="f">
			<div class="left">
				<label><span>아이디</span><input type="text" name="id" id="id"/></label><br>
				<label><span>비밀번호</span><input type="password" name="pw" id="pw"/></label>
			</div>
			<div class="right">
				<input type="submit" value="로그인"/>
			</div>
		</form>
		
		<div class="bottom">
			<div class="bottom_box left">
				<span>회원이 아니신가요?</span><br>
				<a href="/mygallery/member/joinView.do">회원가입</a>
			</div>
			<div class="bottom_box right">
				<span>아이디/비밀번호를 잊으셨나요?</span><br>
				<a href="/mygallery/member/findView.do">아이디/비밀번호 찾기</a>
			</div>
		</div>
	</section>
</body>
</html>