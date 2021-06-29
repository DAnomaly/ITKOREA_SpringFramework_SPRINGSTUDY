package com.koreait.ajax.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.ajax.dao.MemberDAO;
import com.koreait.ajax.dto.Member;
import com.koreait.ajax.dto.Page;
import com.koreait.ajax.util.PagingUtils;

@Component
public class SelectListMemberCommand implements MemberCommand {

	Map<String, Object> data;
	HttpServletRequest request; 
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		data = new HashMap<String, Object>();
		Map<String, Object> map = model.asMap();
		int nowpage = (int)map.get("page");
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int totalRecord = dao.getTotalMemberCount();
		Page page = PagingUtils.getPage(nowpage, totalRecord);
		List<Member> list = dao.selectMemberList(page.getBeginRecord(), page.getEndRecord());
		
		data.put("result", list.size() > 0);
		data.put("list", list);
		data.put("infoRecord", page);
		return data;
	}

}
