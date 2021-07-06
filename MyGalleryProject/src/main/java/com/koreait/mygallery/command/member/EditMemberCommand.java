package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.MemberController;
import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

/**
 * 회원 정보 수정 커맨드
 * 
 * @see MemberController
 * @author 박세환
 */
@Component
public class EditMemberCommand implements MemberCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> modelMap = model.asMap();
		Member member = (Member)modelMap.get("member");
		if(member.getPw() != null && !member.getPw().isEmpty())
			member.setPw(SecurityUtils.sha256(member.getPw()));
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.editMember(member); 
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result > 0);
		
		if(result > 0) {
			HttpServletRequest request = (HttpServletRequest)modelMap.get("request");
			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
			loginMember.setName(member.getName());
			loginMember.setAddress(member.getAddress());
			if(member.getPw() != null && !member.getPw().isEmpty())
				loginMember.setPw(member.getPw());
		}
		
		return resultMap;
	}
	
}
