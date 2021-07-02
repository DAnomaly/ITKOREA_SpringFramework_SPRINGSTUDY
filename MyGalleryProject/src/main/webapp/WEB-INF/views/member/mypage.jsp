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
	<script>
		alert('로그인이 필요한 서비스입니다.');
		location.href='loginView.do';
	</script>
	</c:if>
	<script>
		var change_pw = false;
		$(document).ready(function(){
			fn_ready();
			fn_pw_btn();
			fn_edit_btn();
			fn_remove_btn();
		})
		function fn_ready(){
			$('.pw_box').hide();
		}
		function fn_pw_btn(){
			$('#pw_btn').click(function(){
				change_pw = true;
				$('.pw_box').show();
				$('#pw').attr('disabled',false);
				$('#pw1').attr('disabled',false);
				$('#pw_btn').parent().parent().hide();
			})
		}
		function fn_edit_btn(){
			$('#edit_btn').click(function(){
				if(change_pw){
					if($('#pw').val() == ''){
						alert('비밀번호를 입력하세요.');
						return;
					}
					if($('#pw1').val() != $('#pw').val()) {
						alert('비밀번호를 다시 확인하세요.');
						return;
					}
				}
				if($('#name').val() == ''){
					alert('이름을 입력하세요.');
					return;
				}
				var member = new Object();
				member.memberNo = $('#no').val();
				if(change_pw)
					member.pw = $('#pw').val();
				member.name = $('#name').val();
				member.address = $('#address').val();
				$.ajax({
					url: 'edit.do',
					type: 'post',
					data: JSON.stringify(member),
					contentType: 'application/json',
					dataType: 'json',
					success: function(data){
						if(data.result){
							alert('회원정보가 정상적으로 수정되었습니다.');
							location.href='mypage.do';
						} else {
							alert('정보 수정중 오류가 발생했습니다.');
						}
					}
				})
			})
		}
		function fn_remove_btn(){
			$('#remove_btn').click(function(){
				location.href="removePage.do";
			})
		}
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
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
</body>
</html>