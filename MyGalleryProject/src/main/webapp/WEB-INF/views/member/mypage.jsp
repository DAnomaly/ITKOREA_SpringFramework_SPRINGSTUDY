<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 마이페이지</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<c:if test="${empty loginMember}">
	<script type="text/javascript" src="/mygallery/resources/asset/js/common/loginCheck.js" charset="utf-8"></script>
	</c:if>
	<script type="text/javascript" src="/mygallery/resources/asset/js/member/mypage.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<form id="f">
			<input type="hidden" name="no" id="no" value="${loginMember.memberNo}"/> 
			<h3>회원 정보 수정</h3>
			<table>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="id" id="id" value="${loginMember.id}" disabled/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="button" value="비밀번호 변경" id="pw_btn"/></td>
					</tr>
					<tr class="pw_box">
						<td>비밀번호</td>
						<td>
							<input type="password" name="pw" id="pw" disabled/>
						</td>
					</tr>
					<tr class="pw_box">
						<td>비밀번호 재확인</td>
						<td>
							<input type="password" name="pw1" id="pw1" disabled/>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<input type="text" name="name" id="name" value="${loginMember.name}"/>
						</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>
							<input type="text" name="tel" id="tel" value="${loginMember.tel}" disabled/>
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
							<input type="text" name="email" id="email" value="${loginMember.email}" disabled/>
						</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>
							<input type="text" name="address" id="address" value="${loginMember.address}"/>
						</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td>
							<input type="text" name="regdate" id="regdate" value="${loginMember.regdate}" disabled/>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="button" value="회원정보수정" id="edit_btn"/>
			<input type="button" value="회원탈퇴" id="remove_btn"/>		
		</form>
	</section>
</body>
</html>