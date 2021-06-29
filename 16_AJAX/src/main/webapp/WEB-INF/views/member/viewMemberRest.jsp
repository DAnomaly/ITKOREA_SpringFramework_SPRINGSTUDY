<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원정보 확인</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="/ajax/resources/js/viewMemberRest.js" type="text/javascript" charset="utf-8"></script>
	<link href="/ajax/resources/css/viewMemberRest.css" type="text/css" rel="stylesheet">
</head>
<body>
	<h3>회원정보 확인</h3>
	<input type="hidden" name="no" id="no" value="${param.no}"/>
	<table>
		<tbody>
			<tr>
				<td>아이디</td>
				<td><input name="id" id="id" disabled></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="name" id="name" ></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input name="address" id="address"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label><input type="radio" id="male" name="gender" value="남">남</label>
					<label><input type="radio" id="female" name="gender" value="여">여</label>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" id="edit_btn"/>
					<input type="button" value="삭제" id="del_btn"/>
					<input type="button" value="닫기" id="close_btn"/>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>