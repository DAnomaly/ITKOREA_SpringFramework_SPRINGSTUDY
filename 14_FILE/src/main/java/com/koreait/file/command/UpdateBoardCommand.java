package com.koreait.file.command;

import java.io.File;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.dao.BoardDAO;

public class UpdateBoardCommand implements BoardCommand {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UpdateBoardCommand.class);
	
	private MultipartHttpServletRequest request;
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {

		request = (MultipartHttpServletRequest)model.asMap().get("request");
		
		long no = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String filename = "";
		String filename1 = request.getParameter("filename1");
		MultipartFile filename2 = request.getFile("filename2");
		
		// 기존 첨부와 새로운 첨부가 모두 있으면 -> 기존 첨부 지운다 -> 새로운 첨부를 받는다 -> DB 수정
		if(filename2 != null && !filename2.isEmpty()) {
			filename = updateFile(filename2, filename1);
		} else {
			filename = filename1;
		}
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		int result = dao.updateBoard(title, content, filename, no);
		if(result > 0) {
			LOGGER.info("NO" + no +": 게시글이 정상적으로 수정되었습니다.");
		} else {
			LOGGER.warn("NO" + no +": 게시글 수정 중 오류가 발생했습니다.");
		}
		
	}

	/**
	 * 오래된 파일을 삭제하고,<br>
	 * 새로 저장할 파일을 생성합니다.
	 * 
	 * @param newFilename 새로저장할 파일
	 * @param oldFilename 오래된 파일
	 * @return 새롭게 저장된 파일명
	 */
	private String updateFile(MultipartFile newFilename, String oldFilename) {
		String realPath = request.getServletContext().getRealPath("resources/archive");
		File archive = new File(realPath);
		if(!archive.exists()) {
			LOGGER.warn("파일 경로를 찾지 못하여 새로 생성합니다.");
			archive.mkdirs();
		}
		File oldFile = new File(archive, oldFilename); // 현재 서버에 저장된 파일
		// 기존 첨부를 지운다
		if(oldFile.exists()) {
			oldFile.delete();
		}
		// 새 첨부를 올린다.
		String originalFilename = newFilename.getOriginalFilename();
		int lastIndex = originalFilename.lastIndexOf(".");
		String extension = originalFilename.substring(lastIndex + 1);
		String filename = originalFilename.substring(0, lastIndex);
		String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
		File newFile = new File(archive, uploadFilename);
		try {
			newFilename.transferTo(newFile);
		} catch (Exception e) {
			// 심각한 오류
			LOGGER.warn("파일 생성중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
		return uploadFilename;
	}
	
	
}
