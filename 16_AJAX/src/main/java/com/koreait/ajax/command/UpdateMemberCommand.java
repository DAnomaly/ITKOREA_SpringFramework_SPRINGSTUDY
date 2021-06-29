package com.koreait.ajax.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.ajax.dao.MemberDAO;
import com.koreait.ajax.dto.Member;

@Component
public class UpdateMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Map<String, Object> modelMap = model.asMap();
		Member member = (Member)modelMap.get("member");
		logger.info(member.toString());
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.updateMember(member);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result > 0);
		return resultMap;
	}

}
