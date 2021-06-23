package com.koreait.file.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.command.DeleteBoardCommand;
import com.koreait.file.command.DownloadBoardCommand;
import com.koreait.file.command.InsertBoardCommand;
import com.koreait.file.command.SelectListBoardCommand;
import com.koreait.file.command.SelectOneBoardCommand;
import com.koreait.file.command.UpdateBoardCommand;

@Controller
public class FileController {

	// field
	private SqlSession sqlSession;
	private SelectListBoardCommand selectListBoardCommand;
	private SelectOneBoardCommand selectOneBoardCommand;
	private InsertBoardCommand insertBoardCommand;
	private UpdateBoardCommand updateBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;
	private DownloadBoardCommand downloadBoardCommand;
	
	@Autowired
	public FileController(
			SqlSession sqlSession,
			SelectListBoardCommand selectListBoardCommand,
			SelectOneBoardCommand selectOneBoardCommand,
			InsertBoardCommand insertBoardCommand,
			UpdateBoardCommand updateBoardCommand,
			DeleteBoardCommand deleteBoardCommand,
			DownloadBoardCommand downloadBoardCommand) {
		this.sqlSession = sqlSession;
		this.selectListBoardCommand = selectListBoardCommand;
		this.selectOneBoardCommand =  selectOneBoardCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.updateBoardCommand = updateBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
		this.downloadBoardCommand = downloadBoardCommand;
	}
	
	
	@RequestMapping({"/","index.do"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("selectListBoard.do")
	public String selectListBoard(
			Model model) {
		selectListBoardCommand.execute(sqlSession, model);
		return "board/listBoard";
	}
	
	@RequestMapping("insertBoard.do")
	public String insertBoard() {
		return "board/insertBoard";
	}
	
	@RequestMapping("insert.do")
	public void insert(
			Model model,
			MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response) {
		model.addAttribute("multipartRequest", multipartRequest);
		model.addAttribute("response", response);
		insertBoardCommand.execute(sqlSession, model);
	}
	
	@RequestMapping("download.do")
	public void download(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("request",request);
		model.addAttribute("response",response);
		downloadBoardCommand.execute(sqlSession, model);
	}
	
	@RequestMapping("selectOneBoard.do")
	public String selectOneBoard(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		selectOneBoardCommand.execute(sqlSession, model);
		return "board/viewBoard";
	}
}
