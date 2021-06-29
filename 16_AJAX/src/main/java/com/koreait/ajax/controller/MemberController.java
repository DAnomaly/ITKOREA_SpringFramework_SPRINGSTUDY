package com.koreait.ajax.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.ajax.command.DeleteMemberCommand;
import com.koreait.ajax.command.InsertMemeberCommand;
import com.koreait.ajax.command.SelectListMemberCommand;
import com.koreait.ajax.command.UpdateMemberCommand;
import com.koreait.ajax.dto.Member;
import com.koreait.ajax.dto.Page;

@Controller
public class MemberController {

	// field
	private SqlSession sqlSession;
	private InsertMemeberCommand insertMemeberCommand;
	private SelectListMemberCommand selectListMemberCommand;
	private UpdateMemberCommand updateMemberCommand;
	private DeleteMemberCommand deleteMemberCommand;
	
	@Autowired
	public MemberController(
			SqlSession sqlSession, 
			InsertMemeberCommand insertMemeberCommand,
			SelectListMemberCommand selectListMemberCommand, 
			UpdateMemberCommand updateMemberCommand,
			DeleteMemberCommand deleteMemberCommand) {
		this.sqlSession = sqlSession;
		this.insertMemeberCommand = insertMemeberCommand;
		this.selectListMemberCommand = selectListMemberCommand;
		this.updateMemberCommand = updateMemberCommand;
		this.deleteMemberCommand = deleteMemberCommand;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="manageMember.do")
	public String manageMember() {
		return "member/manageMember";
	}
	
	@GetMapping(value="manageMemberRest.do")
	public String manageMemberRest() {
		return "member/manageMemberRest";
	}
	
	@GetMapping(value="viewMember.do")
	public String viewMember() {
		return "member/viewMember";
	}
	
	@GetMapping(value="viewMemberRest.do")
	public String viewMemberRest() {
		return "member/viewMemberRest";
	}
	
	@PostMapping(value="insertMember.do",
		     produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> insertMember(
			Model model,
			@RequestBody Member member,
			HttpServletResponse response) {
		model.addAttribute("member", member);
		model.addAttribute("response", response);
		return insertMemeberCommand.execute(sqlSession, model); 
	}
	
	@PostMapping(value="selectListMember.do",
				 produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> selectListMember(
			Model model,
			@RequestBody Page page) {
		model.addAttribute("page",page.getPage());
		return selectListMemberCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="editMember.do",
				 produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> editMember(
			Model model,
			@RequestBody Member member){
		model.addAttribute("member", member);
		return updateMemberCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="delMember.do",
			 produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> delMember(
			Model model,
			@RequestBody Member member){
		model.addAttribute("member", member);
		return deleteMemberCommand.execute(sqlSession, model);
	}
}
