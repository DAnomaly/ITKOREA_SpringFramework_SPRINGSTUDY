<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 회원가입</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/mygallery/resources/asset/js/member/join.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form id="f">
			<table>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="id" id="id"/>
							<input type="button" value="중복확인" id="id_btn"/>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="password" name="pw" id="pw"/>
						</td>
					</tr>
					<tr>
						<td>비밀번호 재확인</td>
						<td>
							<input type="password" name="pw1" id="pw1"/>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<input type="text" name="name" id="name"/>
						</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>
							<input type="text" name="tel" id="tel"/>
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
							<input type="text" name="email" id="email"/>
							<input type="button" value="이메일인증" id="email_btn"/>
						</td>
					</tr>
					<tr>
						<td>인증코드입력</td>
						<td>
							<input type="text" name="key" id="key"/>
							<input type="button" value="인증번호확인" id="key_btn"/>
						</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>
							<input type="text" name="address" id="address"/>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="가입하기" id="join_btn"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</section>
</body>
</html>