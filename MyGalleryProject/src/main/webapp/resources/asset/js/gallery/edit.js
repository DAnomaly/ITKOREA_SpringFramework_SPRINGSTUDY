$(document).ready(function(){
	fn_f_submit();
})
function fn_f_submit(){
	// 버튼 클릭시 폼 작동
	$('#f_btn').click(function(){
		$('#f').submit();
	});
	// 폼 작동
	$('#f').submit(function(event){
		if($('#title').val() == ''){
			alert('제목은 필수입니다.');
			$('#title').focus();
			event.preventDefault();
			return false;
		}
		return true;
	});
}