package com.koreait.mygallery.command.gallery;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.GalleryController;
import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.GalleryCom;

/**
 * 갤러리 댓글 수정을 위한 댓글의 정보를 불러옵니다.
 * 
 * @see GalleryController
 * @author 박세환
 */
@Component
public class SelectOneCommentGalleryCommand implements GalleryCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		
		long no = Long.parseLong(request.getParameter("no"));
		GalleryCom galleryCom = dao.selectOneGalleryComment(no);
		
		model.addAttribute("galleryCom", galleryCom);
		return null;
	}

}
