package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;

/**
 * 아이디 중복 여부를 판단하는 커맨드
 * 
 * @author 박세환
 */
@Component
public class CheckIdMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Member member = (Member)model.asMap().get("member");
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.checkId(member);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result == 0);
		return resultMap;
	}

}
