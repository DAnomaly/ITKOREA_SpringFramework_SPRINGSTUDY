package com.koreait.mygallery.command.gallery;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mygallery.controller.GalleryController;
import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

/**
 * 갤러리 등록 커맨드
 * 
 * @see GalleryController
 * @author 박세환
 */
@Component
public class WriteGalleryCommand implements GalleryCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		MultipartHttpServletRequest request = (MultipartHttpServletRequest)model.asMap().get("request");
		HttpSession session = request.getSession();
		String id = ((Member)session.getAttribute("loginMember")).getId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = SecurityUtils.getIp(request);
		String image = getFilename(request, "image");
		
		Gallery gallery = new Gallery();
		gallery.setId(id);
		gallery.setTitle(title);
		gallery.setContent(content);
		gallery.setIp(ip);
		gallery.setImage(image);
		
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		int result = dao.insertGallery(gallery);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		if(result > 0) {
			sb.append("alert('정상적으로 등록되었습니다.');");
			sb.append("location.href='/mygallery/index.do?v=gallery';");
		} else {
			sb.append("alert('오류가 발생했습니다.');");
			sb.append("history.back();");
		}
		sb.append("</script>");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("response", sb.toString());
		return resultMap;
	}

	/**
	 * file을 생성하면서 새롭게 filename을 정하고 반환합니다.
	 * 
	 * @param request 
	 * @param param 파라미터명
	 * @return filename 파일명
	 */
	private String getFilename(MultipartHttpServletRequest request ,String param) {
		MultipartFile multipartFile = request.getFile(param);
		String path = "resources/archive"; // 파일 경로
		String realPath = request.getServletContext().getRealPath(path);
		File archive = new File(realPath);
		if(!archive.exists()) {
			logger.warn("파일 경로를 찾지 못하여 새로 생성합니다.");
			archive.mkdirs();
		}
		// 새 첨부를 올린다.
		String originalFilename = multipartFile.getOriginalFilename();
		int lastIndex = originalFilename.lastIndexOf(".");
		String extension = originalFilename.substring(lastIndex + 1);
		String filename = originalFilename.substring(0, lastIndex);
		String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
		File file = new File(archive, uploadFilename);
		try {
			multipartFile.transferTo(file);
		} catch (Exception e) {
			// 심각한 오류
			logger.warn("파일 생성중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
		return uploadFilename;
	}
	
}
