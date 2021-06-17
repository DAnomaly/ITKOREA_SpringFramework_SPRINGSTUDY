$(document).ready(function(){
	$('#back_btn').click(function(){
		location.href='selectBoardList.do';
	})
	$('#edit_btn').click(function(){
		location.href='updateBoardPage.do?no=' + $('#no').val();
	})
	$('#del_btn').click(function(){
		if(confirm('정말로 삭제하시겠습니까?')){
			location.href='deleteBoard.do?no=' + $('#no').val();
		}
	})
})