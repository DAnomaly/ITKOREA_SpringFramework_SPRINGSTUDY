package com.koreait.mygallery.command.gallery;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mygallery.dao.GalleryDAO;
import com.koreait.mygallery.dto.Gallery;
import com.koreait.mygallery.util.SecurityUtils;

@Component
public class UpdateGalleryCommand implements GalleryCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		MultipartHttpServletRequest request = (MultipartHttpServletRequest)model.asMap().get("request");
		long galleryNo = Long.parseLong(request.getParameter("galleryNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = SecurityUtils.getIp(request);
		String image = changeImage(request, "image1", "image2");
		
		Gallery gallery = new Gallery();
		gallery.setGalleryNo(galleryNo);
		gallery.setTitle(title);
		gallery.setContent(content);
		gallery.setIp(ip);
		gallery.setImage(image);
		
		GalleryDAO dao = sqlSession.getMapper(GalleryDAO.class);
		int result = dao.updateGallery(gallery); 
		
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		if(result > 0) {
			sb.append("alert('정상적으로 수정되었습니다.');");
			sb.append("location.href='selectOne.do?no=");
			sb.append(gallery.getGalleryNo());
			sb.append("';");
		} else {
			sb.append("alert('수정 도중 오류가 발생했습니다.');");
			sb.append("history.back();");
		}
		sb.append("</script>");
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("response", sb.toString());
		return null;
	}
	
	/**
	 * 전달 받은 파일이 존재하는지 확인한 뒤,<br>
	 * 파일이 존재하면 기존 파일을 삭제하고,<br>
	 * 새로운 파일을 저장한 뒤 파일 이름을 반환합니다.
	 * 
	 * @param request 
	 * @param prevFilename 이전 파일명
	 * @param newFilename 새로운 파일명
	 * @return filename 파일명
	 */
	private String changeImage(MultipartHttpServletRequest request ,String prevFilename, String newFilename) {
		MultipartFile multipartFile = request.getFile(newFilename);
		if(multipartFile == null || multipartFile.isEmpty())
			return null;
		String path = "resources/archive"; // 파일 경로
		String realPath = request.getServletContext().getRealPath(path);
		File archive = new File(realPath);
		if(!archive.exists()) {
			logger.warn("파일 경로를 찾지 못하여 새로 생성합니다.");
			archive.mkdirs();
		}
		// 기존 첨부를 삭제한다.
		File prevFile = new File(archive, prevFilename);
		if(prevFile.exists())
			if(prevFile.delete())
				logger.info(prevFilename + "을 삭제했습니다.");
			else
				logger.info(prevFilename + "을 삭제하는데에 실패했습니다.");
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
