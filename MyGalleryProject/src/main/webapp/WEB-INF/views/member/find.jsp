<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		var option = 1;
		$(document).ready(function(){
			fn_setpage();
		})
		function fn_setpage(){
			if(option == 1){
				$('#opt1').show();
				$('#opt2').hide();
			} else {
				$('#opt1').hide();
				$('#opt2').show();
			}
		}
	</script>
</head>
<body>
	<jsp:include page="/resources/asset/jsp/header.jsp"></jsp:include>
	<section>
		<div>
			<ul>
				<li><a href="">아이디 찾기</a></li>
				<li><a href="">비밀번호 찾기</a></li>
			</ul>
			<div id="opt1" class="box opt1">
				<h3>아이디 찾기</h3>
				<form>
					<table>
						<tbody>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" id="name"/></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" id="email"/></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div id="opt2" class="box opt2">
				<h3>비밀번호 찾기</h3>
				<form>
					<table>
						<tbody>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" id="name"/></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" id="email"/></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</section>
</body>
</html>