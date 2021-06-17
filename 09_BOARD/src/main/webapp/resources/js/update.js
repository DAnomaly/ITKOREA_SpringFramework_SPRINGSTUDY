$(document).ready(function(){
	$('#back_btn').click(function(){
		location.href='selectBoardByNo.do?no=' + $('#no').val();
	})

})