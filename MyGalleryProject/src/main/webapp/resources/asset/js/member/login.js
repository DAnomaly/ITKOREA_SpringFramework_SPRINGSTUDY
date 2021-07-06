$(document).ready(function(){
	fn_f_submit();
})
function fn_f_submit(){
	$('#f').submit(function(event){
		event.preventDefault();
		if(id == '' || pw == ''){
			alert('아이디와 비밀번호를 입력해 주세요.');
			return false;
		}
		var member = new Object();
		member.id = $('#id').val();
		member.pw = $('#pw').val();
		$.ajax({
			url: 'login.do',
			type: 'post',
			data: JSON.stringify(member),
			contentType: 'application/json',
			dataType: 'json',
			success: function(data){
				if(data.result){
					location.href='/mygallery/index.do';
				} else {
					alert('아이디 또는 비밀번호가 올바르지 않습니다.');
				}
			}
		})
		return false;
	})
}