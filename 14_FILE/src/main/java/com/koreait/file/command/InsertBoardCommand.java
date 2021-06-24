package com.koreait.file.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.dao.BoardDAO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)model.asMap().get("multipartRequest");
		HttpServletResponse response = (HttpServletResponse)model.asMap().get("response");
		int result = 0;
		
		String writer = multipartRequest.getParameter("writer");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		/*
		 * <input type="file" name="file"/> : 단일 파일 첨부
		 * MultipartFile file = multipartRequest.getFile("file");
		 */
		
		/*
		 * <input type="file" name="files" multiple/> : 다중 파일 첨부
		 * List<MultipartFile> files = multipartRequest.getFiles("files");
		 */
		List<MultipartFile> files = multipartRequest.getFiles("files");
		for(MultipartFile file : files) {
			if (file != null && !file.isEmpty()) {
				// 첨부된 파일명 확인
				// 올릴 때 파일명
				String originalFilename = file.getOriginalFilename();
				
				// 서버에 저장할 파일명
				// 파일명의 중복 방지 대책이 필요
				// 파일명_올린시간.확장자
				String extention = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // 확장자
				String filename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
				String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extention;
				
				// 첨부파일을 저장할 서버의 위치
				String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
				
				// archive 디렉터리 생성
				File archive = new File(realPath);
				if(!archive.exists())
					archive.mkdirs();
				
				// 서버에 첨부파일 저장
				File attach = new File(archive, uploadFilename);
				try {
					file.transferTo(attach);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				// DB에 데이터 저장
				result = dao.insertBoard(writer, title, content, uploadFilename);
			} else {
				// ?
				result = dao.insertBoard(writer, title, content, "");
			}
		} // for
		
		// response
		response.setContentType("text/html; charset=UTF-8"); 
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println("<script>");
				out.println("alert('정상적으로 게시글이 등록되었습니다.');");
				out.println("location.href='selectListBoard.do';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시글 등록 중 오류가 발생했습니다.');");
				out.println("location.href='selectListBoard.do';");
				out.println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
