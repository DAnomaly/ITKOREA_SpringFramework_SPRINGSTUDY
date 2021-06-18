package com.koreait.contact01.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.ContactDAO;
import com.koreait.contact01.dto.Contact;

@Component
public class InsertContactCommand implements ContactCommand{
	
	@Autowired
	ContactDAO dao;
	
	@Override
	public boolean execute(Model model) {
		Contact vo = (Contact)model.asMap().get("contact");
		int result = dao.insertContact(vo);
		if(result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
