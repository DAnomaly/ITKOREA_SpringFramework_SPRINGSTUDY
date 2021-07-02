package com.koreait.mygallery.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mygallery.command.gallery.WriteGalleryCommand;

@Controller
@RequestMapping("gallery")
public class GalleryController {

	SqlSession sqlSession;
	WriteGalleryCommand writeGalleryCommand;
	
	@Autowired
	public GalleryController(SqlSession sqlSession, WriteGalleryCommand writeGalleryCommand) {
		this.sqlSession = sqlSession;
		this.writeGalleryCommand = writeGalleryCommand;
	}

	/**
	 * 갤러리 작성 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value="writePage.do")
	public String writePage() {
		return "gallery/write";
	}
	
	/**
	 * 갤러리 작성
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="write.do",
					produces="text/html; charset=UTF-8")
	public String write(Model model,
			MultipartHttpServletRequest request) {
		model.addAttribute("request", request);
		return (String)writeGalleryCommand.execute(sqlSession, model).get("response");
	}
	
}
