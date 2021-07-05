<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<h1><a href="/mygallery/">MyGalleryProject</a></h1>
	<div>
		<c:if test="${empty loginMember}">
		<span id="login">
			<a href="/mygallery/member/loginView.do">로그인</a>
			<a href="/mygallery/member/joinView.do">회원가입</a>
		</span>
		</c:if>
		<c:if test="${not empty loginMember}">
		<span id="empty_login">
			<span>'${loginMember.name}'님 안녕하세요!</span>
			<a href="/mygallery/member/logout.do">로그아웃</a>
		</span>
		</c:if>
	</div>
	<nav>
		<ul>
			<li><a href="/mygallery/gallery/list.do">갤러리</a></li>
			<li><a href="/mygallery/board/list.do">자유게시판</a></li>
			<li><a href="/mygallery/member/mypage.do">마이페이지</a></li>
		</ul>
	</nav>
</header>