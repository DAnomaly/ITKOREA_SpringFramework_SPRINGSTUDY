package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

/**
 * 회원 탈퇴 커맨드
 * 
 * @author 박세환
 */
@Component
public class RemoveMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.removeMember(loginMember);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		if(result > 0) {
			session.invalidate();
			sb.append("alert('성공적으로 계정이 탈퇴되었습니다.');");
			sb.append("location.href='/mygallery/';");
		} else {
			sb.append("alert('오류가 발생했습니다.');");
		}
		sb.append("</script>");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("response", sb.toString());
		return resultMap;
	}

}
