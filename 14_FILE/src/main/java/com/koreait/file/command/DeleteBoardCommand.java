package com.koreait.file.command;

import java.io.File;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	private final static Logger LOGGER = LoggerFactory.getLogger(DeleteBoardCommand.class); 
	private MultipartHttpServletRequest request;
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {
		request = (MultipartHttpServletRequest)model.asMap().get("request");
		long no = Long.parseLong(request.getParameter("no"));
		String filename = request.getParameter("filename1");
		if(filename != null && !filename.isEmpty()) {
			deleteFile(filename);
		}
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		int result = dao.deleteBoard(no);
		if(result > 0) {
			LOGGER.info("NO" + no + " : 글을 정상적으로 삭제하였습니다.");
		} else {
			LOGGER.info("NO" + no + " : 글을 삭제하는 도중 오류가 발생했습니다.");
		}
		
	}
	
	private void deleteFile(String filename) {
		String realPath = request.getServletContext().getRealPath("resources/archive");
		File archive = new File(realPath);
		if(!archive.exists()) {
			LOGGER.info("파일 경로를 찾지 못하였습니다.");
			return;
		}
		File file = new File(archive, filename);
		if(file.exists() && file.delete()) {
			LOGGER.info("파일을 정상적으로 삭제하였습니다.");
		} else {
			LOGGER.info("파일 삭제 도중 오류가 발생하였습니다.");
		}
	}

}
