<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인</title>
	<style>
		body {
			margin: 0 auto;
			width: 680px;
			text-align: center;
		}
	</style>
</head>
<body>
	<h3>로그인</h3>
	<form action="/mvc03/login.do" method="post">
		<span>아이디</span>
		<input type="text" name="id"/>
		<br>
		<span>비밀번호</span>
		<input type="password" name="pw"/>
		<br>
		<input type="submit" value="로그인"/>
	</form>

</body>
</html>