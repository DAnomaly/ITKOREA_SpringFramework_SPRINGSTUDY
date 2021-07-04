package com.koreait.mygallery.command.gallery;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.Member;

@Component
public class DeleteGalleryCommand implements GalleryCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> resultMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		Gallery gallery = (Gallery)modelMap.get("gallery");
		
		// 계정 검사
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		if(loginMember == null || gallery.getId() != loginMember.getId()) {
			sb.append("<script>");
			sb.append("alert('허용하지 않는 접근입니다.');");
			sb.append("history.back();");
			sb.append("</script>");
			resultMap.put("response", sb.toString());
			return resultMap;
		}
		
		// 갤러리 댓글 삭제
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		dao.deleteGalleryCommentByGalleryNo(gallery.getGalleryNo());
		if(dao.deleteGallery(gallery.getGalleryNo()) == 0) {
			sb.append("<script>");
			sb.append("alert('정상적으로 삭제되었습니다.');");
			sb.append("location.href='/mygallery/';");
			sb.append("</script>");
		} else {
			sb.append("<script>");
			sb.append("alert('삭제 도중 오류가 발생했습니다.');");
			sb.append("history.back();");
			sb.append("</script>");
		}
		
		return resultMap;
	}

}
