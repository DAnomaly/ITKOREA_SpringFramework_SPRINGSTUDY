package com.koreait.mygallery.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mygallery.command.gallery.DeleteCommentGalleryCommand;
import com.koreait.mygallery.command.gallery.DeleteGalleryCommand;
import com.koreait.mygallery.command.gallery.SelectListGalleryCommand;
import com.koreait.mygallery.command.gallery.SelectOneCommentGalleryCommand;
import com.koreait.mygallery.command.gallery.SelectOneGalleryCommand;
import com.koreait.mygallery.command.gallery.UpdateCommentGalleryCommand;
import com.koreait.mygallery.command.gallery.UpdateGalleryCommand;
import com.koreait.mygallery.command.gallery.WriteCommentGalleryCommand;
import com.koreait.mygallery.command.gallery.WriteGalleryCommand;

@Controller
@RequestMapping("gallery")
public class GalleryController {

	private SqlSession sqlSession;
	private SelectListGalleryCommand selectListGalleryCommand;
	private SelectOneGalleryCommand selectOneGalleryCommand;
	private SelectOneCommentGalleryCommand selectOneCommentGalleryCommand;
	private WriteGalleryCommand writeGalleryCommand;
	private UpdateGalleryCommand updateGalleryCommand;
	private UpdateCommentGalleryCommand updateCommentGalleryCommand;
	private DeleteGalleryCommand deleteGalleryCommand;
	private DeleteCommentGalleryCommand deleteCommentGalleryCommand;
	private WriteCommentGalleryCommand writeCommentGalleryCommand;
	
	@Autowired
	public GalleryController(SqlSession sqlSession, 
			SelectListGalleryCommand selectListGalleryCommand,
			SelectOneGalleryCommand selectOneGalleryCommand, 
			SelectOneCommentGalleryCommand selectOneCommentGalleryCommand,
			WriteGalleryCommand writeGalleryCommand,
			UpdateGalleryCommand updateGalleryCommand, 
			UpdateCommentGalleryCommand updateCommentGalleryCommand,
			DeleteGalleryCommand deleteGalleryCommand,
			DeleteCommentGalleryCommand deleteCommentGalleryCommand,
			WriteCommentGalleryCommand writeCommentGalleryCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectListGalleryCommand = selectListGalleryCommand;
		this.selectOneGalleryCommand = selectOneGalleryCommand;
		this.selectOneCommentGalleryCommand = selectOneCommentGalleryCommand;
		this.writeGalleryCommand = writeGalleryCommand;
		this.updateGalleryCommand = updateGalleryCommand;
		this.updateCommentGalleryCommand = updateCommentGalleryCommand;
		this.deleteGalleryCommand = deleteGalleryCommand;
		this.deleteCommentGalleryCommand = deleteCommentGalleryCommand;
		this.writeCommentGalleryCommand = writeCommentGalleryCommand;
	}

	/**
	 * ????????? ????????? ?????????
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="list.do")
	public String list(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		selectListGalleryCommand.execute(sqlSession, model);
		return "gallery/list";
	}
	
	/**
	 * ????????? ?????? ?????????
	 * 
	 * @return
	 */
	@RequestMapping(value="writePage.do")
	public String writePage() {
		return "gallery/write";
	}
	
	/**
	 * ????????? ?????? ?????????
	 * 
	 * @see SelectOneGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="editPage.do")
	public String editPage(Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		selectOneGalleryCommand.execute(sqlSession, model);
		return "gallery/edit";
	}
	
	/**
	 * ????????? ?????? ?????????
	 * 
	 * @see SelectOneGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="viewPage.do")
	public String viewPage(Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		selectOneGalleryCommand.execute(sqlSession, model);
		return "gallery/view";
	}
	
	/**
	 * ????????? ??????
	 * 
	 * @see WriteGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="insert.do",
					produces="text/html; charset=UTF-8")
	public String write(Model model,
			MultipartHttpServletRequest request) {
		model.addAttribute("request", request);
		return (String)writeGalleryCommand.execute(sqlSession, model).get("response");
	}
	
	/**
	 * ????????? ?????? ??????
	 * 
	 * @see WriteCommentGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="writeCom.do",
					method=RequestMethod.POST)
	public String writeCom(Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return (String)writeCommentGalleryCommand.execute(sqlSession, model).get("response");
	}
	
	/**
	 * ????????? ??????
	 * 
	 * @see DeleteGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="del.do",
					method=RequestMethod.GET,
					produces="text/html; charset=UTF-8")
	public String del(Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return (String)deleteGalleryCommand.execute(sqlSession, model).get("response");
	}

	/**
	 * ????????? ?????? ?????? ?????????
	 * 
	 * @see SelectOneCommentGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="editComPage.do")
	public String editComPage(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		selectOneCommentGalleryCommand.execute(sqlSession, model);
		return "gallery/editCom";
	}
	
	/**
	 * ????????? ?????? ??????
	 * 
	 * @see UpdateGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="editCom.do",
					method=RequestMethod.POST,
					produces="application/json; charset=UTF-8")
	public Map<String, Object> editCom(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return updateCommentGalleryCommand.execute(sqlSession, model);
	}
	
	/**
	 * ????????? ?????? ??????
	 * 
	 * @see DeleteCommentGalleryCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="delCom.do",
					method=RequestMethod.GET,
					produces="text/html; charset=UTF-8")
	public String delCom(Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return (String)deleteCommentGalleryCommand.execute(sqlSession, model).get("response");
	}
	
	/**
	 * ????????? ??????
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="update.do",
					method=RequestMethod.POST,
					produces="text/html; charset=UTF-8")
	public String update(Model model,
			MultipartHttpServletRequest request) {
		model.addAttribute("request", request);
		return (String)updateGalleryCommand.execute(sqlSession, model).get("response");
	}
	
	
}
