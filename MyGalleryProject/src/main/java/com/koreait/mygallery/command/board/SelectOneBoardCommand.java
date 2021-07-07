package com.koreait.mygallery.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.BoardController;
import com.koreait.mygallery.dao.BoardDAO;
import com.koreait.mygallery.dto.Board;

/**
 * 수정하고 싶은 Board의 정보를 가져옵니다.
 * 
 * @see BoardController
 * @author 박세환
 */
@Component
public class SelectOneBoardCommand implements BoardCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		
		long no = Long.parseLong(request.getParameter("no"));
		Board board = dao.selectOneBoard(no);
		
		model.addAttribute("board", board);
		return null;
	}

}
