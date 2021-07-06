<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MyGalleryProject : 아이디/비밀번호찾기</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<c:if test="${empty findMember}">
	<script type="text/javascript" src="/mygallery/resources/asset/js/member/changepw_notfound.js" charset="utf-8"></script>
	</c:if>
	<script type="text/javascript" src="/mygallery/resources/asset/js/member/changepw.js" charset="utf-8"></script>
	<link rel="stylesheet" href="/mygallery/resources/asset/css/common/header.css">
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div class="container">
			<form id="f" action="changePw.do" method="post">
				<table>
					<tbody>
						<tr>
							<th>인증번호</th>
							<td>
								<input type="text" name="key" id="key"/>
								<input type="button" value="확인" id="key_btn"/>
							</td>
						</tr>
						<tr>
							<th>새로운 비밀번호</th>
							<td>
								<input type="text" name="pw" id="pw" disabled/>
							</td>
						</tr><tr>
							<th>비밀번호 재확인</th>
							<td>
								<input type="text" name="pw1" id="pw1" disabled/>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="memberNo" value="${findMember.memberNo}" id="memberNo"/>
				<input type="button" value="비밀번호 변경" id="change_btn" disabled/>
			</form>
		</div>
	</section>
</body>
</html>