package com.koreait.search.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.search.dao.EmployeesDAO;
import com.koreait.search.dto.Employees;
import com.koreait.search.dto.Page;
import com.koreait.search.util.PagingUtils;

@Component
public class SelectListEmployeesCommand implements EmployeesCommand {

	private EmployeesDAO dao;
	
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		dao = sqlSession.getMapper(EmployeesDAO.class);
		
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int nowpage = Integer.parseInt(opt.orElse("1"));
		String c = request.getParameter("c");
		String s = request.getParameter("s");
		String bottom = request.getParameter("bottom");
		String top = request.getParameter("top");
		
		Map<String, Object> searchMap = new HashMap<>();
		if(c != null && !c.isEmpty()) 
			searchMap.put("c", c);
		if(s != null && !s.isEmpty())
			searchMap.put("s", "%" + s + "%");
		if(bottom != null && !bottom.isEmpty()) 
			searchMap.put("bottom", Integer.parseInt(bottom));
		else
			searchMap.put("bottom",0);
		if(top != null && !top.isEmpty())
			searchMap.put("top", Integer.parseInt(top));
		else
			searchMap.put("top", 99999999);
		int totalRecord = dao.countEmployees(searchMap); // DAO : TOTALRECORD
		
		Page page = PagingUtils.getPage(nowpage, totalRecord);
		searchMap.put("beginRecord", page.getBeginRecord());
		searchMap.put("endRecord", page.getEndRecord());
		List<Employees> list = dao.selectListEmployees(searchMap); // DAO : LIST<EMPLOYEES>
		model.addAttribute("list", list); // MODEL : LIST

		String path = new StringBuilder().append("/search/list.do?c=").append(c != null ? c : "").append("&s=").append(s != null ? s : "").toString();
		String paging = PagingUtils.getPaging(path, page);
		model.addAttribute("paging", paging); // MODEL : PAGING
		
		return null;
	}

}
