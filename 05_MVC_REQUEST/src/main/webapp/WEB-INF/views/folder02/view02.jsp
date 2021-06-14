<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>view03</title>
	<style>
		body {
			margin: 0 auto;
			width: 680px;
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>view02.jsp</h1>
	<p>이름: ${person.name}</p>
	<p>나이: ${person.age}</p>
	<p>
		취미:
		<c:forEach items="${person.hobbies}" var="hobbie">
			${hobbie}
		</c:forEach> 
	</p>
</body>
</html>