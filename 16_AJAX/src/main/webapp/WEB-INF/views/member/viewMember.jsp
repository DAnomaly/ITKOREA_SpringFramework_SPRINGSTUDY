<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원정보 확인</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_loadPage();
			fn_edit_btn();
			fn_close_btn();
		});
		function fn_loadPage() {
			var tr = $(opener.document.getElementById('no' + '${param.no}'));
			$('#id').val($(tr.children()[0]).text());
			$('#name').val($(tr.children()[1]).text());
			$('#address').val($(tr.children()[2]).text());
			if($(tr.children()[3]).text() == '남')
				$('#male').attr('checked',true);
			else
				$('#female').attr('checked',false);
		}
		function fn_edit_btn() {
			var member = new Object();
			member.no = $('#no').val();
			member.name = $('#name').val();
			member.address = $('address').val();
			member.gender = $('input:radio[name="gender"]:checked').val();
			$('#edit_btn').click(function(){
				$.ajax({
					url: 'editMember.do',
					type: 'post',
					data: JSON.stringify(member),
					contentType: 'application/json',
					dataType: 'json',
					success: function(obj) {
						if(obj.result) {
							alert('정상적으로 수정되었습니다.');
						} else {
							alert('수정 중 오류가 발생했습니다.')
						}
					}
				})
			});
		}
		function fn_del_btn() {
			$('#del_btn').click(function(){
				var member = new Object();
				member.no = $('#no').val();
				$.ajax({
					url: 'delMember.do',
					type: 'post',
					data: JSON.stringify(member),
					contentType: 'application/json',
					dataType: 'json',
					success: function(obj) {
						if(obj.result) {
							alert('정상적으로 삭제되었습니다.');
						} else {
							alert('삭제 중 오류가 발생했습니다.')
						}
					}
				})
			});
		}
		function fn_close_btn() {
			$('#close_btn').click(function(){
				window.close();
			})
		}
	</script>
	<style>
		body {
			text-align: center;
		}
		table {
			margin: 0 auto;		
		}
		tr td:nth-of-type(1) {
			font-weight: bold;
		}
		tr td:nth-of-type(2) {
			text-align: left;
		}
		input {
			padding: 5px;
			background: none;
			border: 0;
			outline: none;
			border-bottom: 1px solid silver;
		}
		input:focus {
			border-bottom: 1px solid blue;
		}
		input:disabled {
			color: gray;
		}
		input[type="button"] {
			cursor: pointer;
		}
		input[type="button"]:hover {
			border-bottom: 1px solid blue;
		}
		
	</style>
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