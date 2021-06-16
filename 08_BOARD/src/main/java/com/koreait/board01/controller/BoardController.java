package com.koreait.board01.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.board01.command.BoardCommand;
import com.koreait.board01.command.InsertBoardCommand;
import com.koreait.board01.command.ListBoardCommand;
import com.koreait.board01.command.SelectBoardCommand;
import com.koreait.board01.command.UpdateBoardCommand;
import com.koreait.board01.dto.Board;

@Controller
public class BoardController {

	// field
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardCommand command;

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
		
		command = new ListBoardCommand();
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
		command = new InsertBoardCommand();
		command.execute(model);
		
		return "redirect:selectBoardList.do"; 
	}
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(Model model,
			@RequestParam("no") long no) {

		model.addAttribute("no",no);
		
		command = new SelectBoardCommand();
		command.execute(model);
		
		return "board/view";
	}
	
	@GetMapping(value="updateBoardPage.do")
	public String updateBoardPage(Model model,
			@ModelAttribute("no") long no) {
		
		command = new SelectBoardCommand();
		command.execute(model);
		
		return "board/update";
	}
	
	@PostMapping(value="updateBoard.do")
	public String updateBoard(Model model,
			@ModelAttribute Board board) {
		
		command = new UpdateBoardCommand();
		command.execute(model);
		
		return "redirect:selectBoardByNo.do?no=" + board.getNo();
	}
}
