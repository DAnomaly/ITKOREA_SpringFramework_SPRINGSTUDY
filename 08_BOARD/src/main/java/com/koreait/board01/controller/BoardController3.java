package com.koreait.board01.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.board01.command.BoardCommand;
import com.koreait.board01.command.DeleteBoardCommand;
import com.koreait.board01.command.InsertBoardCommand;
import com.koreait.board01.command.ListBoardCommand;
import com.koreait.board01.command.SelectBoardCommand;
import com.koreait.board01.command.UpdateBoardCommand;
import com.koreait.board01.config.BeanConfiguration;
import com.koreait.board01.dto.Board;

@Controller
public class BoardController3 {

	// field
	private static final Logger logger = LoggerFactory.getLogger(BoardController3.class);
	
	// BeanConfiguration에 정의된 bean 생성
	AbstractApplicationContext ctx;
	BoardCommand command;
	
	public BoardController3() {
		ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	}
	
	
	//method
	@GetMapping(value="/") // @RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		logger.info("index() 호출");
		return "index";
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		model.addAttribute("page",page);
		
		command = ctx.getBean("listBoardCommand", ListBoardCommand.class);
		command.execute(model);
		
		return "board/list";
	}
	
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage(Model model) {
		return "board/insert";
	}
	
	@RequestMapping(value="insertBoard.do")
	public String insertBoard(
			HttpServletRequest request,
			Model model) {
		// 모든 Command에는 model만 전달할 수 있다.
		// 따라서, Command에 전달할 데이터들은 모두 model에 저장한다.
		model.addAttribute("request",request);
		
		command = ctx.getBean("insertBoardCommand", InsertBoardCommand.class);
		command.execute(model);
		
		return "redirect:selectBoardList.do"; 
	}
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(Model model,
			@RequestParam("no") long no) {
		model.addAttribute("no",no);

		command = ctx.getBean("selectBoardCommand", SelectBoardCommand.class);
		command.execute(model);
		
		return "board/view";
	}
	
	@GetMapping(value="updateBoardPage.do")
	public String updateBoardPage(Model model,
			@ModelAttribute("no") long no) {
		
		command = ctx.getBean("selectBoardCommand", SelectBoardCommand.class);
		command.execute(model);
		
		return "board/update";
	}
	
	@PostMapping(value="updateBoard.do")
	public String updateBoard(Model model,
			@ModelAttribute Board board) {
		
		command = ctx.getBean("updateBoardCommand",UpdateBoardCommand.class);
		command.execute(model);
		
		return "redirect:selectBoardByNo.do?no=" + board.getNo();
	}
	
	@GetMapping(value="deleteBoard.do")
	public String deleteBoard(Model model,
			@RequestParam(value="no") long no) {
		model.addAttribute("no",no);
		
		command = ctx.getBean("deleteBoardCommand",DeleteBoardCommand.class);
		command.execute(model);
		
		return "redirect:selectBoardList.do";
	}
}
