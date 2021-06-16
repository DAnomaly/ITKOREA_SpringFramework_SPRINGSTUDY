$(document).ready(function(){
	$('#back_btn').click(function(){
		location.href='selectBoardList.do';
	})
	$('#edit_btn').click(function(){
		location.href='updateBoardPage.do?no=' + $('#no').val();
	})
})