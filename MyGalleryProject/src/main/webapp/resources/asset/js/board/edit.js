$(document).ready(function(){
	$('#f').submit(function(event){
		$.ajax({
			url: 'edit.do',
			type: 'post',
			data: $('#f').serialize(),
			dataType: 'json',
			success: function(data){
				if(data.result){
					window.opener.location.reload();
					window.close();
				}
			}
		})
		event.preventDefault();
		return false;
	})
})
function f_submit() {
	if($('#content').val() == ''){
		alert('내용을 입력해 주세요.');
	}
	$('#f').submit();
}