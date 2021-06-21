package com.koreait.board03.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.board03.dao.BoardDAO;

public class SelectBoardListCommand implements BoardCommand{

	@Override
	public void execute(Model model, SqlSession sqlSession) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		model.addAttribute("list", dao.selectBoardList());
	}
	
}
