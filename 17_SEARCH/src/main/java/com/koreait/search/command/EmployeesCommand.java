package com.koreait.search.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

public interface EmployeesCommand {

	static Logger logger = LoggerFactory.getLogger(EmployeesCommand.class);
	
	// @ResponseBody가 아닐경우 Null 반환
	public Map<String, Object> execute(SqlSession sqlSession, Model model);
	
}
