$(document).ready(function(){
	// eventListener
	$('#join_btn').click(event_join); // 가입하기버튼
	$('#back_btn').click(event_back); // 뒤로가기버튼
	$('#verify_key_btn').click(event_verify_key); // 이메일인증버튼
	$('#check_key_btn').click(event_check_key); // 확인버튼
});

// field
var id;
var pw;
var pw1;
var na;
var isCallKey = false;
var isCheckKey = false;
var emailKey; 

// eventListener
// 가입하기버튼
function event_join() {
	id = $('#id');			
	pw = $('#pw');			
	pw1 = $('#pw1');			
	na = $('#name');
	if(id.val().trim() == ''){
		alert('아이디를 입력해주세요.');
		id.focus();
		return;
	}
	if(pw.val() == ''){
		alert('비밀번호를 입력해주세요.');
		pw.focus();
		return;
	}
	if(pw.val() != pw1.val()){
		alert('비밀번호를 다시 확인해주세요.');
		pw1.focus();
		return;
	}
	if(na.val().trim() == ''){
		alert('이름을 입력해주세요.');
		na.focus();
		return;
	}
	if(isCheckKey == false) {
		alert('이메일인증을 해 주세요.');
		$('#email').focus();
		return;
	}
	fn_idCheck();
}
// 뒤로가기버튼
function event_back() {
	location.href='/member/';
}
// 이메일인증버튼
function event_verify_key() {
	isCallKey = true;
	$('#email').attr('readonly',true);
	var button = $(this);
	button.attr('disabled', true);
	$.ajax({
		url: 'verifyKey.do',
		type: 'get',
		data: 'email=' + $('#email').val(),
		dataType: 'text',
		success: function(res) {
			console.log(res);
			if(res == ''){
				alert('오류가 발생했습니다.');
				button.attr('disabled', false);
				$('#email').attr('readonly',false);
			} else {
				alert('이메일이 전송되었습니다.');
				emailKey = res;
			}
		},
		error: function(xhr) {
			console.log(xhr);	
			button.attr('disabled', false);
			$('#email').attr('readonly',false);
		}
	})
}
// 확인버튼
function event_check_key() {
	$('#key').attr('readonly',true);
	$(this).attr('disabled',true);
	if(!isCallKey){
		alert('이메일인증 버튼을 우선 선택해 주세요.');
		return;
	}
	if($('#key').val().toUpperCase() == emailKey){
		alert('이메일인증에 성공했습니다.');
		isCheckKey = true;
	} else {
		alert('인증번호가 다릅니다.');
		$('#key').attr('readonly',false);
		$(this).attr('disabled',false);
	}
	
}

// function
function fn_idCheck() {
	$.ajax({
		url: 'idCheck.do',
		type: 'get',
		data: 'id=' + id.val(),
		dataType: 'json',
		success: function(obj){
			if(obj.count == 0)
				$('#f').submit();
			else{
				alert('가입된 아이디입니다.');
				id.focus();						
			}
		},
		error: function(xhr){
			console.log(xhr);
		}
	})
}
