package com.koreait.mygallery.command.member;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.MemberController;
import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

/**
 * 이름과 이메일 정보를 받아오면<br>
 * 아이디를 확인할 수 있도록 해 줍니다. 
 * 
 * @see MemberController
 * @author 박세환
 */
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
