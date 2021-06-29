package com.koreait.ajax.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="manageMember.do")
	public String manageMember() {
		return "member/manageMember";
	}
	
	@GetMapping(value="viewMember.do")
	public String viewMember() {
		return "member/viewMember";
	}
}
