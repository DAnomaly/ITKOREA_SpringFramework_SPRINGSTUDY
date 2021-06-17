package com.koreait.board02.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.board02.command.DeleteBoardCommand;
import com.koreait.board02.command.InsertBoardCommand;
import com.koreait.board02.command.SelectListBoardCommand;
import com.koreait.board02.command.SelectOneBoardCommand;
import com.koreait.board02.command.UpdateBoardCommand;
import com.koreait.board02.config.BeanConfiguration;
import com.koreait.board02.dto.Board;

@Controller
public class BoardController {
	private final static Logger logger = LoggerFactory.getLogger(BoardController.class);

	AbstractApplicationContext ctx;
	
	public BoardController() {
		ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		setCommand();
	}
	
	private SelectListBoardCommand selectListBoardCommand;
	private SelectOneBoardCommand selectOneBoardCommand;
	private UpdateBoardCommand updateBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;
	private InsertBoardCommand insertBoardCommand;
	/*
	@Autowired
	public void setCommand(
			SelectListBoardCommand selectListBoardCommand, 
			SelectOneBoardCommand selectOneBoardCommand,
			UpdateBoardCommand updateBoardCommand, 
			DeleteBoardCommand deleteBoardCommand,
			InsertBoardCommand insertBoardCommand) {
		this.selectListBoardCommand = selectListBoardCommand;
		this.selectOneBoardCommand = selectOneBoardCommand;
		this.updateBoardCommand = updateBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
		this.insertBoardCommand = insertBoardCommand;
	}
	*/
	
	public void setCommand() {
		this.selectListBoardCommand = ctx.getBean("selectListBoardCommand",SelectListBoardCommand.class);
		this.selectOneBoardCommand = ctx.getBean("selectOneBoardCommand",SelectOneBoardCommand.class);
		this.updateBoardCommand = ctx.getBean("updateBoardCommand",UpdateBoardCommand.class);
		this.deleteBoardCommand = ctx.getBean("deleteBoardCommand",DeleteBoardCommand.class);
		this.insertBoardCommand = ctx.getBean("insertBoardCommand",InsertBoardCommand.class);
	}
	
	@GetMapping(value = { "/", "index.do" })
	public String index() {
		logger.info("index() 메소드 실행됨");
		return "index";
	}

	@GetMapping("selectBoardList.do")
	public String selectBoardList(Model model) {

		selectListBoardCommand.execute(model);

		return "board/list";
	}

	@GetMapping("selectBoardByNo.do")
	public String selectBoardByNo(Model model, long no) {

		model.addAttribute("no", no);
		selectOneBoardCommand.execute(model);

		return "board/view";
	}

	@GetMapping("updateBoardPage.do")
	public String updateBoardPage(Model model, long no) {

		model.addAttribute("no", no);
		selectOneBoardCommand.execute(model);

		return "board/update";
	}

	@GetMapping("deleteBoard.do")
	public String deleteBoard(Model model, long no) {

		model.addAttribute("no", no);
		deleteBoardCommand.execute(model);

		return selectBoardList(model); // 이게 됨
	}

	@PostMapping("updateBoard.do")
	public String updateBoard(Model model, Board board) {
		model.addAttribute("board", board);
		updateBoardCommand.execute(model);

		return "redirect:selectBoardByNo.do?no=" + board.getNo();
	}

	@GetMapping("insertBoardPage.do")
	public String insertBoardPage(Model model) {
		return "board/insert";
	}

	@PostMapping("insertBoard.do")
	public String insertBoard(Model model, Board board) {
		model.addAttribute("board", board);
		insertBoardCommand.execute(model);

		return "redirect:selectBoardList.do";
	}

}
