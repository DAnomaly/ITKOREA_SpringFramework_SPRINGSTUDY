<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원 관리</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />
	<link rel="styleSheet" href="/ajax/resources/css/manageMemberRest.css" type="text/css"  >
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="/ajax/resources/js/manageMemberRest.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<h1>회원 관리</h1>
	
	아이디 
	<input name="id" id="id"/><br>
	이름
	<input name="name" id="name"/><br>
	주소
	<input name="address" id="address"/><br>
	성별
	<label>
		<input type="radio" name="gender" value="남" id="male" checked/>
		남 	
	</label>
	<label>
		<input type="radio" name="gender" value="여" id="female"/>
		여
	</label>
	<br>
	<input type="button" value="등록" id="insert_btn"/>
	<hr/>
	
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
				<td>성별</td>
				<td>비고</td>
			</tr>
		</thead>
		<tbody id="member_list"></tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<div id="paging"></div>
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>