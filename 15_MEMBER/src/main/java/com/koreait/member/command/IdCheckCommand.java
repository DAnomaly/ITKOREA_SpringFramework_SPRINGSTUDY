package com.koreait.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;

@Component
public class IdCheckCommand{

	public Map<String, Integer> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		String id = request.getParameter("id");
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		Map<String, Integer> map = new HashMap<>();
		map.put("count", dao.idCheck(id));
		return map;
	}

}
