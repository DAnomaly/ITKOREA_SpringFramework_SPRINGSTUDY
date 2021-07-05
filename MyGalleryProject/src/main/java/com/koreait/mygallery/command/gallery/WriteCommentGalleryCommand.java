package com.koreait.mygallery.command.gallery;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.GalleryCom;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

@Component
public class WriteCommentGalleryCommand implements GalleryCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		long galleryNo = Long.parseLong(request.getParameter("galleryNo"));
		String id = ((Member)request.getSession().getAttribute("loginMember")).getId();
		String content = request.getParameter("content");
		String ip = SecurityUtils.getIp(request);
		
		GalleryCom galleryCom = new GalleryCom();
		galleryCom.setGalleryNo(galleryNo);
		galleryCom.setId(id);
		galleryCom.setContent(content);
		galleryCom.setIp(ip);
		
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		dao.insertGalleryComment(galleryCom);

		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("response", "redirect:viewPage.do?no=" + galleryNo);
		return resultMap;
	}
}
