package com.koreait.mygallery.command.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.BoardController;
import com.koreait.mygallery.dao.BoardDAO;
import com.koreait.mygallery.dto.Board;
import com.koreait.mygallery.dto.Page;
import com.koreait.mygallery.util.PagingUtils;

/**
 * Board Table에서 데이터를 가져옵니다.<br>
 * Paging처리하여 model에 저장합니다.
 * 
 * @see BoardController
 * @author 박세환
 */
@Component
public class SelectListBoardCommand implements BoardCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		// nowpage
		String strPage = request.getParameter("page");
		int nowpage = Integer.parseInt(strPage != null && !strPage.isEmpty() ? strPage : "1");
		// totalRecord
		String c = request.getParameter("c");
		String q = request.getParameter("q");
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("c", c != null && !c.isEmpty() ? c : null);
		searchMap.put("q", q != null && !q.isEmpty() ? q : "");
		int totalRecord = dao.countBoard(searchMap);
		// Class Page
		Page page = PagingUtils.getPage(nowpage, totalRecord);
		// List<Gallery>
		searchMap.put("beginRecord", page.getBeginRecord());
		searchMap.put("endRecord", page.getEndRecord());
		List<Board> list = dao.selectListBoard(searchMap);
		// paging
		String path;
		if(searchMap.get("c") == null) {
			path = "list.do";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("list.do?c=").append(c).append("&q=").append(q);
			path = sb.toString();
		}
		String paging = PagingUtils.getPaging(path, page);
		// model
		model.addAttribute("list",list);
		model.addAttribute("paging",paging);
		return null;
	}

}
