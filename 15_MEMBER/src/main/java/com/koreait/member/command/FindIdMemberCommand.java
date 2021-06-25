package com.koreait.member.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;

@Component
public class FindIdMemberCommand {
	public String execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		String email = request.getParameter("email");
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		String findId = memberDAO.findId(email);
		
		StringBuilder sb = new StringBuilder();
		if(findId != null && !findId.isEmpty()) {
			sb.append("<script>");
			sb.append("alert('찾으시는 아이디: " + findId + "');");
			sb.append("location.href='findIdPage.do';");
			sb.append("</script>");
		} else {
			sb.append("<script>");
			sb.append("alert('해당 이메일을 가진 계정이 존재하지 않습니다.');");
			sb.append("location.href='findIdPage.do';");
			sb.append("</script>");
		}
		return sb.toString();
	}

}
