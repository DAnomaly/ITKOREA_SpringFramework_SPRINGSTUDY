$(document).ready(function(){
	fn_loadPage();
	fn_edit_btn();
	fn_del_btn();
	fn_close_btn();
});
function fn_loadPage() {
	var tr = $(opener.document.getElementById('no' + $('#no').val()));
	$('#id').val($(tr.children()[0]).text());
	$('#name').val($(tr.children()[1]).text());
	$('#address').val($(tr.children()[2]).text());
	if($(tr.children()[3]).text() == '남')
		$('#male').attr('checked',true);
	else
		$('#female').attr('checked',true);
}
function fn_edit_btn() {
	$('#edit_btn').click(function(){
		var member = new Object();
		member.no = $('#no').val();
		member.name = $('#name').val();
		member.address = $('#address').val();
		member.gender = $('input:radio[name="gender"]:checked').val();
		$.ajax({
			url: 'editMember.do',
			type: 'post',
			data: JSON.stringify(member),
			contentType: 'application/json',
			dataType: 'json',
			success: function(obj) {
				if(obj.result) {
					alert('정상적으로 수정되었습니다.');
					opener.fn_selectMemberList();
				} else {
					alert('수정 중 오류가 발생했습니다.');
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
					window.close();
					opener.fn_selectMemberList();
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