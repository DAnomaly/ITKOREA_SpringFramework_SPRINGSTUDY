package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class CheckKeyMemberCommand implements MemberCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		HttpSession session = request.getSession();
		String key = request.getParameter("key");
		
		Map<String, Object> resultMap = new HashMap<>();
		if(key.equals(session.getAttribute("key")))
			resultMap.put("result", true);
		else 
			resultMap.put("result", false);
		return resultMap;
	}
	
}
