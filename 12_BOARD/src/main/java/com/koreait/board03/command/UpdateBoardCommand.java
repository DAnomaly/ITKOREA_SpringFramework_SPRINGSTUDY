package com.koreait.board03.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.board03.dao.BoardDAO;
import com.koreait.board03.dto.Board;

public class UpdateBoardCommand implements BoardCommand{
	
	@Override
	public void execute(Model model, SqlSession sqlSession) {
		Board board = (Board)model.asMap().get("board");
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.updateBoard(board);
	}
	
}
