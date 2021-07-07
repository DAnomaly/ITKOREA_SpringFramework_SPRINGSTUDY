package com.koreait.mygallery.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.controller.MemberController;
import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

/**
 * 회원 탈퇴 페이지에 필요한 데이터를 보내줍니다.
 * <ul>
 * 		<li>총 작성한 갤러리의 수 : g_count</li>
 * 		<li>총 작성한 게시글의 수 : b_count</li>
 * </ul>
 * 
 * @see MemberController
 * @author 박세환
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
