package com.koreait.integration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.integration.domain.Board;
import com.koreait.integration.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;  
	
	@RequestMapping(value= {"/","index.do"})
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="selectAll.do", 
			        method=RequestMethod.GET, 
			        produces="application/json; charset=UTF-8")
	public Map<String, Object> selectAll() {
		Map<String, Object> resultMap = new HashMap<>();
		List<Board> list = boardService.totalList();
		resultMap.put("list", list);
		if(list == null || list.isEmpty()) 
			resultMap.put("status",1400);
		else 
			resultMap.put("status",200);
		resultMap.put("message","Load List:size=" + list.size());
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value="selectQuery.do", 
			        method=RequestMethod.GET, 
			        produces="application/json; charset=UTF-8")
	public Map<String, Object> selectQuery(
				HttpServletRequest request) {
		Map<String, Object> params = new HashMap<>();
		params.put("column", request.getParameter("column"));
		params.put("query", request.getParameter("query"));
		List<Board> list = boardService.searchList(params);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		if(list == null || list.isEmpty()) 
			resultMap.put("status",1400);
		else 
			resultMap.put("status",200);
		resultMap.put("message","Load List:size=" + list.size());
		return resultMap;
	}
	
}
