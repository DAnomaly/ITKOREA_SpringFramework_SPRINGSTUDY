package com.koreait.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.member.command.EditMemberCommand;
import com.koreait.member.command.EmailAuthCommand;
import com.koreait.member.command.FindIdMemberCommand;
import com.koreait.member.command.IdCheckCommand;
import com.koreait.member.command.JoinMemberCommand;
import com.koreait.member.command.LeaveMemberCommand;
import com.koreait.member.command.LoginMemberCommand;
import com.koreait.member.command.LogoutMemberCommand;

@Controller
public class MemberController {

	private SqlSession sqlSession;
	private IdCheckCommand idCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	private JoinMemberCommand joinMemberCommand;
	private LoginMemberCommand loginMemberCommand;
	private LogoutMemberCommand logoutMemberCommand;
	private LeaveMemberCommand leaveMemberCommand;
	private EditMemberCommand editMemberCommand;
	private FindIdMemberCommand findIdMemberCommand;
	
	@Autowired
	public MemberController(
			SqlSession sqlSession,
			IdCheckCommand idCheckCommand,
			EmailAuthCommand emailAuthCommand,
			JoinMemberCommand joinMemberCommand,
			LoginMemberCommand loginMemberCommand,
			LogoutMemberCommand logoutMemberCommand,
			LeaveMemberCommand leaveMemberCommand,
			EditMemberCommand editMemberCommand,
			FindIdMemberCommand findIdMemberCommand) {
		this.sqlSession = sqlSession;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.joinMemberCommand = joinMemberCommand;
		this.loginMemberCommand = loginMemberCommand;
		this.logoutMemberCommand = logoutMemberCommand;
		this.leaveMemberCommand = leaveMemberCommand;
		this.editMemberCommand = editMemberCommand;
		this.findIdMemberCommand = findIdMemberCommand;
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
	
	@PostMapping(value="join.do")
	public String join(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		joinMemberCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@PostMapping(value="login.do")
	public String login(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		loginMemberCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@RequestMapping(value="logout.do")
	public String logout(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		logoutMemberCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@RequestMapping(value="leave.do")
	public String leave(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		leaveMemberCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@RequestMapping(value="mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping("edit.do")
	public String edit(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		editMemberCommand.execute(sqlSession, model);
		return "redirect:mypage.do";
	}
	
	@RequestMapping("findIdPage.do")
	public String findIdPage() {
		return "redirect:findPage.do?f=id";
	}
	@RequestMapping("findPwPage.do")
	public String findPwPage() {
		return "redirect:findPage.do?f=pw";
	}
	@RequestMapping("findPage.do")
	public String findPage() {
		return "member/find";
	}
	
	@PostMapping(
			value="findId.do",
			produces="text/html; charset=UTF-8")
	@ResponseBody
	public String findId(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return findIdMemberCommand.execute(sqlSession, model);
	}
	
}
