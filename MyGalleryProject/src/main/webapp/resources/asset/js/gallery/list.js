$(document).ready(function(){
	fn_btn();
})

function move(i){
	location.href='viewPage.do?no=' + i;
}
function fn_btn(){
	$('#g_search_btn').click(function(){
		$('#f').submit();
	})
	$('#g_init_btn').click(function(){
		location.href="list.do";
	})
}