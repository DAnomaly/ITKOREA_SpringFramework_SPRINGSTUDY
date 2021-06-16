package com.koreait.board01.command;

import org.springframework.ui.Model;

import com.koreait.board01.dao.BoardDAO;
import com.koreait.board01.dto.Board;

public class SelectBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		long no = (long)model.asMap().get("no");
		
		Board board = BoardDAO.getInstance().selectOneBoard(no);
		
		model.addAttribute("board",board);
	}
}
