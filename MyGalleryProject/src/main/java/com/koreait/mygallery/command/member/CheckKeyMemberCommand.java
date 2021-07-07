package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.MemberController;

/**
 * 인증키가 동일한지 확인합니다.
 * 동일한 경우 JSON(result:true)를 반환할 수 있게 합니다.
 * 
 * @see MemberController
 * @author 박세환
 */
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
