<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 아이디/비밀번호찾기</title>
	<c:if test="${empty findMember}">
	<script>
		alert('검색된 아이디가 없습니다.');
		history.back();
	</script>
	</c:if>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div class="container">
			<p>찾으시는 아이디는 <span>${findMember.id}</span>입니다.</p>	
			<input type="button" value="이전으로 가기" onclick="location.href='/mygallery/member/findView.do';"/>
			<input type="button" value="로그인" onclick="location.href='/mygallery/member/loginView.do';"/>
		</div>
	</section>
</body>
</html>