package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.MemberController;

/**
 * 로그아웃 작업을 수행합니다.<br>
 * session.invalidate()합니다.<br>
 * 요청 작업을 수행한 뒤 alert("로그아웃 되었습니다.");를 수행한 뒤 <br>
 * index페이지로 이동합니다.
 * 
 * @see MemberController
 * @author 박세환
 */
@Component
public class LogoutMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		request.getSession().invalidate();
		
		Map<String, Object> resultMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('로그아웃 되었습니다.');");
		sb.append("location.href='/mygallery/index.do'");
		sb.append("</script>");
		resultMap.put("response", sb.toString());
		return resultMap;
	}

}
