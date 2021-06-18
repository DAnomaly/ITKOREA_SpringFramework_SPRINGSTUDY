$(document).ready(function(){
	$('#edit_btn').click(edit_f);
	$('#del_btn').click(del_btn);
	$('#back_btn').click(back_btn);
})

function edit_f(){
	$('#f').submit();
}
function del_btn(){
	if(confirm('정말로 삭제하시겠습니까?'))
		location.href='delete.do?no=' + $('#no').val();
}
function back_btn(){
	location.href='list.do';
}
