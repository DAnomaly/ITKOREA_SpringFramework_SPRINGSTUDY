package com.koreait.ajax.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.ajax.dao.MemberDAO;
import com.koreait.ajax.dto.Member;

@Component
public class InsertMemeberCommand implements MemberCommand {

	HttpServletResponse response;
	Map<String, Object> data;
	
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		data = new HashMap<String, Object>();
		Map<String, Object> map = model.asMap();
		response = (HttpServletResponse)map.get("response");
		Member member = (Member)map.get("member");
		System.out.println(member);

		try {
			MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
			int result = memberDAO.insertMember(member);
			data.put("result", result);
		} catch (DuplicateKeyException e) {
			// 키 위반 (아이디 중복으로 인한 위반)
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.setStatus(1001);
				response.getWriter().print("이미 사용 중인 아이디입니다.");
				return null;
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return data;
	}

}
