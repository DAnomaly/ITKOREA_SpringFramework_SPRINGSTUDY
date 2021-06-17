<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>&gt;&gt;INDEX&lt;&lt;</title>
	<style>
		h1 {
			text-align: center;
			margin-top: 80px;
		}
	</style>
	<script>
		setTimeout(function(){
			location.href = 'selectBoardList.do';
		},3000);
	</script>
</head>
<body>
	<h1>3초 후에 게시판으로 이동합니다.</h1>
</body>
</html>