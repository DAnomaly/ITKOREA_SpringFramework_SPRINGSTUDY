$(document).ready(function(){
	fn_insert_btn();
	fn_b_init_btn();
})
function fn_insert_btn() {
	$('#insert_btn').click(function(){	
		if($('#insert_content').val() == '')
			return;
		$('#insert_f').submit();
	})
}
function fn_b_init_btn() {
	$('#b_init_btn').click(function(){
		location.href="list.do";
	})
}
function insert_comment(f) {
	if($(f.content).val() == '')
		return;
	$(f).submit();
}
function show_com(id) {
	$(id).toggle();
}
function openEditPage(no) {
    var url = "editPage.do?no=" + no;
    var name = "editPage";
    var option = "width = 500, height = 150, top = 100, left = 200, location = no"
    var newWindow = window.open(url, name, option);
}