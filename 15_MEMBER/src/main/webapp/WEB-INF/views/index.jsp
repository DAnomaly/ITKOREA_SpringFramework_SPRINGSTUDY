<%@page import="org.apache.commons.codec.binary.Base64"%>
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
			$('#leave_link').click(fn_leave);
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
		function fn_leave(){
			if(confirm('정말로 탈퇴하시겠습니까?'))
				location.href='leave.do';
		}
	</script>
</head>
<body>
	<h1>홈페이지</h1>
	<c:if test="${not empty loginUser}">
		회원번호 : ${loginUser.no}<br>
		아이디 : ${loginUser.id}<br>
		비밀번호 : ${loginUser.pw}<br>
		이름 : ${loginUser.name}<br>
		이메일 : ${loginUser.email}<br>
		가입일 : ${loginUser.regdate}<br>
		<a href="logout.do">로그아웃</a>
		<a id="leave_link">회원탈퇴</a>
		<a href="mypage.do">마이페이지</a>
	</c:if>
	<c:if test="${empty loginUser}">
	<form id="f" action="login.do" method="post">
		<input type="text" name="id" placeholder="ID"/><br>
		<input type="password" name="pw" placeholder="Password"/><br>
		<button>로그인</button>
	</form>
	<a href="joinPage.do">회원가입</a>
	<a href="findIdPage.do">아이디찾기</a>
	<a href="findPwPage.do">비밀번호찾기</a>
	</c:if>
</body>
</html>