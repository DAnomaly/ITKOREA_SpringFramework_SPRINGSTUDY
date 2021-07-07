package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.MemberController;
import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

/**
 * 회원가입을 통해 Member Table에 회원을 등록합니다. 
 * 
 * @see MemberController
 * @author 박세환
 */
@Component
public class JoinMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		Member member = (Member)model.asMap().get("member");
		member.setPw(SecurityUtils.sha256(member.getPw()));
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.joinMember(member);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result > 0);
		
		return resultMap;
	}
	
}
