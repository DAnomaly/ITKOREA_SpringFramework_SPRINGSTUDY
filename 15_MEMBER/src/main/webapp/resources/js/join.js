
// field
var id;
var pw;
var pw1;
var na;
var check_id = false;
var check_pw = false;
var check_pw1 = false;
var check_na = false;

$(document).ready(function(){
	// eventListener
	$('#join_btn').click(event_join); // 가입하기버튼
	$('#back_btn').click(event_back); // 뒤로가기버튼
	$('#verify_key_btn').click(event_verify_key); // 이메일인증버튼
	$('#check_key_btn').click(event_check_key); // 확인버튼
	
	id = $('#id');			
	pw = $('#pw');			
	pw1 = $('#pw1');			
	na = $('#name');
	
	id.blur(fn_id_check);
	pw.blur(fn_pw_check);
	pw1.blur(fn_pw1_check);
	na.blur(fn_na_check);
});

// eventListener
// 가입하기버튼
function event_join() {
	id.attr('readonly',true);
	pw.attr('readonly',true);
	pw1.attr('readonly',true);
	na.attr('readonly',true);
	
	fn_id_check();
	fn_pw_check();
	fn_pw1_check();
	fn_na_check();
	
	if(!check_id || !check_pw || !check_pw1 || !check_na){
		id.attr('readonly',false);
		pw.attr('readonly',false);
		pw1.attr('readonly',false);
		na.attr('readonly',false);
		return;
	}
	
	fn_idCheck();
}
// 뒤로가기버튼
function event_back() {
	location.href='/member/';
}
// 이메일인증버튼
var isCallKey = false;
var isCheckKey = false;
var emailKey; 
function event_verify_key() {
	isCallKey = true;
	if($('#email').val() == ''){
		alert('이메일을 입력하세요.');
		$('#email').attr("class","not_check")
		return;
	} else {
		$('#email').attr("class","check")
	}
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
		$('#key').attr("class","check")
		$('#key').attr('disabled',true);
		isCheckKey = true;
	} else {
		alert('인증번호가 다릅니다.');
		$('#key').attr('readonly',false);
		$(this).attr('disabled',false);
		$('#key').attr("class","not_check")
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
				id.attr("class","not_check");
				id.focus();						
			}
		},
		error: function(xhr){
			console.log(xhr);
		}
	})

	id.attr('readonly',false);
	pw.attr('readonly',false);
	pw1.attr('readonly',false);
	na.attr('readonly',false);
}

function fn_id_check(){
	var regID = /^[a-z]{1,12}$/;  // 나중에 수정해서 사용
	if (!regID.test(id.val())) {
		check_id = false;
		id.attr("class","not_check");
	} else {
		check_id = true;
		id.attr("class","check");
	}
}
function fn_pw_check(){
	var regPW = /^[0-9]{1,4}$/;  // 나중에 수정해서 사용
	if (!regPW.test(pw.val())) {
		check_pw = false;
		pw.attr("class","not_check");
	} else {
		check_pw = true;
		pw.attr("class","check");
	}
}
function fn_pw1_check(){
	if(pw.val() != pw1.val()) {
		check_pw1 = false;
		pw1.attr("class","not_check");
	} else {
		check_pw1 = true;
		pw1.attr("class","check");
	}
}
function fn_na_check(){
	if(na.val() == ''){
		check_na = false;
		na.attr("class","not_check");
	} else {
		check_na = true;
		na.attr("class","check");
	}
}
