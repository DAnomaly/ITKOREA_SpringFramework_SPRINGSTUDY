package com.koreait.search.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.search.dao.EmployeesDAO;

@Component
public class IndexListEmployeesCommand implements EmployeesCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		
		EmployeesDAO dao = sqlSession.getMapper(EmployeesDAO.class);
		String param = request.getParameter("c");
		List<String> list = null;
		try {
			list = dao.indexListEmployees(param);
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", list != null && list.size() != 0);
		resultMap.put("list", list);
		
		return resultMap;
	}

}
