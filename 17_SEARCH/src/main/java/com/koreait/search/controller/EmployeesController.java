package com.koreait.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.search.command.IndexListEmployeesCommand;
import com.koreait.search.command.SelectListEmployeesCommand;

@Controller
public class EmployeesController {
	
	private SqlSession sqlSession;
	private SelectListEmployeesCommand selectListEmployeesCommand;
	private IndexListEmployeesCommand indexListEmployeesCommand;

	@Autowired
	public EmployeesController(
			SqlSession sqlSession, 
			SelectListEmployeesCommand selectListEmployeesCommand,
			IndexListEmployeesCommand indexListEmployeesCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectListEmployeesCommand = selectListEmployeesCommand;
		this.indexListEmployeesCommand = indexListEmployeesCommand;
	}

	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="list.do")
	public String list(
			Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		selectListEmployeesCommand.execute(sqlSession, model);
		return "list";
	}
	
	@RequestMapping(value="index_list.do",
			        produces="application/json; charset=UTF-8")
	@ResponseBody
	public String index_list(
			Model model,
			HttpServletRequest request){
		model.addAttribute("request",request);
		JSONObject obj = new JSONObject(indexListEmployeesCommand.execute(sqlSession, model));
		return obj.toString();
	}
	
}
