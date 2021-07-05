package com.koreait.mygallery.command.member;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

@Component
public class FindIdMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		Member member = (Member)model.asMap().get("member");
		
		Member findMember = dao.findMember(member);
		model.addAttribute("findMember", findMember);
		
		return null;
	}

}
