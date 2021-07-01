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
			fn_selectAll();
			fn_init_btn();
			fn_f_submit();
		});
		function fn_selectAll() {
			$.ajax({
				url: 'selectAll.do',
				type: 'get',
				dataType: 'json',
				success: function(data){
					fn_list_table(data);
				}
			})
		}
		function fn_init_btn() {
			$('#init_btn').click(function(){
				$('#select_def').attr('selected',true);
				$('#query').val('');
				fn_selectAll();
			})
		}
		function fn_f_submit() {
			$('#f').submit(function(event){
				if($('#column').val() == ''){
					alert("검색 카테고리를 선택해 주세요");
					event.preventDefault();
					return false;
				}
				$.ajax({
					url: 'selectQuery.do',
					type: 'get',
					data: 'column=' + $('#column').val() + '&query=' + $('#query').val(),
					dataType: 'json',
					success: function(data) {
						fn_list_table(data);
					}
				})
				event.preventDefault();
				return false;
			})
		}
		
		function fn_list_table(data) {
			console.log(data.message);
			$('#list').empty();
			switch (data.status) {
			case 200:
				$.each(data.list, function(index, board){
					var tr = $('<tr>').appendTo('#list');
					$('<td>').text(board.no).appendTo(tr);
					$('<td>').text(board.title).appendTo(tr);
					$('<td>').text(board.writer).appendTo(tr);
					$('<td>').text(board.content).appendTo(tr);
					$('<td>').text(board.postdate).appendTo(tr);
				})
				break;
			case 1400:
				var tr = $('<tr>').appendTo('#list');
				$('<td colspan="5">').text('검색된 개시글이 없습니다.').appendTo(tr);
				break;
			default:
				var tr = $('<tr>').appendTo('#list');
				$('<td colspan="5">').text('오류가 발생했습니다.').appendTo(tr);
				break;
			}
			
		}
	</script>
</head>
<body>
	<form method="get" id="f">
		<select id="column" name="column">
			<option value="" id="select_def">:::선택:::</option>
			<option value="TITLE">제목</option>
			<option value="WRITER">작성자</option>
			<option value="CONTENT">내용</option>
			<option value="BOTH">제목+내용</option>
		</select>
		<input type="text" id="query" name="query"/>
		<input type="submit" value="검색" id="search_btn"/>
		<input type="button" value="초기화" id="init_btn"/>
	</form>

	<br><br>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>내용</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
</body>
</html>