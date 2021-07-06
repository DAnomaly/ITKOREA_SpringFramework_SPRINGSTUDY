<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 아이디/비밀번호찾기</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/member/find.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div>
			<ul>
				<li><a href="javascript:setFindId(true);">아이디 찾기</a></li>
				<li><a href="javascript:setFindId(false);">비밀번호 찾기</a></li>
			</ul>
			<div id="opt1" class="box opt1">
				<h3>아이디 찾기</h3>
				<form id="id_f" action="getidView.do" method="post">
					<table>
						<tbody>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" id="id_name"/></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" id="id_email"/></td>
							</tr>
						</tbody>
					</table>
					<button type="button" id="id_btn">확인</button>
				</form>
			</div>
			<div id="opt2" class="box opt2">
				<h3>비밀번호 찾기</h3>
				<form id="pw_f" action="changepwView.do" method="post">
					<table>
						<tbody>
							<tr>
								<td>아이디</td>
								<td><input type="text" name="id" id="pw_id"/></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" id="pw_name"/></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" id="pw_email"/></td>
							</tr>
						</tbody>
					</table>
					<button type="button" id="pw_btn">확인</button>
				</form>
			</div>
		</div>
	</section>
</body>
</html>