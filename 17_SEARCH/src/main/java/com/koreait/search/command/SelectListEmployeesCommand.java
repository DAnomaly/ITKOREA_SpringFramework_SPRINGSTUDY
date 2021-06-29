package com.koreait.search.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class SelectListEmployeesCommand implements EmployeesCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
