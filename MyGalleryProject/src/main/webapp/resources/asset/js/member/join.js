$(document).ready(function(){
	fn_join_btn();
	fn_f_submit();
	fn_id_btn();
	fn_email_btn();
	fn_key_btn();
});
var idCheck = false;
function fn_pwCheck() {
	if($('#pw').val() == '') {
		$('#pw').attr('class','red');
		return false;
	}
	$('#pw').attr('class','blue');
	return true;
}
function fn_pw1Check() {
	if($('#pw1').val() != $('#pw').val()) {
		$('#pw1').attr('class','red');
		return false;
	}
	$('#pw1').attr('class','blue');
	return true;
}
function fn_nameCheck() {
	if($('#name').val() == '') {
		$('#name').attr('class','red');
		return false;
	}
	$('#name').attr('class','blue');
	return true;
}
function fn_telCheck() {
	if($('#tel').val() == '') {
		$('#tel').attr('class','red');
		return false;
	}
	$('#tel').attr('class','blue');
	return true;
}
var emailCheck = false;
function fn_join_btn() {
	$('#join_btn').click(function(){
		if(idCheck == false){
			alert('아이디 중복확인을 해주세요.');
			return;
		}
		if(fn_pwCheck() == false || fn_pw1Check() == false){
			alert('비밀번호를 확인해 주세요.');
			return;
		}
		if(fn_nameCheck() == false){
			alert('이름을 입력해 주세요.');
			return;
		}
		if(fn_telCheck() == false){
			alert('전화번호를 입력해 주세요.');
			return;
		}
		if(emailCheck == false){
			alert('이메일 인증을 해 주세요.');
			return;
		}
		$('#f').submit();
	})
}
function fn_f_submit() {
	$('#f').submit(function(event){
		var member = new Object();
		member.id = $('#id').val();
		member.pw = $('#pw').val();
		member.name = $('#name').val();
		member.tel = $('#tel').val();
		member.email = $('#email').val();
		member.address = $('#address').val();
		$.ajax({
			url: 'join.do',
			type: 'post',
			data: JSON.stringify(member),
			contentType: 'application/json',
			dataType: 'json',
			success: function(data){
				if(data.result){
					alert('성공적으로 가입되었습니다.');
					location.href='loginView.do';
				} else {
					alert('가입에 실패하였습니다.');
				}
			},
			error: function() {
				alert('가입에 실패하였습니다.');
			}
		})
		event.preventDefault();
		return false;
	})
}
function fn_id_btn(){
	$('#id_btn').click(function(){
		if($('#id').val() == ''){
			alert('아이디를 입력하세요.');
			$('#id_btn').focus();
			return;
		}
		$('#id').attr('readonly', true);
		$('#id_btn').attr('disabled', true);
		var member = new Object();
		member.id = $('#id').val();
		$.ajax({
			url: 'checkId.do',
			type: 'post',
			data: JSON.stringify(member),
			contentType: 'application/json',
			dataType: 'json',
			success: function(data){
				if(data.result) {
					alert('사용할 수 있는 아이디입니다.');
					idCheck = true;
				} else {
					alert('사용할 수 없는 아이디입니다.\n다른 아이디를 사용해 주세요.');
					$('#id').attr('readonly', false);
					$('#id_btn').attr('disabled', false);
				}
			}
		})
	})
}
var key;
function fn_email_btn(){
	$('#email_btn').click(function(){
		$('#email').attr('readonly',true);
		$('#email_btn').attr('disabled',true);
		var member = new Object();
		member.email = $('#email').val();
		$.ajax({
			url: 'checkEmail.do',
			type: 'post',
			data: JSON.stringify(member),
			contentType: 'application/json',
			dataType: 'json',
			success: function(data){
				if(data.result) {
					alert('귀하의 이메일에 인증번호를 전송했습니다.');
					$('#email').attr('class','blue');
					key = data.key;
				} else {
					$('#email').attr('readonly',false);
					$('#email').attr('class','red');
					$('#email_btn').attr('disabled',false);
					alert('이미 사용중인 이메일입니다.');
				}
			},
			error: function(){
				$('#email').attr('readonly',false);
				$('#email_btn').attr('disabled',false);
			}
		})
	})
}
function fn_key_btn(){
	$('#key_btn').click(function(){
		$('#key').attr('readonly',true);
		if($('#key').val().trim() == key){
			alert('이메일 인증에 성공했습니다.');
			$('#key_btn').attr('disabled', true);
			$('#key').attr('class','blue');
			emailCheck = true;
		} else {
			alert('올바른 인증번호가 아닙니다.');
			$('#key').attr('readonly',false);
			$('#key').attr('class','red');
		}
	})
}