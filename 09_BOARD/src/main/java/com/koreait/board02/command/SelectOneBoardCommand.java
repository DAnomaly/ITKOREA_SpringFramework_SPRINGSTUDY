package com.koreait.board02.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.board02.dao.BoardDAO;
import com.koreait.board02.dto.Board;

@Component
public class SelectOneBoardCommand implements BoardCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public boolean execute(Model model) {
		
		long no = (Long)model.asMap().get("no");
		Board board = boardDAO.selectOneBoard(no);
		if(board == null) {
			return false;
		} else {
			model.addAttribute(board);
			return true;
		}
	}

}
