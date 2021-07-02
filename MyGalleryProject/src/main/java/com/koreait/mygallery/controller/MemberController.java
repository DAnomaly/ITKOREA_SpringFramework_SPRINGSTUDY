package com.koreait.mygallery.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.mygallery.command.member.CheckEmailMemberCommand;
import com.koreait.mygallery.command.member.CheckIdMemberCommand;
import com.koreait.mygallery.command.member.EditMemberCommand;
import com.koreait.mygallery.command.member.JoinMemberCommand;
import com.koreait.mygallery.command.member.LoginMemberCommand;
import com.koreait.mygallery.command.member.LogoutMemberCommand;
import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

@Controller
@RequestMapping(value="member")
public class MemberController {

	private SqlSession sqlSession;
	private JoinMemberCommand joinMemberCommand;
	private LoginMemberCommand loginMemberCommand;
	private LogoutMemberCommand logoutMemberCommand;
	private CheckIdMemberCommand checkIdMemberCommand;
	private CheckEmailMemberCommand checkEmailMemberCommand;
	private EditMemberCommand editMemberCommand;
	
	@Autowired
	public MemberController(
			SqlSession sqlSession, 
			JoinMemberCommand joinMemberCommand,
			LoginMemberCommand loginMemberCommand, 
			LogoutMemberCommand logoutMemberCommand,
			CheckIdMemberCommand checkIdMemberCommand, 
			CheckEmailMemberCommand checkEmailMemberCommand,
			EditMemberCommand editMemberCommand) {
		this.sqlSession = sqlSession;
		this.joinMemberCommand = joinMemberCommand;
		this.loginMemberCommand = loginMemberCommand;
		this.logoutMemberCommand = logoutMemberCommand;
		this.checkIdMemberCommand = checkIdMemberCommand;
		this.checkEmailMemberCommand = checkEmailMemberCommand;
		this.editMemberCommand = editMemberCommand;
	}

	/**
	 * 로그인 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value="loginView.do")
	public String loginView() {
		return "member/login";
	}
	
	/**
	 * 회원가입 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value="joinView.do")
	public String joinView() {
		return "member/join";
	}

	/**
	 * 마이페이지
	 * 
	 * @return
	 */
	@RequestMapping(value="mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	/**
	 * 로그인
	 * 
	 * @see LoginMemberCommand
	 * @see MemberDAO
	 * @param model
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="login.do",
				    method=RequestMethod.POST,
				    produces="application/json; charset=UTF-8")
	public Map<String, Object> login(
			Model model,
			HttpServletRequest request,
			@RequestBody Member member) {
		model.addAttribute("request", request);
		model.addAttribute("member", member);
		return loginMemberCommand.execute(sqlSession, model);
	}
	
	/**
	 * 회원가입
	 * 
	 * @see JoinMemberCommand
	 * @see MemberDAO
	 * @param model
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="join.do",
			        method=RequestMethod.POST,
			        produces="application/json; charset=UTF-8")
	public Map<String, Object> join(
			Model model,
			@RequestBody Member member) {
		model.addAttribute("member", member);
		return joinMemberCommand.execute(sqlSession, model);
	}

	/**
	 * 회원 아이디 중복 확인
	 * 
	 * @see CheckIdMemberCommand
	 * @see MemberDAO
	 * @param model
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="checkId.do",
				    method=RequestMethod.POST,
				    produces="application/json; charset=UTF-8")
	public Map<String, Object> checkId(
			Model model,
			@RequestBody Member member) {
		model.addAttribute("member", member);
		return checkIdMemberCommand.execute(sqlSession, model); 
	}
	
	/**
	 * 회원 이메일 중복 확인 및 인증코드 전송
	 * 
	 * @see CheckEmailMemberCommand
	 * @see MemberDAO
	 * @param model
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="checkEmail.do",
				    method=RequestMethod.POST,
				    produces="application/json; charset=UTF-8")
	public Map<String, Object> checkEmail(
			Model model,
			@RequestBody Member member) {
		model.addAttribute("member", member);
		return checkEmailMemberCommand.execute(sqlSession, model); 
	}
	
	/**
	 * 로그아웃
	 * 
	 * @see LogoutMemberCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="logout.do",
					produces="text/html; charset=UTF-8")
	public String logout(
			Model model,
			HttpServletRequest request){
		model.addAttribute("request", request);
		return (String)logoutMemberCommand.execute(sqlSession, model).get("response");
	}
	
	@ResponseBody
	@RequestMapping(value="edit.do",
					method=RequestMethod.POST,
					produces="application/json; charset=UTF-8")
	public Map<String, Object> edit(
			Model model,
			@RequestBody Member member){
		model.addAttribute("member", member);
		return editMemberCommand.execute(sqlSession, model);
	}
}

