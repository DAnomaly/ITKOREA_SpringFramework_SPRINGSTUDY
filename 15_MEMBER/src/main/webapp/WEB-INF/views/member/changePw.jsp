<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#change_btn').click(function(){
				$('#f').submit();
			});
		})
	</script>
</head>
<body>
	<c:if test="${empty sessionScope.id or empty sessionScope.key or key != param.k}">
		<script>
			alert("잘못된 접근입니다.\n(동일한 브라우저를 사용해 주세요.)");
			location.href="/member/";
		</script>
	</c:if>
	<form id="f" action="changePw.do" method="post">
		<h3>비밀번호 변경</h3>
		새 비밀번호<br>
		<input type="password" name="pw" id="pw"/><br>
		비밀번호 확인<br>
		<input type="password" name="pw1" id="pw1"/><br>
		<input type="button" value="비밀번호 변경" id="change_btn"/>
	</form>
</body>
</html>