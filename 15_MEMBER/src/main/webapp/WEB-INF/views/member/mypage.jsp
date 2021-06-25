<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		// field
		var pw
		var pw1
		var na
		var isChangePw = false;
		$(document).ready(function(){
			pw = $('#pw');
			pw1 = $('#pw1');
			na = $('#name');
			$('#change_pw_btn').click(event_change_pw);
			$('#back_btn').click(event_back);
			$('#edit_btn').click(event_edit);
		});
		function event_change_pw() {
			pw.attr('disabled', false);
			pw1.attr('disabled', false);
			isChangePw = true;
		}
		function event_back() {
			location.href='/member/';
		}
		function event_edit() {
			if(isChangePw == true){
				fn_pw_check();
				fn_pw1_check();
				if(check_pw == false || check_pw1 == false){
					alert('비밀번호를 다시 확인해 주세요.');
					pw.focus();
					return;
				}
			}
			fn_na_check();
			if(check_na == false){
				alert('이름을 입력해 주세요.');
				na.focus();
				return;
			}
			$('#f').submit();
		}
		var check_pw = false;
		function fn_pw_check(){
			var regPW = /^[0-9]{1,4}$/;  // 나중에 수정해서 사용
			if (!regPW.test(pw.val())) {
				check_pw = false;
				pw.attr("class","not_check");
			} else {
				check_pw = true;
				pw.attr("class","check");
			}
		}
		var check_pw1 = false;
		function fn_pw1_check(){
			if(pw.val() != pw1.val()) {
				check_pw1 = false;
				pw1.attr("class","not_check");
			} else {
				check_pw1 = true;
				pw1.attr("class","check");
			}
		}
		var check_na = false;
		function fn_na_check(){
			if(na.val() == '') {
				check_na = false;
				na.attr("class","not_check");
			} else {
				check_na = true;
				na.attr("class","check");
			}
		}
	</script>
	<link rel="stylesheet" href="/member/resources/css/mypage.css"/>
</head>
<body>
	<form id="f" action="edit.do">
		<h3>마이페이지</h3>
		<input type="hidden" name="no" value="${loginUser.no}"/>
		아이디<br/>
		<input type="text" value="${loginUser.id}" readonly disabled/><br/>
		<br/>
		<input type="button" value="비밀번호변경" id="change_pw_btn"/><br/>
		비밀번호변경<br/>
		<input type="password" name="pw" id="pw" disabled/><br/>
		비밀번호확인<br/>
		<input type="password" id="pw1" disabled/><br/>
		<br/>
		이름<br/>
		<input type="text" name="name" id="name" value="${loginUser.name}"/><br/>
		<br/>
		이메일<br/>
		<input type="text" value="${loginUser.email}" readonly disabled/><br/>
		<br/>
		가입일<br/>
		<input type="text" value="${loginUser.regdate}" readonly disabled/><br/>
		<br/>
		<input type="button" value="돌아가기" id="back_btn"/>
		<input type="button" value="개인정보수정" id="edit_btn"/>
	</form>
</body>
</html>