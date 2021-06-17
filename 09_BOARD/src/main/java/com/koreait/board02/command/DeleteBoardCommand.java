package com.koreait.board02.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.board02.dao.BoardDAO;

@Component
public class DeleteBoardCommand implements BoardCommand {

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public boolean execute(Model model) {
		long no = (Long)model.asMap().get("no");
		
		int result = boardDAO.deleteBoard(no);
		if(result > 0 )
			return true;
		else
			return false;
	}

}
