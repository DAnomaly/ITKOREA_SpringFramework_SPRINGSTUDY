package com.koreait.contact02.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.contact02.dao.ContactDAO;
import com.koreait.contact02.dto.Contact;

@Component
public class UpdateContactCommand implements ContactCommand{

	@Autowired
	ContactDAO dao;
	
	@Override
	public boolean execute(Model model) {
		Contact vo = (Contact)model.asMap().get("contact");
		int result = dao.updateContact(vo);
		if(result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
