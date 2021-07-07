package com.koreait.mygallery.command.gallery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.GalleryController;
import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.Page;
import com.koreait.mygallery.util.PagingUtils;

/**
 * 해당 페이지에 알맞는 Gallery를 가져옵니다.<br>
 * Paging처리하여 model에 저장합니다. 
 *  
 * @see GalleryController
 * @author 박세환
 */
@Component
public class SelectListGalleryCommand implements GalleryCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		// nowpage
		String strPage = request.getParameter("page");
		int nowpage = Integer.parseInt(strPage != null && !strPage.isEmpty() ? strPage : "1");
		// totalRecord
		String c = request.getParameter("c");
		String q = request.getParameter("q");
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("c", c != null && !c.isEmpty() ? c : null);
		searchMap.put("q", q != null && !q.isEmpty() ? q : "");
		int totalRecord = dao.countGallery(searchMap);
		// Class Page
		Page page = PagingUtils.getPage(nowpage, totalRecord);
		// List<Gallery>
		searchMap.put("beginRecord", page.getBeginRecord());
		searchMap.put("endRecord", page.getEndRecord());
		List<Gallery> list = dao.selectListGallery(searchMap);
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
