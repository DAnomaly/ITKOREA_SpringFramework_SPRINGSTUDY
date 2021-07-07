package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.MemberController;
import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

/**
 * 로그인 작업을 수행합니다.<br>
 * 일치하는 회원정보를 찾으면 Session에 loginMember를 저장하고, map에 result:true로 저장합니다.<br>
 * 찾지 못하였을 경우 map에 result:false로 저장합니다.
 * 
 * @see MemberController
 * @author 박세환
 */
@Component
public class LoginMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> modelMap = model.asMap();
		
		Member member = (Member)modelMap.get("member");
		member.setPw(SecurityUtils.sha256(member.getPw()));
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		Member loginMember = dao.loginMember(member);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", loginMember != null);
		
		if((boolean)resultMap.get("result")) {
			HttpSession session = ((HttpServletRequest)modelMap.get("request")).getSession();
			session.setAttribute("loginMember", loginMember);
		}

		return resultMap;
	}

}
