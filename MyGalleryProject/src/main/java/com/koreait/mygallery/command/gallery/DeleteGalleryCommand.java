package com.koreait.mygallery.command.gallery;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.GalleryController;
import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.Member;

/**
 * 갤러리를 갤러리에 포함된 댓글까지 함께 삭제합니다.
 *
 * @see GalleryController
 * @author 박세환
 */
@Component
public class DeleteGalleryCommand implements GalleryCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {

		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		Map<String, Object> modelMap = model.asMap();
		HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
		long galleryComNo = Long.parseLong(request.getParameter("no"));
		Gallery gallery = dao.selectOneGallery(galleryComNo);
		
		// 계정 검사
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		if(loginMember == null || !gallery.getId().equals(loginMember.getId())) {
			sb.append("<script>");
			sb.append("alert('허용하지 않는 접근입니다.');");
			sb.append("history.back();");
			sb.append("</script>");
			resultMap.put("response", sb.toString());
			return resultMap;
		}
		
		// 갤러리 댓글 삭제
		dao.deleteGalleryCommentByGalleryNo(gallery.getGalleryNo());
		
		// 갤러리 삭제
		if(dao.deleteGallery(gallery.getGalleryNo()) != 0) {
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
		resultMap.put("response", sb.toString());
		logger.info("갤러리삭제: no=" + gallery.getGalleryNo() + ",title=" + gallery.getTitle());
		
		
		// 이미지 삭제
		String path = "resources/archive"; // 파일 경로
		String realPath = request.getServletContext().getRealPath(path);
		File image = new File(realPath, gallery.getImage());
		if(image.exists())
			if(image.delete())
				logger.info("이미지삭제: filename=" + gallery.getImage());
			else
				logger.info("이미지삭제실패: filename=" + gallery.getImage());
		return resultMap;
	}

}
