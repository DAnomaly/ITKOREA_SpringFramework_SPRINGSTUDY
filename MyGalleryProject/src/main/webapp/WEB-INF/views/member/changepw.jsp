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
	<script type="text/javascript">
		var notfound = true;
		alert('찾으시는 회원정보가 일치하지 않거나 없습니다.');
		history.back();
	</script>
	</c:if>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_key_btn();
			fn_change_btn();
		})
		
		function fn_key_btn() {
			$('#key_btn').click(function(){
				$.ajax({
					url: 'checkKey.do',
					type: 'get',
					data: 'key=' + $('#key').val(),
					dataType: 'json',
					success: function(data){
						if(data.result) {
							alert('인증에 성공했습니다.');
							$('#pw').attr('disabled',false);
							$('#pw1').attr('disabled',false);
							$('#key').attr('disabled',true);
							$('#change_btn').attr('disabled',false);
						} else {
							alert('올바른 인증번호가 아닙니다.');
						}
					}
				})
			})
		}
		
		function fn_change_btn() {
			$('#change_btn').click(function(){
				if($('#pw').val() == '') {
					alert('비밀번호를 입력해주세요.');
					$('#pw').focus();
					return;
				}
				if($('#pw1').val() != $('#pw').val()){
					alert('비밀번호를 다시 확인해 주세요.');
					$('#pw1').focus();
					return;
				}
				$('#f').submit();
			})
		}
	</script>
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