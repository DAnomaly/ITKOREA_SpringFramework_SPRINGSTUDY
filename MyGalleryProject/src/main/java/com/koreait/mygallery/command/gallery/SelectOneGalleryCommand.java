package com.koreait.mygallery.command.gallery;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.GalleryCom;

@Component
public class SelectOneGalleryCommand implements GalleryCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		long no = Long.parseLong(request.getParameter("no"));
		
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		Gallery gallery = dao.selectOneGallery(no);
		model.addAttribute("gallery", gallery);
		List<GalleryCom> comments = dao.selectGalleryComment(no);
		model.addAttribute("comments", comments);
		
		return null;
	}

}
