$(document).ready(function(){
	fn_f_submit();
})
function fn_f_submit(){
	$('#f_btn').click(function(){
		$('#f').submit();
	});
	$('#f').submit(function(event){
		if($('#com_content').val() == ''){
			alert('댓글을 작성해 주세요.');
			event.preventDefault();
			return false;
		}
		return true;
	});
}
function fn_del(no){
	if(confirm('정말로 삭제하시겠습니까?'))
		location.href='del.do?no=' + no;
}
function fn_com_del(no){
	if(confirm('정말로 삭제하시겠습니까?'))
		location.href="delCom.do?no=" + no;
}
function openEditPage(no) {
    var url = "editComPage.do?no=" + no;
    var name = "editComPage";
    var option = "width = 500, height = 150, top = 100, left = 200, location = no"
    var newWindow = window.open(url, name, option);
}