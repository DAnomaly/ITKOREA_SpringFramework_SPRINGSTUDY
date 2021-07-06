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

import com.koreait.mygallery.command.member.ChangePwMemberCommand;
import com.koreait.mygallery.command.member.CheckEmailMemberCommand;
import com.koreait.mygallery.command.member.CheckIdMemberCommand;
import com.koreait.mygallery.command.member.CheckKeyMemberCommand;
import com.koreait.mygallery.command.member.EditMemberCommand;
import com.koreait.mygallery.command.member.FindIdMemberCommand;
import com.koreait.mygallery.command.member.FindPwMemberCommand;
import com.koreait.mygallery.command.member.JoinMemberCommand;
import com.koreait.mygallery.command.member.LoginMemberCommand;
import com.koreait.mygallery.command.member.LogoutMemberCommand;
import com.koreait.mygallery.command.member.RemoveMemberCommand;
import com.koreait.mygallery.command.member.RemovePageMemberCommand;
import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

/**
 * 회원과 관련된<br>
 * 로그인, 로그아웃, 회원가입, 회원탈퇴 등을 당담하는 컨트롤러
 * 
 * @author 박세환
 */
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
	private RemovePageMemberCommand removePageMemberCommand;
	private RemoveMemberCommand removeMemberCommand;
	private FindIdMemberCommand findIdMemberCommand;
	private FindPwMemberCommand findPwMemberCommand;
	private CheckKeyMemberCommand checkKeyMemberCommand;
	private ChangePwMemberCommand changePwMemberCommand;
	
	@Autowired
	public MemberController(
			SqlSession sqlSession, 
			JoinMemberCommand joinMemberCommand,
			LoginMemberCommand loginMemberCommand, 
			LogoutMemberCommand logoutMemberCommand,
			CheckIdMemberCommand checkIdMemberCommand, 
			CheckEmailMemberCommand checkEmailMemberCommand,
			EditMemberCommand editMemberCommand,
			RemovePageMemberCommand removePageMemberCommand,
			RemoveMemberCommand removeMemberCommand,
			FindIdMemberCommand findIdMemberCommand,
			FindPwMemberCommand findPwMemberCommand,
			CheckKeyMemberCommand checkKeyMemberCommand,
			ChangePwMemberCommand changePwMemberCommand) {
		this.sqlSession = sqlSession;
		this.joinMemberCommand = joinMemberCommand;
		this.loginMemberCommand = loginMemberCommand;
		this.logoutMemberCommand = logoutMemberCommand;
		this.checkIdMemberCommand = checkIdMemberCommand;
		this.checkEmailMemberCommand = checkEmailMemberCommand;
		this.editMemberCommand = editMemberCommand;
		this.removePageMemberCommand = removePageMemberCommand;
		this.removeMemberCommand = removeMemberCommand;
		this.findIdMemberCommand = findIdMemberCommand;
		this.findPwMemberCommand = findPwMemberCommand;
		this.checkKeyMemberCommand = checkKeyMemberCommand;
		this.changePwMemberCommand = changePwMemberCommand;
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
	 * 회원 탈퇴 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value="removePage.do")
	public String removePage(Model model,
			HttpServletRequest request) {
		model.addAttribute("request",request);
		removePageMemberCommand.execute(sqlSession, model);
		return "member/remove";
	}
	
	/**
	 * 아이디/비밀번호 찾기 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value="findView.do")
	public String findPage() {
		return "member/find";
	}
	
	/**
	 * 아이디 찾기 페이지
	 * 
	 * @see FindIdMemberCommand
	 * @param model
	 * @param member
	 * @return
	 */
	@RequestMapping(value="getidView.do")
	public String getIdPage(
			Model model,
			Member member) {
		model.addAttribute("member", member);
		findIdMemberCommand.execute(sqlSession, model);
		return "member/getid";
	}
	
	/**
	 * 비밀번호 변경 페이지
	 * 
	 * @see ChangePwMemberCommand
	 * @param model
	 * @param member
	 * @param request
	 * @return
	 */
	@RequestMapping(value="changepwView.do")
	public String changepwPage(
			Model model,
			Member member,
			HttpServletRequest request) {
		model.addAttribute("member", member);
		model.addAttribute("request", request);
		findPwMemberCommand.execute(sqlSession, model);
		return "member/changepw";
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
	
	/**
	 * 회원 정보 수정
	 * 
	 * @see EditMemberCommand
	 * @see MemberDAO
	 * @param model
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="edit.do",
					method=RequestMethod.POST,
					produces="application/json; charset=UTF-8")
	public Map<String, Object> edit(
			Model model,
			HttpServletRequest request,
			@RequestBody Member member){
		model.addAttribute("request", request);
		model.addAttribute("member", member);
		return editMemberCommand.execute(sqlSession, model);
	}
	
	/**
	 * 회원 탈퇴
	 * 
	 * @see RemoveMemberCommand
	 * @see MemberDAO
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="remove.do",
					produces="text/html; charset=UTF-8")
	public String remove(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return (String)removeMemberCommand.execute(sqlSession, model).get("response");
	}
	
	/**
	 * 키 인증 (비밀번호 변경)
	 * 
	 * @see CheckKeyMemberCommand
	 * @param model
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="checkKey.do",
					method=RequestMethod.GET,
					produces="application/json; charset=UTF-8")
	public Map<String, Object> checkKey(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		return checkKeyMemberCommand.execute(sqlSession, model);
	}
	
	@ResponseBody
	@RequestMapping(value="changePw.do",
					method=RequestMethod.POST,
					produces="text/html; charset=UTF-8")
	public String changePw(
			Model model,
			Member member) {
		model.addAttribute("member", member);
		return (String)changePwMemberCommand.execute(sqlSession, model).get("response"); 
	}
}

