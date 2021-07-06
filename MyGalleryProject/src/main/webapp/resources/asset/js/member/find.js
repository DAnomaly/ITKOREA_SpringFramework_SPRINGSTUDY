let isFindId = true;
$(document).ready(function(){
	fn_setpage();
	fn_id_submit();
	fn_pw_submit();
})
function fn_setpage(){
	if(isFindId){
		$('#opt1').show();
		$('#opt2').hide();
	} else {
		$('#opt1').hide();
		$('#opt2').show();
	}
}
function setFindId(isId){
	isFindId = isId;
	fn_setpage();
}
function fn_id_submit(){
	$('#id_btn').click(function(){
		$('#id_f').submit();
	})
	$('#id_f').submit(function(event){
		if($('#id_name').val() == ''){
			alert('이름을 입력해 주세요.');
			$('#id_name').focus();
			event.preventDefault();
			return false;
		}
		if($('#id_email').val() == '') {
			alert('이메일을 입력해 주세요.');
			$('#id_email').focus();
			event.preventDefault();
			return false;
		}
	})
}
function fn_pw_submit(){
	$('#pw_btn').click(function(){
		$('#pw_f').submit();
	})
	$('#pw_f').submit(function(event){
		if($('#pw_id').val() == ''){
			alert('아이디을 입력해 주세요.');
			$('#pw_id').focus();
			event.preventDefault();
			return false;
		}
		if($('#pw_name').val() == '') {
			alert('이름을 입력해 주세요.');
			$('#id_name').focus();
			event.preventDefault();
			return false;
		}
		if($('#pw_email').val() == '') {
			alert('이메일을 입력해 주세요.');
			$('#pw_email').focus();
			event.preventDefault();
			return false;
		}
		
	})
}