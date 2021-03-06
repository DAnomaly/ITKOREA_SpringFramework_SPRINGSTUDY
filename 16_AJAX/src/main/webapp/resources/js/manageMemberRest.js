

$(document).ready(function(){
	fn_selectMemberList();
	fn_paging();
	fn_selectMemberByNo();
	fn_insertMember();
});
var page = 1;

// 1. 회원 목록
function fn_selectMemberList(){
	$('#member_list').empty();
	$('#paging').empty();
	$.ajax({
		url: 'member',
		type: 'get',
		data: 'page=' + page,
		dataType : 'json',
		success : function(data) {
			if(data.result > 0){
				// 회원 목록 생성
				$.each(data.list, function(index, member){
					var tr = $('<tr>').attr('id','no'+ member.no).appendTo($('#member_list'));
					$('<td>').text(member.id).appendTo(tr);
					$('<td>').text(member.name).appendTo(tr);
					$('<td>').text(member.address).appendTo(tr);
					$('<td>').text(member.gender).appendTo(tr);
					$('<td>').html('<input type="button" value="조회" class="view_btn" data-no="' + member.no + '">').appendTo(tr);
				})
				// 페이지 메뉴 생성
				var infoRecord = data.infoRecord;
				// PREV
				if(infoRecord.beginPage == 1)
					$('<a>').attr('class','nonclick').html('<i class="fas fa-angle-left"></i>').appendTo($('#paging'));
				else 
					$('<a>').attr('class','click').data('move',infoRecord.beginPage - 1).html('<i class="fas fa-angle-left"></i>').appendTo($('#paging'));
				// NUMBER
				for (var i = infoRecord.beginPage; i <= infoRecord.endPage; i++)
					if(page != i)
						$('<a>').attr('class','click').data('move', i).text(i).appendTo($('#paging'));
					else 
						$('<a>').attr('class','nonclick nowPage').text(i).appendTo($('#paging'));
				// NEXT
				if(infoRecord.endPage == infoRecord.totalPage)
					$('<a>').attr('class','nonclick').html('<i class="fas fa-angle-right"></i>').appendTo($('#paging'));
				else 
					$('<a>').attr('class','click').data('move',infoRecord.endPage + 1).html('<i class="fas fa-angle-right"></i>').appendTo($('#paging'));
			} else {
				// 회원 없음
				$('<tr>').append($('<td colspan="5">등록한 회원이 없습니다.</td>')).appendTo($('#member_list'));
			}
		},
		error : function () {
			// 오류
			$('<tr>').append($('<td colspan="5">등록한 회원이 없습니다.</td>')).appendTo($('#member_list'));
		}
	})
}

// 2. 페이징 이동
function fn_paging(){
	$(document).on('click','.click',function(){
		page = $(this).data('move');
		fn_selectMemberList();
	})
}

// 3. 회원 정보 보기
function fn_selectMemberByNo() {
	$(document).on('click','.view_btn',function(){
		var viewPage = window.open('viewMemberRest.do?no=' + $(this).data('no'),'viewMember','width=300, height=400, left=100, top=50, toolbar=no, menubar=no, scrollbars=no, resizable=no');
	})
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
			url: 'member',
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
				if(xhr.status >= 1000 && xhr.status < 2000){
					alert(xhr.responseText);
				}
			}
		});
	});
}