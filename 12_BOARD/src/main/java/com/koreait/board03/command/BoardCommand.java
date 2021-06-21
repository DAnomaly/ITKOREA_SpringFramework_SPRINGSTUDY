package com.koreait.board03.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BoardCommand {

	public void execute(Model model, SqlSession sqlSession);
	
}
