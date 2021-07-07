package com.koreait.mygallery.command.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.BoardController;
import com.koreait.mygallery.dao.BoardDAO;
import com.koreait.mygallery.dto.Board;
import com.koreait.mygallery.dto.Member;

/**
 * 선택한 Board의 내용을 수정합니다.
 * 
 * @see BoardController
 * @author 박세환
 */
@Component
public class UpdateBoardCommand implements BoardCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		HttpSession session = request.getSession();
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		Map<String, Object> resultMap = new HashMap<>();
		
		Board board = new Board();
		board.setBoardNo(Long.parseLong(request.getParameter("boardNo")));
		String content = request.getParameter("content").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		board.setContent(content);
		board.setId(((Member)session.getAttribute("loginMember")).getId());
		
		int result = dao.updateBoard(board);
		resultMap.put("result",result > 0);
		
		return resultMap;
	}
	
}
