package com.koreait.contact01.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.ContactDAO;

@Component
public class DeleteContactCommand implements ContactCommand {

	@Autowired
	ContactDAO dao;
	
	@Override
	public boolean execute(Model model) {
		
		long no = (Long)model.asMap().get("no");
		int result = dao.deleteContact(no);
		if(result > 0) {
			return true;
		} else {
			return false;
		}
		
	}

}
