<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 갤러리 작성</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<c:if test="${empty loginMember}">
	<script>
		alert('로그인이 필요한 서비스입니다.');
		location.href='/mygallery/member/loginView.do';
	</script>
	</c:if>
	<script>
		$(document).ready(function(){
			fn_f_submit()
		})
		function fn_f_submit(){
			// 버튼 클릭시 폼 작동
			$('#f_btn').click(function(){
				$('#f').submit();
			});
			// 폼 작동
			$('#f').submit(function(event){
				if($('#title').val() == ''){
					alert('제목은 필수입니다.');
					$('#title').focus();
					event.preventDefault();
					return false;
				}
				if($('#image').val() == ''){
					alert('이미지는 필수입니다.');
					$('#image').focus();
					event.preventDefault();
					return false;
				}
				return true;
			});
		}
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form id="f" action="insert.do" method="post" enctype="multipart/form-data">
			<label>
				<span>제목</span><br>
				<input type="text" name="title" id="title"/><br>
			</label>
			<label>
				<span>내용</span><br>
				<textarea name="content" id="content"></textarea><br>
			</label>
			<span>
				<span>이미지</span><br>
				<input type="file" name="image" id="image"/><br>
			</span>
			<input type="button" value="작성" id="f_btn"/>
		</form>
	</section>
</body>
</html>