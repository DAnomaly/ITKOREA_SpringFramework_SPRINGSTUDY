package com.koreait.mygallery.command.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.mygallery.dao.MemberDAO;
import com.koreait.mygallery.dto.Member;
import com.koreait.mygallery.util.SecurityUtils;

@Component
public class CheckEmailMemberCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		Member member = (Member)model.asMap().get("member");
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.checkEmail(member);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result == 0);
		if((boolean)resultMap.get("result")) {
			String key = SecurityUtils.createKey(6);
			resultMap.put("key", key);
			// TODO
		}
		return resultMap;
	}

}
