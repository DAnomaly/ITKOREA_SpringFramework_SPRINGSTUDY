package com.koreait.board02.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.board02.dao.BoardDAO;
import com.koreait.board02.dto.Board;

@Component
public class InsertBoardCommand implements BoardCommand {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public boolean execute(Model model) {

		Board board = (Board) model.asMap().get("board");
		int result = boardDAO.insertBoard(board);
		if (result > 0)
			return true;
		else
			return false;
	}

}
