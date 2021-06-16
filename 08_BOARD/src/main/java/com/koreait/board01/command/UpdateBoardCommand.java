package com.koreait.board01.command;

import org.springframework.ui.Model;

import com.koreait.board01.dao.BoardDAO;
import com.koreait.board01.dto.Board;

public class UpdateBoardCommand implements BoardCommand{

	@Override
	public void execute(Model model) {
		
		Board board = (Board)model.asMap().get("board");
		
		BoardDAO.getInstance().updateBoard(board);
		
	}
	
}
