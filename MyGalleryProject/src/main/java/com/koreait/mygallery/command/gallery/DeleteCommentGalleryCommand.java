package com.koreait.mygallery.command.gallery;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.GalleryCom;

@Component
public class DeleteCommentGalleryCommand implements GalleryCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {

		Map<String, Object> resultMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		long galleryComNo = Long.parseLong(request.getParameter("no"));
		
		// 계정 검사
		GalleryCom galleryCom = dao.selectOneGalleryComment(galleryComNo);
		if(galleryCom == null || !galleryCom.getId().equals(galleryCom.getId())) {
			sb.append("<script>");
			sb.append("alert('허용하지 않는 접근입니다.');");
			sb.append("history.back();");
			sb.append("</script>");
			resultMap.put("response", sb.toString());
			return resultMap;
		}
		
		// 댓글 삭제
		// 갤러리 삭제
		if(dao.deleteGalleryCommentByNo(galleryCom.getGalleryComNo()) != 0) {
			sb.append("<script>");
			sb.append("alert('정상적으로 삭제되었습니다.');");
			sb.append("location.href='/mygallery/gallery/viewPage.do?no=" + galleryCom.getGalleryNo() + "';");
			sb.append("</script>");
		} else {
			sb.append("<script>");
			sb.append("alert('삭제 도중 오류가 발생했습니다.');");
			sb.append("history.back();");
			sb.append("</script>");
		}
		resultMap.put("response", sb.toString());
		logger.info("갤러리댓글삭제: " + galleryCom.toString() );
		
		return resultMap;
	}
	
}
