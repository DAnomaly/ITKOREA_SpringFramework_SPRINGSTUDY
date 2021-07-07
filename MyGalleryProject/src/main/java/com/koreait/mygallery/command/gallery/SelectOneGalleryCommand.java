package com.koreait.mygallery.command.gallery;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.GalleryController;
import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.GalleryCom;
import com.koreait.mygallery.dto.Member;

/**
 * viewPage.do 에 보여질<br>
 * Gallery와 GalleryCom을 가져옵니다.<br>
 * <br>
 * 작성자 아닐경우 Hit를 증가시킵니다.
 *  
 * 
 * @see GalleryController
 * @author ITSC
 */
@Component
public class SelectOneGalleryCommand implements GalleryCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		long no = Long.parseLong(request.getParameter("no"));
		
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		// 갤러리 불러오기
		Gallery gallery = dao.selectOneGallery(no);
		model.addAttribute("gallery", gallery);
		// 조회수 증가
		if((loginMember != null && loginMember.getId().equals(gallery.getId())) == false)
			dao.updateGalleryHit(no);
		// 댓글 불러오기
		List<GalleryCom> comments = dao.selectGalleryComment(no);
		model.addAttribute("comments", comments);
		
		return null;
	}

}
