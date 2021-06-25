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
			$('#change_id').click(function(){
				$('#div_id').show();
				$('#div_pw').hide();
			});
			$('#change_pw').click(function(){
				$('#div_id').hide();
				$('#div_pw').show();
			})
			if('${param.f}' == 'pw'){
				$('#change_pw').click();
			} else {
				$('#change_id').click();
			}
			$('#findid_btn').click(function(){
				$('#id_f').submit();
			})
			$('#findpw_btn').click(function(){
				$('#pw_f').submit();
			})
		});
	</script>
</head>
<body>

	<a id="change_id">아이디 찾기</a>
	<a id="change_pw">비밀번호 찾기</a>
	<div id="div_id">
		<form action="findId.do" id="id_f" method="post">
			<h3>아이디 찾기</h3>
			이메일<br>
			<input type="text" name="email"/><br>
			<br>
			<input type="button" value="아이디 찾기" id="findid_btn"/>
		</form>
	</div>
	<div id="div_pw">
		<form action="findPw.do" id="pw_f" method="post">
			<h3>비밀번호 찾기</h3>
			아이디<br>
			<input type="text" name="id"/><br>
			<br>
			이메일<br>
			<input type="text" name="email"/><br>
			<br>
			<input type="button" value="비밀번호 찾기" id="findpw_btn"/>
		</form>
	</div>

</body>
</html>