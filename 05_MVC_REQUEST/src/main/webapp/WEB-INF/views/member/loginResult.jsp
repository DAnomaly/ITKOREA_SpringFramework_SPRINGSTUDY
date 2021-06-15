<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인 결과</title>
	<style>
		body {
			margin: 0 auto;
			width: 680px;
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>로그인 결과</h1>
	아이디: ${id}<br>
	비밀번호: ${pw}<br>
</body>
</html>