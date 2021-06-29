package com.koreait.search.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeesController {
	
	private SqlSession sqlSession;

	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
}
