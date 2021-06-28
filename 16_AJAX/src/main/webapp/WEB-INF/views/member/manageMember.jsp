<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_selectMemberList();
			fn_selectMemberByNo();
			fn_insertMember();
			fn_deleteMember()
		});
		var page = 1;
		// 1. 회원 목록
		function fn_selectMemberList(){
			$('#member_list').empty();
			var obj = {
				page: page
			}
			$.ajax({
				url: 'selectListMember.do',
				type: 'post',
				data: JSON.stringify(obj),
				contentType: 'application/json',
				dataType : 'json',
				success : function(data) {
					if(data.result > 0) 
						$.each(data.list, function(index, member){
							var tr = $('<tr>').appendTo($('#member_list'));
							$('<td>').text(member.id).appendTo(tr);
							$('<td>').text(member.name).appendTo(tr);
							$('<td>').text(member.address).appendTo(tr);
							$('<td>').text(member.gender).appendTo(tr);
							$('<td>').html('<input type="button" value="조회" class="view_btn">').appendTo(tr);
						})
					else 
						$('<tr>').append($('<td colspan="5">등록한 회원이 없습니다.</td>')).appendTo($('#member_list'));
				}
			})
		}
		// 2. 회원 목록 페이징
		function fn_paging(){
			
		}
		// 3. 회원 정보 보기
		function fn_selectMemberByNo() {
			
		}
		// 4. 회원 삽입
		function fn_insertMember() {
			$('#insert_btn').click(function(){
				var member = {
					id: $('#id').val(),
					name: $('#name').val(),
					address: $('#address').val(),
					gender: $('input:radio[name="gender"]:checked').val()
				};
				$.ajax({
					url: 'insertMember.do',
					type: 'post',
					data: JSON.stringify(member), // JSON 전달
					contentType: 'application/json',
					dataType : 'json',
					success : function(data){
						if(data.result > 0){
							alert('새로운 회원이 등록되었습니다.');
							fn_selectMemberList();
						}
					},
					error : function(xhr) {
						if(xhr.status >= 1000 && xhr.status.status < 2000){
							alert(xhr.responseText);
						}
					}
				});
			});
		}
		// 5. 회원 삭제
		function fn_deleteMember() {
			
		}
	</script>
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