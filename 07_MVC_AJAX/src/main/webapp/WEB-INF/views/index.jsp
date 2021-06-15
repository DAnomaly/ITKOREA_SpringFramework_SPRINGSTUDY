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
		// 페이지 로드
		$(document).ready(function(){
			$('#btn1').on('click',fn1);
			$('#btn2').on('click',fn2);
			$('#btn3').on('click',fn3);
		})
		// 함수
		function fn1() {
			$.ajax({
				url: 'v01',
				type: 'GET',
				data: 'name=' + $('#name').val() + "&age=" + $('#age').val(),
				dataType: 'text',
				success:
					function(responseData) { // responseData에 return p; 로 반환한 json 데이터가 반환된다.
						console.log(responseData);
					},
				error:
					function(xhr, text, error) {
						console.log(xhr.responseText + ", " + text + "," + error);
					}
			})
		}
		function fn2() {
			$.ajax({
				url: 'v02',
				type: 'GET',
				data: 'name=' + $('#name').val() + "&age=" + $('#age').val(),
				dataType: 'json',
				success:
					function(responseData) { // responseData에 return p; 로 반환한 json 데이터가 반환된다.
						console.log(responseData);
					},
				error:
					function(xhr, text, error) {
						console.log(xhr.responseText + ", " + text + "," + error);
					}
			})
		}
		function fn3() {
			$.ajax({
				url: 'v03',
				type: 'GET',
				data: 'name=' + $('#name').val() + "&age=" + $('#age').val(),
				dataType: 'json',
				success:
					function(responseData) { // responseData에 return p; 로 반환한 json 데이터가 반환된다.
						console.log(responseData);
					},
				error:
					function(xhr, text, error) {
						console.log(xhr.responseText + ", " + text + "," + error);
					}
			})
		}
	</script>
</head>
<body>

	<form id="f">
		<input type="text" name="name" id="name" placeholder="이름"><br>
		<input type="text" name="age" id="age" placeholder="나이"><br>
		<input type="button" id="btn1" value="전송1"/>
		<input type="button" id="btn2" value="전송2"/>
		<input type="button" id="btn3" value="전송3"/>
	</form>

</body>
</html>