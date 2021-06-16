package com.koreait.board01.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.board01.dao.BoardDAO;
import com.koreait.board01.dto.Board;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model) {

		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request"); 
		
		Board board = new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		BoardDAO.getInstance().insertBoard(board);
		
	}

}
