package com.koreait.board03.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.board03.dao.BoardDAO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model, SqlSession sqlSession) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("req");
		// TYPE1
		/*
		Board board = new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.insertBoard(board);
		*/
		// TYPE2
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.insertBoard2(writer, title, content);
	}
}
