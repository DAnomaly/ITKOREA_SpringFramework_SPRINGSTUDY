package com.koreait.member.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.member.dao.MemberDAO;

@Component
public class ChangePwMemberCommand implements MemberCommand {

	private static Logger logger = LoggerFactory.getLogger(ChangePwMemberCommand.class);
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {
		HttpServletRequest request = (HttpServletRequest)model.asMap().get("request");
		String pw = SecurityUtils.encodeBase64(request.getParameter("pw"));	
		String id = (String)request.getSession().getAttribute("id");
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int result = dao.changePw(pw, id);
		if(result > 0)
			logger.info("비밀번호 수정됨: " + id);
		
		request.getSession().invalidate();
	}

}
