package com.koreait.ajax.command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

public interface MemberCommand {
	
	public static Logger logger = LoggerFactory.getLogger(MemberCommand.class);
	
	public Map<String, Object> execute(SqlSession sqlSession, Model model);
}
