package com.koreait.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;
import com.koreait.member.dto.Member;

@Component
public class EditMemberCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		long no = Long.parseLong(request.getParameter("no"));
		
		Member member = new Member();
		member.setNo(no);
		if(pw != null && !pw.isEmpty()) {
			member.setPw(SecurityUtils.encodeBase64(pw));
		}
		member.setName(name);
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int count = dao.editMember(member);
		
		if(count > 0) {
			HttpSession session = request.getSession();
			Member loginUser = (Member)session.getAttribute("loginUser");
			loginUser.setName(name);
			if(pw != null && !pw.isEmpty()) {
				loginUser.setPw(pw);
			}
		}
		
	}

}
