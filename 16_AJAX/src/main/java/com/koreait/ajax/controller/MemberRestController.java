package com.koreait.ajax.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.ajax.command.InsertMemeberCommand;
import com.koreait.ajax.command.SelectListMemberCommand;
import com.koreait.ajax.dto.Member;
import com.koreait.ajax.dto.Page;

@RestController
public class MemberRestController {

	// 앞으로 모든 메소드는 @ResponseBoby 애너테이션을 추가하지 않아도 ajax 처리가 된다.
	
	// field
	private SqlSession sqlSession;
	private InsertMemeberCommand insertMemeberCommand;
	private SelectListMemberCommand selectListMemberCommand;
	
	// constructor
	@Autowired
	public MemberRestController(
			SqlSession sqlSession, 
			InsertMemeberCommand insertMemeberCommand,
			SelectListMemberCommand selectListMemberCommand) {
		this.sqlSession = sqlSession;
		this.insertMemeberCommand = insertMemeberCommand;
		this.selectListMemberCommand = selectListMemberCommand;
	}

	@PostMapping(value="insertMember.do",
			     produces="application/json; charset=UTF-8")
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
	public Map<String, Object> selectListMember(
			Model model,
			@RequestBody Page page) {
		model.addAttribute("page",page.getPage());
		return selectListMemberCommand.execute(sqlSession, model);
	}
	
	
	
	
	
}
