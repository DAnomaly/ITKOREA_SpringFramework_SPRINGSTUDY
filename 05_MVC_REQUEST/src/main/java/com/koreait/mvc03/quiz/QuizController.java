package com.koreait.mvc03.quiz;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("quiz")
public class QuizController {

	@RequestMapping("v1")
	public String v1(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		int hit = Integer.parseInt(request.getParameter("hit"));
		Date date = new Date();

		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		model.addAttribute("date", date);

		return "quiz/board";
	}
	
	@RequestMapping("v2")
	public String v2(Model model,
			@RequestParam("title") String title,
			@RequestParam("hit") int hit) {

		Date date = new Date();

		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		model.addAttribute("date", date);
		
		return "quiz/board";
	}
	@RequestMapping("v3")
	public String v3(Model model, Board board) {
		
		board.setDate(new Date());
		
		model.addAttribute("board", board);
		
		return "quiz/board";
	}
	@RequestMapping("v4")
	public String v4(
			@ModelAttribute Board board) {

		board.setDate(new Date());
		
		return "quiz/board";
	}
	
}
