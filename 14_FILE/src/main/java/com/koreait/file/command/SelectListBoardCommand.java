package com.koreait.file.command;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.file.dao.BoardDAO;
import com.koreait.file.dto.Board;

public class SelectListBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		List<Board> list = dao.selectListBoard();
		model.addAttribute("list", list);
	}

}
