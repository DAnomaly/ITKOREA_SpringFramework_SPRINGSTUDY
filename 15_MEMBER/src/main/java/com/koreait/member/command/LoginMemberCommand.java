package com.koreait.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;
import com.koreait.member.dto.Member;

@Component
public class LoginMemberCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 암호화 된 pw
		String encodedPw = SecurityUtils.encodeBase64(pw);
		
		Member info = new Member();
		info.setId(id);
		info.setPw(encodedPw);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		Member loginUser = memberDAO.loginMember(info);
		
		if(loginUser != null) {
			loginUser.setName(SecurityUtils.xxs(loginUser.getName()));
			request.getSession().setAttribute("loginUser", loginUser);
		}
	}

}
