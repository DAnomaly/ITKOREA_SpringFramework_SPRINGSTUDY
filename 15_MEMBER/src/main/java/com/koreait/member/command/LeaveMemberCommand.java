package com.koreait.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;
import com.koreait.member.dto.Member;

@Component
public class LeaveMemberCommand implements MemberCommand{

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		long no = ((Member)session.getAttribute("loginUser")).getNo();
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		memberDAO.leave(no);
		session.invalidate();
	}
	
}
