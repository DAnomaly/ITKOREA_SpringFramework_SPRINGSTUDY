<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>인덱스</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#f').submit(fn_form);
		});
	
		function fn_form(event){
			var id = $(this.id);
			var pw = $(this.pw);
			
			if(id.val() == '' || pw.val() == ''){
				alert('아이디와 비밀번호를 입력해 주세요.');
				event.preventDefault();
				return false;
			}
		}
	</script>
</head>
<body>
	<h1>홈페이지</h1>
	
	<form id="f" action="login.do" method="post">
		<input type="text" name="id" placeholder="ID"/><br>
		<input type="password" name="pw" placeholder="Password"/><br>
		<button>로그인</button>
	</form>
	
	<a href="joinPage.do">회원가입</a>
</body>
</html>