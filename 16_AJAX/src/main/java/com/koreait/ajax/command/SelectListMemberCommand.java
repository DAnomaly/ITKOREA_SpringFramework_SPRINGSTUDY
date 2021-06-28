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

@Component
public class SelectListMemberCommand implements MemberCommand {

	Map<String, Object> data;
	HttpServletRequest request; 
	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {
		data = new HashMap<String, Object>();
		Map<String, Object> map = model.asMap();
		int page = (int)map.get("page");
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int totalRecord = dao.getTotalMemberCount();
		int recordPerPage = 5;
		int beginRecord = (page - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		if(endRecord > totalRecord)
			endRecord = totalRecord;
		Map<String, Integer> recordMap = new HashMap<>();
		recordMap.put("beginRecord", beginRecord);
		recordMap.put("endRecord", endRecord);
		recordMap.put("totalRecord", totalRecord);
		List<Member> list = dao.selectMemberList(recordMap);
		
		logger.info("페이지 로드됨");
		logger.info("recordMap: " + recordMap.toString());
		
		data.put("result", list.size() > 0);
		data.put("list", list);
		data.put("infoRecord", recordMap);
		return data;
	}

}
