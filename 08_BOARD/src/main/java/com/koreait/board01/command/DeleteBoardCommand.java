package com.koreait.board01.command;

import org.springframework.ui.Model;

import com.koreait.board01.dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model) {

		long no = (long)model.asMap().get("no");
		
		BoardDAO.getInstance().deleteBoard(no);
		
	}

}
