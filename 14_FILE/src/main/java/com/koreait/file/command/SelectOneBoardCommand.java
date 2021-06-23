package com.koreait.file.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.file.dao.BoardDAO;
import com.koreait.file.dto.Board;

public class SelectOneBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		long no = Long.parseLong(request.getParameter("no"));
		
		Board board = dao.selectOneBoard(no);
		
		model.addAttribute("board",board);
	}
	
}
