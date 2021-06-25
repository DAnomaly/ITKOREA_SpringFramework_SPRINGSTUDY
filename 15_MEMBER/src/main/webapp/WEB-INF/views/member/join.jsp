<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="/member/resources/js/join.js"></script>
	<link rel="stylesheet" href="/member/resources/css/join.css"/>
</head>
<body>
	<h1>회원가입</h1>
	
	<form id="f" action="join.do" method="post">
		
		아이디<br/>
		<input type="text" name="id" id="id"/>
		<br/><br/>
		비밀번호<br/>
		<input type="password" name="pw" id="pw"/>
		<br/><br/>
		비밀번호 재확인<br/>
		<input type="password" name="pw1" id="pw1"/>
		<br/><br/>
		이름<br/>
		<input type="text" name="name" id="name"/>
		<br/><br/>
		이메일 인증<br/>
		<input type="text" name="email" id="email"/>
		<input type="button" id="verify_key_btn" value="이메일인증"/><br/>
		<input type="text" name="key" id="key" placeholder="인증번호입력"/>
		<input type="button" id="check_key_btn" value="확인"/>
		<br/><br/>
		<input type="button" value="가입하기" id="join_btn"/>
		<input type="button" value="뒤로가기" id="back_btn"/>
		
	</form>

</body>
</html>