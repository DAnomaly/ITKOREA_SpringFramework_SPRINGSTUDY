package com.koreait.mygallery.command.gallery;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.GalleryController;
import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.GalleryCom;
import com.koreait.mygallery.dto.Member;

/**
 * 요청한 Gallery의 댓글을 수정합니다.
 * 
 * @see GalleryController
 * @author 박세환
 */
@Component
public class UpdateCommentGalleryCommand implements GalleryCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		HttpSession session = request.getSession();
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		Map<String, Object> resultMap = new HashMap<>();
		
		GalleryCom galleryCom = new GalleryCom();
		galleryCom.setGalleryComNo(Long.parseLong(request.getParameter("galleryComNo")));
		String content = request.getParameter("content").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		galleryCom.setContent(content);
		galleryCom.setId(((Member)session.getAttribute("loginMember")).getId());
		
		int result = dao.updateCommentGallery(galleryCom);
		resultMap.put("result",result > 0);
		
		return resultMap;
	}

}
