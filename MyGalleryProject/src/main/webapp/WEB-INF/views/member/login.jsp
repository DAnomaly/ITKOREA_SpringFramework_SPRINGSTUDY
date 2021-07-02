<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 로그인</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			fn_f_submit();
		})
		function fn_f_submit(){
			$('#f').submit(function(event){
				event.preventDefault();
				if(id == '' || pw == ''){
					alert('아이디와 비밀번호를 입력해 주세요.');
					return false;
				}
				var member = new Object();
				member.id = $('#id').val();
				member.pw = $('#pw').val();
				$.ajax({
					url: 'login.do',
					type: 'post',
					data: JSON.stringify(member),
					contentType: 'application/json',
					dataType: 'json',
					success: function(data){
						if(data.result){
							location.href='/mygallery/index.do';
						} else {
							alert('아이디 또는 비밀번호가 올바르지 않습니다.');
						}
					}
				})
				return false;
			})
		}
		
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form id="f">
			<div class="left">
				<label><span>아이디</span><input type="text" name="id" id="id"/></label><br>
				<label><span>비밀번호</span><input type="password" name="pw" id="pw"/></label><br>
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
				<span>아이디/비밀번호를 잊으셨나요?</span>
				<a href="/mygallery/member/findView.do">아이디/비밀번호 찾기</a>
			</div>
		</div>
	</section>
</body>
</html>