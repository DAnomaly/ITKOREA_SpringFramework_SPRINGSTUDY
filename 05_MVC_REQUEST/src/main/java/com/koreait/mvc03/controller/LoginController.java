package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc03.dto.Member;

@Controller
public class LoginController {

	@RequestMapping("loginPage.do")
	public String loginPage() {
		return "member/login";
	}
	
	/*
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("pw", request.getParameter("pw"));
		
		return "member/loginResult";
	}
	*/
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(Member member, Model model) {
		
		model.addAttribute("id", member.getId());
		model.addAttribute("pw", member.getPw());
		
		return "member/loginResult";
	}
	
}
