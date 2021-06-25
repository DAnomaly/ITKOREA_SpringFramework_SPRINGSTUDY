package com.koreait.member.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;
import com.koreait.member.dto.Member;

@Component
public class JoinMemberCommand implements MemberCommand {

	private static final Logger LOGGER = LoggerFactory.getLogger(JoinMemberCommand.class);
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		pw = SecurityUtils.encodeBase64(pw);
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		dao.joinMember(member);
		LOGGER.info("가입완료");
	}

}
