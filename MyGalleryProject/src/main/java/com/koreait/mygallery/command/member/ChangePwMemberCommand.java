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
 * 비밀번호 찾기 페이지에서 비밀번호 변경 작업을 수행합니다.
 * 
 * @see MemberController
 * @author 박세환
 */
@Component
public class ChangePwMemberCommand implements MemberCommand{

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		
		Member member = (Member)model.asMap().get("member");
		member.setPw(SecurityUtils.sha256(member.getPw()));
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.changePw(member);

		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		if( result > 0 ) {
			sb.append("alert('비밀번호가 성공적으로 변경되었습니다.'); ")
			  .append("location.href='/mygallery/member/loginView.do'; ");
		} else {
			sb.append("alert('오류가 발생했습니다.'); ")
			.append("history.back(); ");
		}
		sb.append("</script>");
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("response", sb.toString());
		return resultMap;
	}
	
}
