package com.koreait.board01.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.koreait.board01.common.Paging;
import com.koreait.board01.dao.BoardDAO;
import com.koreait.board01.dto.Board;

public class ListBoardCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> modelMap = model.asMap();
		
		int totalRecord = BoardDAO.getInstance().boardCount();
		int page = (int)modelMap.get("page"); 
		int recordPerPage = 5;
		
		String paging = Paging.getPaging("selectBoardList.do", totalRecord, recordPerPage, page);
		model.addAttribute("paging", paging);
		
		int startRecord = (page - 1) * recordPerPage + 1;
		int endRecord = startRecord + recordPerPage - 1;
		if(endRecord > totalRecord) {
			endRecord = totalRecord;
		}
		
		modelMap.put("startRecord", startRecord);
		modelMap.put("endRecord", endRecord);
		
		List<Board> list = BoardDAO.getInstance().selectBoardList(modelMap);
		
		model.addAttribute("list",list);
	}

}
