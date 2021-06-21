package com.koreait.board03.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.board03.dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model, SqlSession sqlSession) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("req");
		long no = Long.parseLong(request.getParameter("no"));
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.deleteBoard(no);
	}

}
