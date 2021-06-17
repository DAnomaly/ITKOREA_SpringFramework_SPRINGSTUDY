package com.koreait.board02.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.board02.dao.BoardDAO;
import com.koreait.board02.dto.Board;

@Component
public class SelectListBoardCommand implements BoardCommand {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public boolean execute(Model model) {

		List<Board> list = boardDAO.selectListBoard();
		model.addAttribute("list", list);

		return true;
	}

}
