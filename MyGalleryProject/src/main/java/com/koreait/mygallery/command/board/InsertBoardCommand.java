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
 * Board Table에 개시글을 등록합니다.
 * 
 * @see BoardController
 * @author ITSC
 */
@Component
public class InsertBoardCommand implements BoardCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		Board board = new Board();
		board.setId(((Member)request.getSession().getAttribute("loginMember")).getId());
		String content = request.getParameter("content");
		content = content.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		board.setContent(content);
		board.setIp(SecurityUtils.getIp(request));
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.insertNewBoard(board);
		return null;
	}
	
}
