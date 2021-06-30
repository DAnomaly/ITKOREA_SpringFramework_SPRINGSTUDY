<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사원 번호 검색</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		var c;
		var s;
		$(document).ready(function(){
			c = $('#param_c').val();
			s = $('#param_s').val();
			fn_set();
			fn_submit();
			fn_init_btn();
			fn_auto_complete();
			$('#select_c').change();
		});
		
		function fn_set() {
			if(c != ''){
				$('#' + c).attr('selected',true);
			}
			if(s != ''){
				$('#search').val(s);
			}
		}
		
		function fn_submit(){
			$('#f').submit(function(event){
				if($('#search').val() == ''){
					alert('내용을 입력해 주세요.');
					event.preventDefault();
					return false;
				}
			});
		}
		
		function fn_init_btn(){
			$('#init_btn').click(function(){
				location.href='list.do';
			})
		}
		
		function fn_auto_complete(){
			$('#select_c').change(function(){
				$('#auto_complete_list').empty();
				$.ajax({
					url: 'index_list.do',
					method: 'get',
					data: 'c=' + $('#select_c').val(),
					dataType: 'json',
					success: function(data){
						if(data.result){
							$.each(data.list, function(i, item){
								$('<option/>').val(item).appendTo('#auto_complete_list');
							});
						}
					}
				})
			})
			
		}
	</script>
	<style>
		body {
			margin: 0 auto;
			width: 860px;
		}
		form {
			margin: 0 auto;
			margin-top: 80px;
			width: 520px;
			border: 1px solid black;
			padding-bottom: 30px;
		}
		h1 {
			text-align: center;
		}
		select, input {
			box-sizing: border-box;
			height: 25px;
		}
		.search_box {
			text-align: center;
		}
		select {
			outline: none;
			border: 1px solid #606060;
			background-color: #606060;
			color: #ffffff;
		}
		select:focus {
			border: 1px solid white;
		}
		input {
			border: none;
			outline: none;
		}
		input[type="text"] {
			border: 1px solid gray;
			padding: 0 10px;
		}
		input[type="submit"], input[type="button"] {
			border: 1px solid #606060;
			background-color: #606060;
			padding: 0 5px;
			color: #ffffff;
			font-weight: bold;
			cursor: pointer;
		}
		input[type="submit"]:focus, input[type="button"]:focus {
			border: 1px solid #ffffff;
		}
	</style>
</head>
<body>
	<input type="hidden" id="param_c" value="${param.c}"/>
	<input type="hidden" id="param_s" value="${param.s}"/>
	<form id="f" action="list.do" method="get">
		<h1>사원 번호 검색</h1>
		<div class="search_box">
			<select id="select_c" name="c">
				<option id="EMPLOYEE_ID" value="EMPLOYEE_ID">EMPLOYEE_ID</option>
				<option id="LAST_NAME" value="LAST_NAME">LAST_NAME</option>
				<option id="EMAIL" value="EMAIL">EMAIL</option>
				<option id="PHONE_NUMBER" value="PHONE_NUMBER">PHONE_NUMBER</option>
				<option id="JOB_ID" value="JOB_ID">JOB_ID</option>
				<option id="DEPARTMENT_ID" value="DEPARTMENT_ID">DEPARTMENT_ID</option>
			</select>
			<input type="text" name="s" id="search" placeholder="내용입력" list="auto_complete_list" autocomplete='off'/>
			<datalist id="auto_complete_list"></datalist>
			<input type="submit" value="검색"/>
			<input type="button" value="전체조회" id="init_btn"/>
		</div>
	</form>
</body>
</html>