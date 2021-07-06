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