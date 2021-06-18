<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>연락처 등록</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"; integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="/contact01/resources/js/insert.js"></script>
</head>
<body>
	<form id="f" action="insert.do" method="post">
		<h3>연락처 등록</h3>
		<br/>
		<span>이름</span><br/>
		<input type="text" name="name" id="name"/><br/>
		<br/>
		<span>전화</span><br/>
		<input type="text" name="tel" id="tel"/><br/>
		<br/>
		<span>주소</span><br/>
		<input type="text" name="addr" id="addr"/><br/>
		<br/>
		<span>이메일</span><br/>
		<input type="text" name="email" id="email"/><br/>
		<br/>
		<span>비고</span><br/>
		<input type="text" name="note" id="note"/><br/>
		<br/>
		<input type="button" value="연락처 저장하기" id="save_btn"/>
		<input type="button" value="전체연락처" id="back_btn"/>
	</form>
</body>
</html>