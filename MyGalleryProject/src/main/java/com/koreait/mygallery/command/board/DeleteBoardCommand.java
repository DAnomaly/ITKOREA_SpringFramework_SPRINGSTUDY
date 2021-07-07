package com.koreait.mygallery.command.board;

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
 * 개시글을 삭제 처리합니다.<br>
 * (보드 테이블의 STATUS를 -1로 변경합니다.)
 * 
 * @see BoardController
 * @author 박세환
 */
@Component
public class DeleteBoardCommand implements BoardCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		HttpSession session = request.getSession();
		
		Board board = new Board();
		board.setId(((Member)session.getAttribute("loginMember")).getId());
		board.setBoardNo(Long.parseLong(request.getParameter("no")));
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.deleteBoard(board);
		
		return null;
	}
	
}
