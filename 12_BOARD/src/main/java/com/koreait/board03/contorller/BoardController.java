package com.koreait.board03.contorller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.board03.command.DeleteBoardCommand;
import com.koreait.board03.command.InsertBoardCommand;
import com.koreait.board03.command.SelectBoardListCommand;
import com.koreait.board03.command.SelectBoardOneCommand;
import com.koreait.board03.command.UpdateBoardCommand;
import com.koreait.board03.dto.Board;

@Controller
public class BoardController {
	
	// field
	// private SqlSessionTemplate sqlSession;
	@Autowired
	private SqlSession sqlSession; // SqlSessionTemplate클래스는 SqlSession인터페이스를 구현하고 있으므로  @Autowired 할 수 있다.
	// commands
	@Autowired
	SelectBoardListCommand selectBoardListCommand;
	@Autowired
	SelectBoardOneCommand selectBoardOneCommand;
	@Autowired
	InsertBoardCommand insertBoardCommand;
	@Autowired
	UpdateBoardCommand updateBoardCommand;
	@Autowired
	DeleteBoardCommand deleteBoardCommand;
	
	@RequestMapping(value={"/","index.do"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("selectBoardList.do")
	public String selectBoardList(Model model) {
		selectBoardListCommand.execute(model, sqlSession);
		return "board/list";
	}
	
	@RequestMapping("selectBoardByNo.do")
	public String selectBoardByNo(Model model,
			HttpServletRequest request) {
		model.addAttribute("req",request);
		selectBoardOneCommand.execute(model, sqlSession);
		return "board/view";
	}
	
	@RequestMapping("insertBoardPage.do")
	public String insertBoardpage() {
		return "board/insert";
	}
	
	@PostMapping("insertBoard.do")
	public String insertBoard(Model model,
			HttpServletRequest request) {
		model.addAttribute("req",request);
		insertBoardCommand.execute(model, sqlSession);
		return "redirect:selectBoardList.do";
	}
	
	@RequestMapping("updateBoardPage.do")
	public String updateBoardPage(Model model,
			HttpServletRequest request) {
		model.addAttribute("req",request);
		selectBoardOneCommand.execute(model, sqlSession);
		return "board/update";
	}
	
	@PostMapping("updateBoard.do")
	public String updateBoard(Model model,
			Board board) {
		model.addAttribute("board",board);
		updateBoardCommand.execute(model, sqlSession);
		return "redirect:selectBoardByNo.do?no=" + board.getNo();
	}
	
	@GetMapping("deleteBoard.do")
	public String deleteBoard(Model model,
			HttpServletRequest request) {
		model.addAttribute("req",request);
		deleteBoardCommand.execute(model, sqlSession);
		return "redirect:selectBoardList.do";
	}
}
