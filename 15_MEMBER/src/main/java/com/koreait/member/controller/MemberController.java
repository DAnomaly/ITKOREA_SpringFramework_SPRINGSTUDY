package com.koreait.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.member.command.EmailAuthCommand;
import com.koreait.member.command.IdCheckCommand;

@Controller
public class MemberController {

	private SqlSession sqlSession;
	private IdCheckCommand idCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	
	@Autowired
	public MemberController(
			SqlSession sqlSession,
			IdCheckCommand idCheckCommand,
			EmailAuthCommand emailAuthCommand) {
		this.sqlSession = sqlSession;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("joinPage.do")
	public String joinPage() {
		return "member/join";
	}
	
	@RequestMapping(
			value="idCheck.do",
			produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Integer> idCheck(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return idCheckCommand.execute(sqlSession, model); 
	}
	
	@RequestMapping(
			value="verifyKey.do",
			produces="text/plain; charset=UTF-8")
	@ResponseBody
	public String verifyKey(
			HttpServletRequest request,
			Model model) {
		model.addAttribute("request", request);
		return emailAuthCommand.execute(model);
	}
}
