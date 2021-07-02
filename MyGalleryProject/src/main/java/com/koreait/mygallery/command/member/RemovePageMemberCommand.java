package com.koreait.mygallery.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

/**
 * 회원 탈퇴 페이지 커맨드
 * 
 * @author ITSC
 */
@Component
public class RemovePageMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		if(loginMember == null)
			return null;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int g_count = dao.countGalleryByNo(loginMember);
		int b_count = dao.countBoardByNo(loginMember);
		model.addAttribute("g_count",g_count);
		model.addAttribute("b_count",b_count);
		return null;
	}
	
}
