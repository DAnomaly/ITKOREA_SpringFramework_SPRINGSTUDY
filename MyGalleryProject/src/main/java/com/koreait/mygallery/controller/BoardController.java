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

import com.koreait.mygallery.command.board.DeleteBoardCommand;
import com.koreait.mygallery.command.board.InsertBoardCommand;
import com.koreait.mygallery.command.board.InsertCommentBoardCommand;
import com.koreait.mygallery.command.board.SelectListBoardCommand;
import com.koreait.mygallery.command.board.SelectOneBoardCommand;
import com.koreait.mygallery.command.board.UpdateBoardCommand;

@Controller
@RequestMapping("board")
public class BoardController {

	// field
	private SqlSession sqlSession;
	private SelectListBoardCommand selectListBoardCommand;
	private SelectOneBoardCommand selectOneBoardCommand;
	private InsertBoardCommand insertBoardCommand;
	private InsertCommentBoardCommand insertCommentBoardCommand;
	private UpdateBoardCommand updateBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;
	
	@Autowired
	public BoardController(
			SqlSession sqlSession, 
			SelectListBoardCommand selectListBoardCommand,
			SelectOneBoardCommand selectOneBoardCommand, 
			InsertBoardCommand insertBoardCommand,
			InsertCommentBoardCommand insertCommentBoardCommand,
			UpdateBoardCommand updateBoardCommand,
			DeleteBoardCommand deleteBoardCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectListBoardCommand = selectListBoardCommand;
		this.selectOneBoardCommand = selectOneBoardCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.insertCommentBoardCommand = insertCommentBoardCommand;
		this.updateBoardCommand = updateBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
	}
	
	/**
	 * 게시글 목록 불러오기
	 * 
	 * @see SelectListBoardCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="list.do")
	public String list(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		selectListBoardCommand.execute(sqlSession, model);
		return "board/list";
	}
	
	/**
	 * 게시글 수정 창
	 * 
	 * @see SelectOneBoardCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="editPage.do")
	public String editPage(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		selectOneBoardCommand.execute(sqlSession, model);
		return "board/edit";
	}
	
	
	/**
	 * 게시글 작성
	 * 
	 * @see InsertBoardCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="insert.do",
					method=RequestMethod.POST)
	public String insert(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		insertBoardCommand.execute(sqlSession, model);
		return "redirect:list.do";
	}
	
	/**
	 * 답글 작성
	 * 
	 * @see InsertCommentBoardCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="insertComment.do",
					method=RequestMethod.POST)
	public String insertComment(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		insertCommentBoardCommand.execute(sqlSession, model);
		return "redirect:list.do";
	}
	
	/**
	 * 게시글/답글 수정
	 * 
	 * @see UpdateBoardCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="edit.do",
					method=RequestMethod.POST,
					produces="application/json; charset=UTF-8")
	public Map<String, Object> edit(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		return updateBoardCommand.execute(sqlSession, model);
	}
	
	/**
	 * 게시글/답글 삭제
	 * 
	 * @see DeleteBoardCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="delete.do")
	public String delete(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		deleteBoardCommand.execute(sqlSession, model);
		return "redirect:list.do";
	}
	
}
