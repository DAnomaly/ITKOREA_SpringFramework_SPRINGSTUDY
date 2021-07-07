package com.koreait.mygallery.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mygallery.command.board.DeleteBoardCommand;
import com.koreait.mygallery.command.board.InsertBoardCommand;
import com.koreait.mygallery.command.board.InsertCommentBoardCommand;
import com.koreait.mygallery.command.board.SelectListBoardCommand;

@Controller
@RequestMapping("board")
public class BoardController {

	// field
	private SqlSession sqlSession;
	private SelectListBoardCommand selectListBoardCommand;
	private InsertBoardCommand insertBoardCommand;
	private InsertCommentBoardCommand insertCommentBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;
	
	@Autowired
	public BoardController(
			SqlSession sqlSession, 
			SelectListBoardCommand selectListBoardCommand,
			InsertBoardCommand insertBoardCommand, 
			InsertCommentBoardCommand insertCommentBoardCommand,
			DeleteBoardCommand deleteBoardCommand) {
		this.sqlSession = sqlSession;
		this.selectListBoardCommand = selectListBoardCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.insertCommentBoardCommand = insertCommentBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
	}

	/**
	 * 개시글 목록 불러오기
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
	 * 개시글 작성
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
	 * 개시글/답글 삭제
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
