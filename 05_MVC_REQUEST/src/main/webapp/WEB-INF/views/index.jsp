<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>index</title>
	<style>
		body {
			margin: 0 auto;
			width: 680px;
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>index.jsp</h1>
	<a href="/mvc03/view01">folder01/view01.jsp로 이동</a><br/>
	<a href="/mvc03/a/b/c/d/e/v02">folder01/view02.jsp로 이동</a><br/>
	<a href="/mvc03/member/view03">folder01/view03.jsp로 이동</a>
	<hr/>
	<a href="/mvc03/f2/v01">folder02/view01.jsp로 이동</a><br/>
	<a href="/mvc03/f2/v02">folder02/view02.jsp로 이동</a><br/>
	<hr/>
	<a href="/mvc03/f3/v01">folder03/view01.jsp로 이동</a><br/>
	<a href="/mvc03/f3/v02">folder03/view02.jsp로 이동</a><br/>
	<a href="/mvc03/f3/v03">folder03/view03.jsp로 이동</a><br/>
	<a href="/mvc03/f3/v04">folder03/view04.jsp로 이동</a><br/>
	<hr/>
	<a href="/mvc03/f4/v01">folder04/view01.jsp로 이동</a><br/>
	<a href="/mvc03/f4/v02">folder04/view02.jsp로 이동</a><br/>
	<hr/>
	<a href="/mvc03/f5/v01?name=브레드&age=50">folder05/view01.jsp로 이동</a><br/>
	<a href="/mvc03/f5/v02?name=앨리스&age=25">folder05/view02.jsp로 이동</a><br/>
	<a href="/mvc03/f5/v03">folder05/view03.jsp로 이동</a><br/>
	<a href="/mvc03/f5/v04?name=앨리스&age=25&hobbies=음악감상&hobbies=수면">folder05/view04.jsp로 이동</a><br/>
	<a href="/mvc03/f5/v05?name=갤럭시&age=8">folder05/view05.jsp로 이동</a><br/>
	<a href="/mvc03/f5/v06?name=갤럭시&age=8">folder05/view06.jsp로 이동</a><br/>
	<hr/>
	<a href="/mvc03/quiz/v1?title=공지사항&hit=5">request방식</a><br/>
	<a href="/mvc03/quiz/v2?title=공지사항&hit=5">@RequestParam방식</a><br/>
	<a href="/mvc03/quiz/v3?title=공지사항&hit=5">DTO방식</a><br/>
	<a href="/mvc03/quiz/v4?title=공지사항&hit=5">@ModelAttribute방식</a><br/>
	<hr/>
	<a href="/mvc03/loginPage.do">로그인 하러 가기</a><br/>
</body>
</html>