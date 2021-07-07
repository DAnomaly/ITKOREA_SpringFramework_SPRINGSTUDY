package com.koreait.mygallery.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.BoardController;
import com.koreait.mygallery.dao.BoardDAO;
import com.koreait.mygallery.dto.Board;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

/**
 * Board Table에 댓글을 추가합니다.
 * 
 * @see BoardController
 * @author 박세환
 */
@Component
public class InsertCommentBoardCommand implements BoardCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		Board board = new Board();
		board.setId(((Member)request.getSession().getAttribute("loginMember")).getId());
		board.setContent(request.getParameter("content"));
		board.setIp(SecurityUtils.getIp(request));
		board.setGroupno(Integer.parseInt(request.getParameter("groupno")));
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.insertCommentBoard(board);
		return null;
	}
	
}
