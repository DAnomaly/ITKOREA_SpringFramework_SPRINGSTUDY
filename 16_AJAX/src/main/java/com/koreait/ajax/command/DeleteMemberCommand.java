package com.koreait.ajax.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class DeleteMemberCommand implements MemberCommand {
	
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
