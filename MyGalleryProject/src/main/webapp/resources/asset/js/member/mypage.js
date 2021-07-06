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